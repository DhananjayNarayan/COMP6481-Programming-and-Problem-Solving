 class Computer{

	 private String brand;
	 private String model;
	 private long SN;
     private double price;	 
     private static int totalNoOfComputers=0;
	

	public Computer(String brand, String model, long sN, double price) {
		
		this.brand = brand;
		this.model = model;
		this.SN = sN;
		this.price = price;
		totalNoOfComputers++;
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
     
    
}
