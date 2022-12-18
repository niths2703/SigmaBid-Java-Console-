package com.masai.main;

import com.masai.custom.ConsoleColors;
import com.masai.usecases.CreateBidUseCase;
import com.masai.usecases.DisplayAllTendersUseCase2;
import com.masai.usecases.ShowBidHistoryOfVendorUseCase;
import com.masai.usecases.ShowBidStatusUseCase;
import com.masai.usecases.VendorLoginUseCase;

public class VendorMain {

	public static boolean VendorLogin() {
		VendorLoginUseCase login=new VendorLoginUseCase();
		
		return login.vendorLogin();	
	}
	
	public static void  VendorWindow() {
		System.out.println(ConsoleColors.BROWN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to Vendor Home Window : "+ ConsoleColors.RESET);
		System.out.println("Press 1 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Create a Bid." + ConsoleColors.RESET);
		System.out.println("Press 2 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" View List of all Tenders." + ConsoleColors.RESET);
		System.out.println("Press 3 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" View Status Of a Bid" + ConsoleColors.RESET);
		System.out.println("Press 4 to"+ConsoleColors.PURPLE_BOLD_BRIGHT+" View My Bid History." + ConsoleColors.RESET);
		System.out.println("Press 5 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" LOGOUT AND RETURN TO HOMEPAGE" + ConsoleColors.RESET);
	}
	
	public static void viewListOfAllTenders() {
		DisplayAllTendersUseCase2 d= new DisplayAllTendersUseCase2();
		
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
