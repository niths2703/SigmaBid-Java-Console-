package com.masai.dao;

import java.util.List;

import javax.security.auth.login.CredentialException;

import com.masai.exception.BidException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;

public interface AdminDao {

	public final String username="admin";
	public final String password="admin";
	
	public String adminLogin(String username,String password) throws CredentialException;
    
	public String createTender(Tender t) throws TenderException;
    
	public List<Tender> displayAllTenders() throws TenderException;
	
	public String registerVendor(Vendor v) throws VendorException;
	
	public List<Vendor> displayAllVendors() throws VendorException;
	
	public String assignTenderToVendor(int t_id, int v_id) throws TenderException,VendorException,BidException;
	
	public List<Bid> displayAllBids() throws BidException;
    
    
    
}
 