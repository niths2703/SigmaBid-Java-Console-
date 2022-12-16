package com.masai.usecases;

import java.util.List;

import com.masai.custom.ConsoleColors;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.TenderException;
import com.masai.model.Tender;

public class DisplayAllTendersUseCase {

	public static void displayTenders() {
		
		AdminDao dao=new AdminDaoImpl();
		
		try {
			List<Tender> tenders = dao.displayAllTenders();
			
			System.out.println("---------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of All Tenders " + ConsoleColors.RESET+ "---------------------");
			
			System.out.println("---------------------------------------------------------------------");
			
			System.out.printf("%7s %16s %7.5s %7.5s %7s %7.5s %7.5s",ConsoleColors.BLACK_BOLD + "T_ID", "T_NAME", "T_TYPE", "T_PRICE", "T_DESC","T_DEADLINE" ,"T_LOCATION"+ ConsoleColors.RESET);
			System.out.println();
			System.out.print("---------------------------------------------------------------------");
			
			System.out.println();
			for(Tender t: tenders) {
				
				System.out.format("%7s %16s %7.5s %7.5s %7s %7.5s %7.5s",t.getT_id(),t.getT_name(), t.getT_type(),t.getT_price(),t.getT_desc(),t.getT_deadline(),t.getT_location());
				System.out.println();
			}
			
			System.out.println("---------------------------------------------------------------------");
	
		} catch (TenderException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
	}
}
