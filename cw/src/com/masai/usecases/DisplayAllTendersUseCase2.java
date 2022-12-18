package com.masai.usecases;

import java.util.List;

import com.masai.custom.ConsoleColors;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.exception.VendorException;
import com.masai.model.Vendor;

public class DisplayAllTendersUseCase2 {
	
	public static void displayAllVendors() {
		
		VendorDao dao = new VendorDaoImpl();
				
				try {
					List<Vendor> vendors = dao.displayAllVendors();
					
					
					System.out.println("------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all Vendors Present" + ConsoleColors.RESET+ "---------------");
					
					System.out.println("---------------------------------------------------------------------");
					
					System.out.printf("%7s %16s %12s %12.5s %10s %10s %10s",ConsoleColors.BLACK_BOLD + "V_ID", "V_NAME", "V_MOB", "V_EMAIL","PASSWORD", "COMPANY","ADDRESS" + ConsoleColors.RESET);
					System.out.println();
					System.out.print("---------------------------------------------------------------------");
					
					System.out.println();
					for(Vendor v: vendors) {
						
						System.out.format("%7s %16s %12s %12.5s %10s %10s %10s",v.getV_id(),v.getV_name(),v.getV_mob(),v.getEmail(),v.getPassword(),v.getCompany(),v.getAddress());
						System.out.println();
					}
					
					System.out.println("---------------------------------------------------------------------");
				} 
				catch (VendorException e) {
					System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
				}
			}

}
