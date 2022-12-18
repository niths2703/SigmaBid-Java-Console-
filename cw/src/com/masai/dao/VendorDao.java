package com.masai.dao;

import java.util.List;

import com.masai.exception.BidException;
import com.masai.exception.CredentialException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;

public interface VendorDao {

	public String vendorLogin(String email, String password) throws CredentialException, VendorException;

	public String createBid(Bid b) throws BidException;
	
	public List<Tender> displayAllTenders() throws TenderException;
	
	public boolean showStatusOfBid(int bid_id) throws BidException;
	
	public List<Bid> showHistoryOfBidsForVendor() throws VendorException,BidException;
}
