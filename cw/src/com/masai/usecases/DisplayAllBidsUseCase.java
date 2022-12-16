package com.masai.usecases;

import java.util.List;

import com.masai.custom.ConsoleColors;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.BidException;
import com.masai.model.Bid;

public class DisplayAllBidsUseCase {

	public static void displayBids() {
		
AdminDao dao = new AdminDaoImpl();
		
		try {
			List<Bid> bids = dao.displayAllBids();
			
			System.out.println("---------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Bids Present" + ConsoleColors.RESET+ "---------------------");
			
			System.out.println("---------------------------------------------------------------------");
			
			System.out.printf("%7s %7.5s %7s %15s %17s",ConsoleColors.BLACK_BOLD + "B_ID", "V_ID", "T_ID", "BID_VALUE", "BID_STATUS" + ConsoleColors.RESET);
			System.out.println();
			System.out.print("---------------------------------------------------------------------");
			
			System.out.println();
			for(Bid b: bids) {
				
				System.out.format("%7s %7.5s %7s %15s %17s",b.getB_id(),b.getV_id(),b.getT_id(),b.getBid_value(),b.isBid_status());
				System.out.println();
			}
			
			System.out.println("---------------------------------------------------------------------");
	
		} catch (BidException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
	}
}
