package com.masai.main;

import com.masai.usecases.CreateBidUseCase;
import com.masai.usecases.DisplayAllVendorsUseCase2;
import com.masai.usecases.ShowBidHistoryOfVendorUseCase;
import com.masai.usecases.ShowBidStatusUseCase;
import com.masai.usecases.VendorLoginUseCase;

public class VendorMain {

	public static boolean VendorLogin() {
		VendorLoginUseCase login=new VendorLoginUseCase();
		
		return login.vendorLogin();	
	}
	
	public static void viewListOfAllTenders() {
		DisplayAllVendorsUseCase2 d= new DisplayAllVendorsUseCase2();
		
		d.displayAllVendors();
	}
	
	public static void createBidAgainstTender() {
		CreateBidUseCase cr=new CreateBidUseCase();
		cr.createBid();
	}
	
	public static void showBidStatus() {
		ShowBidStatusUseCase b=new ShowBidStatusUseCase();
		b.showBidStatus();
	}
	
	public static void showBidHistory() {
		ShowBidHistoryOfVendorUseCase b=new ShowBidHistoryOfVendorUseCase();
		b.ShowBidHistory();
		
	}
}
