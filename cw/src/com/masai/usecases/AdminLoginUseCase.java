package com.masai.usecases;

import java.util.Scanner;

import javax.security.auth.login.CredentialException;

import com.masai.custom.ConsoleColors;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class AdminLoginUseCase {
	
	public static boolean adminLogin() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Username :");
		
		String username=sc.next();
		
		System.out.println("Enter Password :");
		
		String password=sc.next();
		
		AdminDao dao=new AdminDaoImpl();
		
		String result;
		
		try {
			result=dao.adminLogin(username, password);
			
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return true;
		} catch (CredentialException e) {
			
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return false;
				
		}
		
		
		
	}

}
