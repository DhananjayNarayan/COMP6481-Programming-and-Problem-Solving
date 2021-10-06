//-----------------------------------------------------
//Assignment 1 - COMP 6481
//© Dhananjay Narayan, Nilesh Aggarwal
//Written by: Dhananjay Narayan (40164521), Nilesh Aggarwal(40164417)
//----------------------------------------------------- 

class Computer{

	//Attributes of the Computer class
	 private String brand;
	 private String model;
	 private long SN;
  	 private double price;	 
	 private static int totalNoOfComputers=0;

	 //Default Constructor
	 public Computer() {
			this.brand="NA";
			this.model="NA";
			this.SN=0;
			this.price=0;
			totalNoOfComputers++;
		}
	 
	//Parameterized Constructor
	public Computer(String brand, String model, long sN, double price) {	
		this.brand = brand;
		this.model = model;
		this.SN = sN;
		this.price = price;
		totalNoOfComputers++;
		this.toString();
	}
	
	//Copy Constructor
	public Computer (Computer comp) {
		this.brand=comp.brand;
		this.model=comp.model;
		this.price=comp.price;
		this.SN=comp.SN;
		totalNoOfComputers++;
	}
	
	//Getter method for Brand
	public String getBrand() {
		return brand;
	}

	//Mutator for Brand
	public void setBrand(String brand) {
		this.brand = brand;
	}

	//Getter method for Model
	public String getModel() {
		return model;
	}

	//Mutator for Model
	public void setModel(String model) {
		this.model = model;
	}

	//Getter method for Serial Number SN
	public long getSN() {
		return SN;
	}

	//Mutator for Serial Number SN
	public void setSN(long sN) {
		SN = sN;
	}

	//Accessor for Price
	public double getPrice() {
		return price;
	}

	//Mutator for Price
	public void setPrice(double price) {
		this.price = price;
	}

	//Accessor for No of Created Computers
	public static int findNumberOfCreatedComputers() {
			return totalNoOfComputers;
		}
  
 // Overridden ToString method 
 public String toString() {
		return "Computer Details: \n" + "Brand Name: "+this.brand+ "\nModel: "+this.model+"\nSerial No: "+this.SN+ "\nPrice: "+this.price+"\n";
 	
 }
 
 //Overridden equals method
 public boolean equals(Object obj) {
		if(obj==null || (this.getClass() != obj.getClass()))
				return false;
		else
		{     
			Computer comp  = (Computer)obj;
			return (this.brand == comp.brand && this.model ==comp.model && this.price==comp.price && this.SN==comp.SN );
		}		
	}
 public static void main(String[] args) {
	 
	 // Creating some Computer objects to test the functions
	 Computer c1 = new Computer();
	 Computer c2 = new Computer();
	 Computer c3 = new Computer(c1);
	 System.out.println(c1.toString());
	 System.out.println(c2.toString());
	 System.out.println(c3.toString());
	 System.out.println(Computer.findNumberOfCreatedComputers());
 }
}
