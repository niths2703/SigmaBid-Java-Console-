package com.masai.usecases;

import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.exception.BidException;
import com.masai.model.Bid;

public class ShowBidStatusUseCase {

	public static void showBidStatus() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Vendor ID");
		int v_id = sc.nextInt();
		
		System.out.println("Enter Bid ID");
		int b_id = sc.nextInt();
		
		
		VendorDao dao = new VendorDaoImpl();
		
		try {
			boolean b =  dao.showStatusOfBid(b_id, v_id);
			
			System.out.println("--" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Status Of Bid with bid_id " +b_id +" and vendor_id" +v_id+ ConsoleColors.RESET+ "----");
			
			
			
			
			
		} catch (BidException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
	}
}
