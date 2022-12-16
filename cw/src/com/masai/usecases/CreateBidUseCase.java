package com.masai.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.exception.BidException;
import com.masai.model.Bid;

public class CreateBidUseCase {
	
	public static void createBid() {
		
		Scanner sc=new Scanner(System.in);
		
		
		try {
			
			System.out.println("Enter Vendor Id : ");
			int vendor_id=sc.nextInt();
			
			System.out.println("Enter Tendor Id : ");
			int tender_id=sc.nextInt();
			
			System.out.println("Enter Bid value :");
			double bid_value=sc.nextDouble();
			
			
			System.out.println("Enter Bid status :");
			boolean bid_status=sc.nextBoolean();
			
			Bid b=new Bid();
			
			b.setV_id(vendor_id);
			b.setT_id(tender_id);
			b.setBid_value(bid_value);
			b.setBid_status(bid_status);
			
			
			VendorDao dao=new VendorDaoImpl();
			
			String result;
			
			try {
				result = dao.createBid(b);
				System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);

			} catch (BidException e) {
				result = e.getMessage();
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			
			}
			
			
			
			
		}
		catch (InputMismatchException i) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
		}
	}

}
