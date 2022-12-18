package com.masai.main;

import com.masai.custom.ConsoleColors;
import com.masai.usecases.AdminLoginUseCase;
import com.masai.usecases.AssignTenderToVendorUseCase;
import com.masai.usecases.CreateTenderUseCase;
import com.masai.usecases.CreateVendorUseCase;
import com.masai.usecases.DisplayAllBidsUseCase;
import com.masai.usecases.DisplayAllTendersUseCase;
import com.masai.usecases.DisplayAllVendorsUseCase;

public class AdminMain {

	public boolean adminLogin() {
		AdminLoginUseCase login=new AdminLoginUseCase();
		
		boolean r=login.adminLogin();
		return r;
	}

	public static void adminHome() {
		System.out.println(ConsoleColors.BROWN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to Admin Home Window : "+ ConsoleColors.RESET);
		System.out.println("Press 1 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Create new Tender." + ConsoleColors.RESET);
		System.out.println("Press 2 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" View List of all Tenders." + ConsoleColors.RESET);
		System.out.println("Press 3 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Register a Vendor " + ConsoleColors.RESET);
		System.out.println("Press 4 to"+ConsoleColors.PURPLE_BOLD_BRIGHT+" View List of all Vendors " + ConsoleColors.RESET);
		System.out.println("Press 5 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Assign any Tender Bid to a Vendor" + ConsoleColors.RESET);
		System.out.println("Press 6 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" View List of all Bids  " + ConsoleColors.RESET);
		System.out.println("Press 7 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" LOGOUT AND RETURN TO HOMEPAGE" + ConsoleColors.RESET);	
	}
	
	public static void createTender(){
		CreateTenderUseCase cr=new CreateTenderUseCase();
		cr.createTender();
	}
	
	public static void viewListOfTenders() {
		DisplayAllTendersUseCase d=new DisplayAllTendersUseCase();
		d.displayTenders();
	}
	
	public static void RegisterVendor() {
		CreateVendorUseCase cr=new CreateVendorUseCase();
		cr.createVendor();
	}
	
	public static void viewListOfVendors() {
		DisplayAllVendorsUseCase d=new DisplayAllVendorsUseCase();
		d.displayAllVendors();
	}
	
	public static void viewAllBidsOfTender() {
		DisplayAllBidsUseCase d=new DisplayAllBidsUseCase();
		d.displayBids();
	}
	
	public static void assignTenderToVendor() {
		AssignTenderToVendorUseCase a=new AssignTenderToVendorUseCase();
		a.AssignTendorToVendor();
	}
}
