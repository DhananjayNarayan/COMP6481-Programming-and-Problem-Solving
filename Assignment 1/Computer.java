// -----------------------------------------------------
// Assignment 1 - COMP 6481
// © Dhananjay Narayan, Nilesh Aggarwal
// Written by: Dhananjay Narayan (40164521), Nilesh Aggarwal( )
// ----------------------------------------------------- 

class Computer{

	 private String brand;
	 private String model;
	 private long SN;
     private double price;	 
     private static int totalNoOfComputers=0;
	
// TODO Add default constructor; 
	public Computer(String brand, String model, long sN, double price) {
		
		this.brand = brand;
		this.model = model;
		this.SN = sN;
		this.price = price;
		totalNoOfComputers++;
	}

	public Computer (Computer comp) {
	this.brand=comp.brand;
	this.model=comp.model;
	this.price=comp.price;
	this.SN=comp.SN;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getSN() {
		return SN;
	}

	public void setSN(long sN) {
		SN = sN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static int findNumberOfCreatedComputers() {
			return totalNoOfComputers;
		}
     
    
    public String toString() {
		return "Computer Details: \n" + "Brand Name: "+this.brand+ "\nModel: "+this.model+"\nSerial No: "+this.SN+ "\nPrice: "+this.price+"\n";
    	
    }
    
    public boolean equals(Object obj) {
		if(obj==null||(this.getClass()!=obj.getClass()))
				return false;
				else
				{     Computer comp  = (Computer)obj;
					return (this.brand == comp.brand && this.model ==comp.model && this.price==comp.price && this.SN==comp.SN );
				}		
	}
}
