package com.masai.usecases;

import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.BidException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;

public class AssignTenderToVendorUseCase {

	public static void AssignTendorToVendor() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter tender id to assign:");
		int t_id=sc.nextInt();
		
		System.out.println("Enter vendor id to assign:");
		int v_id=sc.nextInt();
		
		AdminDao dao = new AdminDaoImpl();
		String result;
		
		try {
			result = dao.assignTenderToVendor(t_id, v_id);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} catch (TenderException e) {
			
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			
		} catch (VendorException e) {
			
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			
		} catch (BidException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		}
		
		
		
		
		
	}
}
