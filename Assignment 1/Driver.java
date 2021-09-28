import java.util.*;

// -----------------------------------------------------
// Assignment 1 - COMP 6481
// © Dhananjay Narayan, Nilesh Aggarwal
// Written by: Dhananjay Narayan (40164521), Nilesh Aggarwal( )
// ----------------------------------------------------- 

public class Driver {
	public static String password = "password";
	public static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("=============================");
        System.out.println("Welcome to the Computer Store");
		System.out.println("=============================");
		System.out.println();
		
		System.out.println("Enter the maximum number of Computers your store can have: \n");
		
		int maxComputers = sc.nextInt();
		
		Computer[] inventory = new Computer[maxComputers];
		
		while(true) {
			System.out.println("What do you want to do?\n");
			System.out.println("1. Enter new computers (password required)");
			System.out.println("2. Change information of a computer (password required)");
			System.out.println("3. Display all computers by a specific brand");
			System.out.println("4. Display all computers under a certain a price.");
			System.out.println("5. Quit\n");
			System.out.println("Please enter your choice >");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1: 
				
				System.out.println("Enter the password. You will have a max of 3 chances.");
				boolean passwordStatus = passwordCheck();
				
				if(passwordStatus==false) {
					break;
				}
				System.out.println("How many computers do you want to add in the inventory?");
				int noOfCompToAdd = sc.nextInt();
				
				
			}
		}
		
	}

	public static boolean passwordCheck() {
		// TODO Auto-generated method stub
		for(int i=1;i<=3;i++) {
			System.out.println("Attempt "+i+" : ");
			
			System.out.println("Enter the password:");
			String enteredPassword = sc.next()	;
			
			if(enteredPassword.equals(password)) {
				System.out.println("You are now Logged In.");
				return true;
			}
			else {
				System.out.println("Incorrect Password!!!");
				continue;				
			}			
			}		
		return false;
	}

}
