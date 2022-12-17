package com.masai.main;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.masai.custom.ConsoleColors;

public class Main {

	public static void appStart() {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.println(ConsoleColors.BROWN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to Tender Management Application : "+ ConsoleColors.RESET);
			System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Choose Login Option from Below According to your Designation  : " + ConsoleColors.RESET);
			System.out.println("Press 1 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + " LogIn as Admin." + ConsoleColors.RESET);
			System.out.println("Press 2 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + " LogIn as Vendor."+ ConsoleColors.RESET);
			System.out.println("Press 3 to" +ConsoleColors.PURPLE_BOLD_BRIGHT +" EXIT."+ ConsoleColors.RESET);
			String choice = sc.nextLine();
			
			
			if(choice.equals("1")) {
				
				AdminMain am=new AdminMain();
				boolean mainresult= am.adminLogin();
				
               int revAdminCount =1;
				
               //Limit Attempts
				while(!mainresult) {
					revAdminCount++;
					System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + (4-revAdminCount) +" Attempts remaining"+ ConsoleColors.RESET);
					mainresult = am.adminLogin();
					
					if(revAdminCount ==3 && mainresult ==false) {
						System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Maximum Limit Crossed : Try Again Later"+ ConsoleColors.RESET);
						break;
						
					}
				}
				
			
				if(mainresult) {
					
					while(true) {
						
						am.adminHome();
						
						String choiceAdmin=sc.nextLine();
						
						if(choiceAdmin.equals("1")) {
							am.createTender();
						}
						else if(choiceAdmin.equals("2")) {
							am.viewListOfTenders();
						}
						else if(choiceAdmin.equals("3")) {
							am.RegisterVendor();
						}
						else if(choiceAdmin.equals("4")) {
							am.viewListOfVendors();
						}
						else if(choiceAdmin.equals("5")) {
							am.assignTenderToVendor();
						}
						else if(choiceAdmin.equals("6")) {
							am.viewAllBidsOfTender();
						}
						else if(choiceAdmin.equals("7")) {
							System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "LOGOUT SUCCESSFUL !" + ConsoleColors.RESET);				
							break;
						}
						else {
							System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "CHOOSE CORRECT INPUT RANGE FROM 1 TO 7" + ConsoleColors.RESET);
						}
					}
					appStart();
						
					
				}else {
					appStart();
				}
				
			}
			else if(choice.equals("2")) {
				
				VendorMain vm=new VendorMain();
				boolean vendorresult=vm.VendorLogin();
				
				
				int revVendorCount=1;
				while(!vendorresult) {
					revVendorCount++;
					
					System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + (4-revVendorCount) +" Attempts remaining"+ ConsoleColors.RESET);
					vendorresult = vm.VendorLogin();
					
					if(revVendorCount ==3 && vendorresult ==false) {
						System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Maximum Limit Crossed : Try Again Later"+ ConsoleColors.RESET);
						break;
						
					}
				}
				
				
				if(vendorresult) {
					
					while(true) {
						
						vm.VendorWindow();
						
						String choiceVendor=sc.nextLine();
						
						if(choiceVendor.equals("1")) {
						vm.createBidAgainstTender();	
						}
						else if(choiceVendor.equals("2")) {
							vm.viewListOfAllTenders();
						}
						else if(choiceVendor.equals("3")) {
							vm.showBidStatus();
						}
						else if(choiceVendor.equals("4")) {
							vm.showBidHistory();
						}
						else if(choiceVendor.equals("5")) {
							System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "LOGOUT SUCCESSFUL !" + ConsoleColors.RESET);
							break;
						}
						else {
							System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "CHOOSE CORRECT INPUT RANGE FROM 1 TO 5" + ConsoleColors.RESET);
						}
						
					}
					
					appStart();
				}
				else {
					appStart();
				}
			}
		else if(choice.equals("3")) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "APPLICATION CLOSED : EXITED" + ConsoleColors.RESET);
			System.exit(0);
			
		}else {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "CHOOSE CORRECT INPUT RANGE FROM 1 TO 3" + ConsoleColors.RESET);
			appStart();
			
		}
			
		
			
			
		}
		catch(InputMismatchException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		catch(NoSuchElementException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
	}
	
	public static void main(String[] args) {
		appStart();
	}
}
