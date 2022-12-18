package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.exception.BidException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;


public class ShowBidHistoryOfVendorUseCase {

	public static void ShowBidHistory() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("My Bid History Is : ");
		
		
		
		VendorDao dao=new VendorDaoImpl();
		
		try {
			List<Bid> bids =  dao.showHistoryOfBidsForVendor();
			
			System.out.println("--" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all my Bids  "  + ConsoleColors.RESET+ "----");
			
			System.out.println("-------------------------------------------------------------");
			
			System.out.printf("%7s %7s %7s %10s %10s",ConsoleColors.BLACK_BOLD + "BID_ID","VENDOR_ID","TENDOR_ID","BID_VALUE","BID_STATUS"  +ConsoleColors.RESET);
			System.out.println();
			System.out.print("-------------------------------------------------------------");
			
			System.out.println();
			for(Bid b: bids) {
				
				System.out.format("%7s %7s %7s %10s %10s",b.getB_id(),b.getV_id(),b.getT_id(),b.getBid_value(),b.isBid_status());
				System.out.println();
			}
			
			System.out.println("-------------------------------------------------------------");
			
			
			
			
		}catch (BidException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		} catch (VendorException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
		
	}
}
