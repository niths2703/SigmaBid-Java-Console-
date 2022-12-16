package com.masai.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.VendorException;
import com.masai.model.Vendor;

public class CreateVendorUseCase {

	public static boolean flag=false;
	
	public static void createVendor() {
		
		Scanner sc=new Scanner(System.in);
		
		try {
			
			System.out.println("Enter Vendor Name:");
			String name=sc.next();
			
			System.out.println("Enter Vendor Mobile:");
			double mob=sc.nextDouble();
			
			System.out.println("Enter Vendor Email:");
			String email=sc.next();
			
			System.out.println("Enter Vendor Company:");
			String comp=sc.next();
			
			System.out.println("Enter Vendor Address:");
			String add=sc.next();
			
			System.out.println("Enter Vendor Password:");
			System.out.println(ConsoleColors.BLUE_ITALIC+"(Password must contain 8 characters and should have atleast 1 Upper Case, 1 Small Case, 1 Number and 1 Special Character)"+ ConsoleColors.RESET);
			boolean flag = false;
			String password = null;
			while(!flag) {
				password = sc.nextLine();
				flag = password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
				
				if(flag) {
					break;
				}
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Invalid Password Pattern" + ConsoleColors.RESET);
				System.out.println(ConsoleColors.RED_ITALIC+"(Password must contain 8 characters and should have atleast 1 Upper Case, 1 Small Case, 1 Number and 1 Special Character)"+ ConsoleColors.RESET);
			}
			
			
			Vendor v=new Vendor();
			
			v.setV_name(name);
			v.setV_mob(mob);
			v.setEmail(email);
			v.setPassword(password);
			v.setCompany(comp);
			v.setAddress(add);
			
			AdminDao dao=new AdminDaoImpl();
			String result;
			
			try {
				result=dao.registerVendor(v);
				System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			} catch (VendorException e) {
				result = e.getMessage();
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			}
			
			
			
			
			
			
			
		}
		catch (InputMismatchException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
		}
		
		
	}
}
