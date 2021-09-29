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
		
		Computer[] inventory = new Computer[maxComputers];
		
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
				break;
			case 3:
				System.out.println("Enter the Brand Name : ");
				String brand = sc.next();
				for(int i=0;i<=inventory.length;i++) {
					try {
						if(inventory[i].getBrand().equals(brand) && inventory[i].getBrand()!=null) {
							System.out.println(inventory[i].toString());
						}
						else
							continue;
					}
					catch(Exception e){
						if(i==inventory.length)
						System.out.println("End of Search!");
					}
					
				}
				break;
			case 4:
				break;
				
			case 5: 
				System.out.println("Bye!!!");
				break;
			default:
				System.out.println("Enter a valid option between 1-5!");
				
			}
		}
		
	}

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

}
