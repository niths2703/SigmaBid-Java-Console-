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

import com.masai.exception.BidException;
import com.masai.exception.CredentialException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;
import com.masai.utility.DBUtil;

public class VendorDaoImpl implements VendorDao {

	public static int vendor_id;
	
	
	@Override
	public String vendorLogin(String email, String password) throws CredentialException, VendorException {
		String m="Login failed!!";
		
		try(Connection conn =DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from vendor");
			
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
			
			ps.setInt(1, vendor_id);
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
				
				java.sql.Date d=rs.getDate("t_deadline");
				@SuppressWarnings("deprecation")
				java.util.Date utilDate = new java.util.Date(d.getDate());
				LocalDate t_deadline=utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
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
	public boolean showStatusOfBid(int bid_id) throws BidException {
		
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
	public List<Bid> showHistoryOfBidsForVendor() throws VendorException, BidException {
		
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
