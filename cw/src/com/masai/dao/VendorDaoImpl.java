package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.BidException;
import com.masai.exception.CredentialException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;
import com.masai.model.Vendor;
import com.masai.utility.DBUtil;

public class VendorDaoImpl implements VendorDao {

	public static int vendor_id;
	
	
	@Override
	public String vendorLogin(String email, String password) throws CredentialException, VendorException {
		String m="Login failed!!";
		
		try(Connection conn =DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from vendors");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				String mail=rs.getString("v_email");
				String pass=rs.getString("password");
				
				if(mail.equals(email) & pass.equals(password)) {
					m="Login successful!!";
					vendor_id=rs.getInt("v_id");
					return m;
					
				}
			}
			
			m="Wrong Credentials!!";
			throw new CredentialException(m);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public String createBid(Bid b) throws BidException {
		
		String m="Bid not created";
		
		try(Connection conn =DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into bid(v_id, t_id, bid_value, bid_status) values(?,?,?,?)");
			
			ps.setInt(1, b.getV_id());
			ps.setInt(2, b.getT_id());
			ps.setDouble(3, b.getBid_value());
			ps.setBoolean(4,b.isBid_status());
			
			int x=ps.executeUpdate();
			
			if(x>0){
			  	m="Bid Created";
			}
			else {
				throw new BidException(m);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BidException(e.getMessage());
		}
		
		return m;
	}

	@Override
	public List<Vendor> displayAllVendors() throws VendorException {
		
		List<Vendor> vendors=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from vendors");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				Vendor v=new Vendor();
				
				v.setV_id(rs.getInt("v_id"));
				v.setPassword(rs.getString("password"));
				v.setV_name(rs.getString("v_name"));
				v.setV_mob(rs.getInt("v_mob"));
				v.setEmail(rs.getString("v_email"));
				v.setCompany(rs.getString("company"));
				v.setAddress(rs.getString("address"));
				
				vendors.add(v);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(vendors.size()==0) {
			throw new VendorException("No Vendors Here");
		}
		
		return vendors;
	}

	@Override
	public boolean showStatusOfBid(int bid_id,int vendor_id) throws BidException {
		
		try(Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select bid_status from bid where b_id=? and v_id=?");
			
			
			ps.setInt(1, bid_id);
			ps.setInt(2, vendor_id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				return rs.getBoolean("bid_status");
			}
			else {
				throw new BidException("No Bid with bid id"+bid_id+"vendor_id with v_id"+vendor_id);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BidException(e.getMessage());
		}
	}

	@Override
	public List<Bid> showHistoryOfBidsForVendor(int vendor_id) throws VendorException, BidException {
		
	List<Bid> bids=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from bid where v_id=?");
			ps.setInt(1, vendor_id);
			
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
			throw new VendorException("No Bids for Vendor with id: "+vendor_id);
		}
		
		return bids;
	}

}
