package com.masai.usecases;

import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.exception.CredentialException;
import com.masai.exception.VendorException;

public class VendorLoginUseCase {

	public static boolean vendorLogin() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("====VENDOR LOGIN====");
		System.out.println("Enter Email : ");
		String email = sc.nextLine();
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		
		VendorDao dao = new VendorDaoImpl();
		 
		
		
		String result;
		
		try {
			result= dao.vendorLogin(email, password);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return true;
			
		} catch (CredentialException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return false;
		} catch (VendorException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return false;
		}
		
	}
}
