package com.masai.usecases;

import java.util.List;

import com.masai.custom.ConsoleColors;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.Tender;
import com.masai.model.Vendor;

public class DisplayAllTendersUseCase2 {
	
	public static void displayAllTenders() {
		
		VendorDao dao = new VendorDaoImpl();
				
				try {
					List<Tender> tenders = dao.displayAllTenders();
					
					
					System.out.println("------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all Vendors Present" + ConsoleColors.RESET+ "---------------");
					
					System.out.println("---------------------------------------------------------------------");
					
					System.out.printf("%7s %16s %12s %12.5s %10s %10s %10s",ConsoleColors.BLACK_BOLD + "T_ID", "T_NAME", "T_TYPE", "T_PRICE","T_DESC", "T_DEADLINE","T_LOCATION" + ConsoleColors.RESET);
					System.out.println();
					System.out.print("---------------------------------------------------------------------");
					
					System.out.println();
					for(Tender t:tenders) {
						
						System.out.format("%7s %16s %12s %12.5s %10s %10s %10s",t.getT_id(),t.getT_name(),t.getT_type(),t.getT_price(),t.getT_desc(),t.getT_deadline(),t.getT_location());
						System.out.println();
					}
					
					System.out.println("---------------------------------------------------------------------");
				} 
				catch (TenderException e) {
					System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
				}
			}

}
