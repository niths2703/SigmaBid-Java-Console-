package com.masai.dao;

import java.util.List;

import com.masai.exception.BidException;
import com.masai.exception.CredentialException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;
import com.masai.model.Vendor;

public interface VendorDao {

	public String vendorLogin(String email, String password) throws CredentialException, VendorException;

	public String createBid(Bid b) throws BidException;
	
	public List<Vendor> displayAllVendors() throws VendorException;
	
	public boolean showStatusOfBid(int bid_id,int vendor_id) throws BidException;
	
	public List<Bid> showHistoryOfBidsForVendor(int vendor_id) throws VendorException,BidException;
}
