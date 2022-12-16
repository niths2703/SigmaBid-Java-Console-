package com.masai.usecases;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.TenderException;
import com.masai.model.Tender;

public class CreateTenderUseCase {
	
	public static void createTender() {
		
		Scanner sc=new Scanner(System.in);
		
		try {
		System.out.println("Enter Tender Name:");
		String name=sc.next();
		
		System.out.println("Enter Tender Type:");
		String type=sc.next();
		
		System.out.println("Enter Tender Price:");
		int price=sc.nextInt();
		
		System.out.println("Enter Tender Description:");
		String desc=sc.next();
		
		System.out.println("Enter Tender Deadline: (YYYY-MM-DD)");
		
		String d=sc.next();
		LocalDate date=LocalDate.parse(d,DateTimeFormatter.ISO_DATE);
		
		System.out.println("Enter Tender Location:");
		String loc=sc.next();
		
		Tender t=new Tender();
		
		t.setT_name(name);
		t.setT_type(type);
		t.setT_price(price);
		t.setT_desc(desc);
		t.setT_deadline(date);
		t.setT_location(loc);
		
		AdminDao dao=new AdminDaoImpl();
		String result;
		
		
		
		try {
			result =dao.createTender(t);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} catch (TenderException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		}
	}
		 catch (InputMismatchException i) {
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
			}
		
	}

}
