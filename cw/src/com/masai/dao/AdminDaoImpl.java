package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.CredentialException;

import com.masai.exception.BidException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;
import com.masai.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

//	Login into account
	@Override
	public String adminLogin(String username, String password) throws CredentialException {
		
		String result="Invalid Credentials!!";
		
		if(username.equals(AdminDao.username) & password.equals(AdminDao.password)) {
	       result="Login Successful. Welcome to Admin Interface.";		
		}
		else {
			throw new CredentialException(result);
		}
		
		return result;
	}

//Create a Tender
	@Override
	public String createTender(Tender t) throws TenderException {
		String m="Tender could not be created";
		
		try(Connection conn =DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("insert into tender(t_name,t_type,t_price,t_desc,t_deadline,t_location) values(?,?,?,?,?,?) ");
			
			
			ps.setString(1, t.getT_name() );
			ps.setString(2, t.getT_type());
			ps.setInt(3,t.getT_price());
			ps.setString(4, t.getT_desc());
			Date d=java.sql.Date.valueOf(t.getT_deadline());
			ps.setDate(5, (java.sql.Date) d);
			ps.setString(6, t.getT_location());
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				m="Tender Created";
			}
			else {
				throw new TenderException(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public List<Tender> displayAllTenders() throws TenderException {
		
		List<Tender> tenders=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from tender");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int t_id=rs.getInt("t_id");
				String t_name=rs.getString("t_name");
				String t_type=rs.getString("t_type");
				int t_price=rs.getInt("t_price");
				String t_desc=rs.getString("t_desc");
				
				Date d=rs.getDate("t_deadline");
				LocalDate t_deadline=d.toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate();
				String t_location=rs.getString("t_location");
				
				Tender t=new Tender();
				t.setT_id(t_id);
				t.setT_name(t_name);
				t.setT_type(t_type);
				t.setT_price(t_price);
				t.setT_desc(t_desc);
				t.setT_deadline(t_deadline);
				t.setT_location(t_location);
			
				tenders.add(t);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new TenderException(e.getMessage());
		}
		
		if(tenders.size()==0) {
		    throw new TenderException("No Tenders");
		}
		
		return tenders;
	}

	@Override
	public String registerVendor(Vendor v) throws VendorException {
		String m="Vendor not registered";
		
		try(Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into vendor(password,v_name,v_mob,v_email,company,address) values (?,?,?,?,?,?)");
		
		ps.setString(1,v.getPassword());
		ps.setString(2,v.getV_name());
		ps.setDouble(3, v.getV_mob());
		ps.setString(4, v.getEmail());
		ps.setString(5, v.getCompany());
		ps.setString(6, v.getAddress());
		
		int x=ps.executeUpdate();
		
		if(x>0) {
			m="New Vendor Registered";
		}
		else {
			throw new VendorException(m);
		}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new VendorException(m);
		}
		
		return m;
	}

	@Override
	public List<Vendor> displayAllVendors() throws VendorException {
		List<Vendor> vendors=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from vendor");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				Vendor v=new Vendor();
				
				v.setV_id(rs.getInt("v_id"));
				v.setPassword(rs.getString("password"));
				v.setV_name(rs.getString("v_name"));
				v.setV_mob(rs.getDouble("v_mob"));
				v.setEmail(rs.getString("v_email"));
				v.setCompany(rs.getString("company"));
				v.setAddress(rs.getString("address"));
				
				vendors.add(v);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new VendorException(e.getMessage());
		}
		
		
		if(vendors.size()==0) {
			throw new VendorException("No Vendors");
		}
		return vendors;
	}

	@Override
	public String assignTenderToVendor(int t_id, int v_id) throws TenderException, VendorException, BidException {
	
		String m="tender not assigned";
		
		try(Connection conn =DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from vendor where v_id = ?");
			ps.setInt(1,v_id);
			
			ResultSet rs=ps.executeQuery();
			
			 if(rs.next()) {
				 
				 PreparedStatement ps2=conn.prepareStatement("select * from bid where t_id = ?");
				 
				 ps2.setInt(1, t_id);
				 
				 ResultSet rs2=ps2.executeQuery();
				 
				 if(rs2.next()) {
					 
					 PreparedStatement ps3=conn.prepareStatement("update bid set t_id = ? where v_id = ?  ");
					 
					 ps3.setInt(1, t_id);
					 ps3.setInt(2, v_id);
					 
					 int x= ps3.executeUpdate();
					 
					 if(x>0) {
						 m="Tender with tender id:"+ t_id+"assigned to vendor with vendor id:"+ v_id;
						 return m;
					 }
					 
					 
				 }else {
					 throw new TenderException("Bid does not exist with tendor id:"+ t_id);
				 }
				 
				 
			 }
			 else {
				 throw new VendorException("Vendor does not exist with vendor id: "+ v_id);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new TenderException(e.getMessage());
		}
		
		return m;
	}

	@Override
	public List<Bid> displayAllBids() throws BidException {
		
		List<Bid> bids=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from bid");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				Bid b=new Bid();
				
				b.setB_id(rs.getInt("b_id"));
				b.setV_id(rs.getInt("v_id"));
				b.setT_id(rs.getInt("t_id"));
				b.setBid_value(rs.getDouble("bid_value"));
				b.setBid_status(rs.getBoolean("bid_status"));
				
				bids.add(b);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BidException(e.getMessage());
		}
		
		if(bids.size()==0) {
			throw new BidException("No Bids");
		}
		
		return bids;
	}

}
