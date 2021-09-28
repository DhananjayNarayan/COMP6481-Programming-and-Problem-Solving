import java.util.*;

// -----------------------------------------------------
// Assignment 1 - COMP 6481
// © Dhananjay Narayan, Nilesh Aggarwal
// Written by: Dhananjay Narayan (40164521), Nilesh Aggarwal( )
// ----------------------------------------------------- 

public class Driver {

	public static void main(String[] args) {
		String password = "password";
		
		System.out.println(password);
		
		// TODO Auto-generated method stub
		System.out.println("=============================");
        System.out.println("Welcome to the Computer Store");
		System.out.println("=============================");
		System.out.println();
		
		System.out.println("Enter the maximum number of Computers your store can have: ");
		Scanner sc= new Scanner(System.in);
		int maxComputers = sc.nextInt();
		
		Computer[] inventory = new Computer[maxComputers];
		
		while(true) {
			System.out.println("What do you want to do?");
			System.out.println("1. Enter new computers (password required)");
			System.out.println("2. Change information of a computer (password required)");
			System.out.println("3. Display all computers by a specific brand");
			System.out.println("4. Display all computers under a certain a price.");
			System.out.println("5. Quit");
			System.out.println("Please enter your choice >");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			}
		}
		
	}

}
