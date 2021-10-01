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
		
		System.out.println("Enter the maximum number of Computers your store can have: ");
		
		int maxComputers = sc.nextInt();
		
		//array to store the computer objects
		Computer[] inventory = new Computer[maxComputers];
		
		//Main menu
		while(true) {
			System.out.println("\n What do you want to do?\n");
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
				
				int computersTillNow = Computer.findNumberOfCreatedComputers();
				System.out.println("Already created computers till now: "+computersTillNow+ " out of "+maxComputers);
				int availableSpace = maxComputers - computersTillNow;
				if(noOfCompToAdd>availableSpace) {
					System.out.println("NO ENOUGH SPACE TO ADD. The available space is "+availableSpace);
					break;
				}
				else {
					for(int i=1;i<=noOfCompToAdd;i++) {
						System.out.println("Enter the Brand of Computer "+i+" of "+noOfCompToAdd+" computers to be added.");
						String brand = sc.next();
						System.out.println("Enter the Model of Computer "+i+" of "+noOfCompToAdd+" computers to be added.");
						String model = sc.next();
						System.out.println("Enter the Serial Number of Computer "+i+" of "+noOfCompToAdd+" computers to be added.");
						long SN=sc.nextLong();
						System.out.println("Enter the Price of Computer "+i+" of "+noOfCompToAdd+" computers to be added.");
						double price=sc.nextDouble();
						inventory[computersTillNow]= new Computer(brand,model,SN,price);
						System.out.println(inventory[computersTillNow].toString());
						computersTillNow++;
					}
					System.out.println("Total Computers now added is: "+Computer.findNumberOfCreatedComputers()+" of "+maxComputers);
				}
				continue;
				
			case 2:
				System.out.println("Enter the password. You will have a max of 3 chances.");
				boolean passwordCheck = passwordCheck();
				
				if(passwordCheck==false) {
					break;
				}
				
				while(true) {
					
				
				System.out.println("Enter the Computer Number (STARTING with 0) that you want to modify: ");
				int compNoToModify = sc.nextInt();
				
				if(compNoToModify<0 || compNoToModify>=Computer.findNumberOfCreatedComputers() || inventory[compNoToModify]==null) {
					System.out.println("There is no computer at this location. Do you want to try a different computer number?");
					System.out.println("Press 1 for Yes or any other number key to exit!");
					int c = sc.nextInt();
					if(c==1) {
						continue;
					}
					else
						break;
				}
				
				System.out.println("The details of the Computer you want to change is: \n Computer #"+compNoToModify+"\n"+inventory[compNoToModify].toString());
				updateComputer(compNoToModify,inventory);

				}
				break;
				
			case 3:
				System.out.println("Enter the Brand Name : ");
				String brand = sc.next();
				findComputersBy(brand,inventory);
				break;
				
			case 4:
				System.out.println("Enter the Price : ");
				double price = sc.nextDouble();
				findCheaperThan(price,inventory);
				break;
				
			case 5: 
				
				System.out.println("Bye!!!");
				System.exit(0);
				break;
			default:
				System.out.println("Enter a valid option between 1-5!");
				
			}
		}
		
	}

	// Function to update the details of the computer. 
	public static void updateComputer(int compNoToModify, Computer[] inventory) {
		while(true) {
			System.out.println("\n What information would you like to change?\n");
			System.out.println("1. brand");
			System.out.println("2. model");
			System.out.println("3. SN");
			System.out.println("4. price");
			System.out.println("5. Quit\n");
			System.out.println("Please enter your choice >");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1: 
				
				System.out.println("Enter the new brand for the computer");
				String newBrand = sc.next();
				inventory[compNoToModify].setBrand(newBrand);
				System.out.println("Updated Details: ");
				System.out.println(inventory[compNoToModify].toString());
				break;
			case 2:
				System.out.println("Enter the new model for the computer");
				String newModel = sc.next();
				inventory[compNoToModify].setModel(newModel);;
				System.out.println("Updated Details: ");
				System.out.println(inventory[compNoToModify].toString());
				break;
			case 3:
				System.out.println("Enter the new SN for the computer");
				long newSN = sc.nextLong();
				inventory[compNoToModify].setSN(newSN);;
				System.out.println("Updated Details: ");
				System.out.println(inventory[compNoToModify].toString());
				break;
			case 4:
				System.out.println("Enter the new price for the computer");
				double newPrice = sc.nextDouble();
				inventory[compNoToModify].setPrice(newPrice);;
				System.out.println("Updated Details: ");
				System.out.println(inventory[compNoToModify].toString());
				break;
			case 5:
				System.out.println("Bye");
				//System.exit(0);
				//break;
				return;
			default:
				System.out.println("Enter a valid option between 1-5!");
				break;
			}
			
		}
	}

	// Function to validate the password
	public static boolean passwordCheck() {
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
	
	//Function to find a computer by specific brand
	public static void findComputersBy(String brand,Computer[] inventory) {
		
		for(int i=0;i<=inventory.length;i++) {
			try {
				if(inventory[i].getBrand().equals(brand)) {
					System.out.println("\n"+ inventory[i].toString());
				}
				else
					continue;
			}
			catch(Exception e){
				if(i==inventory.length)
				System.out.println("End of Search!");
			}
			
		}
	}
	
	//Function to find computers given than cheaper price
	public static void findCheaperThan(double price, Computer[] inventory) {
		for(int i=0;i<=inventory.length;i++) {
			try {
				if(inventory[i].getPrice() < price) {
					System.out.println("\n"+ inventory[i].toString());
				}
				else
					continue;
			}
			catch(Exception e){
				if(i==inventory.length)
				System.out.println("End of Search!");
			}
			
		}
		
	}

}
