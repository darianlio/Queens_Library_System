/*
 * Device Class extends from the super class, Item
 * - this gets ID and Name from super
 * - contains extra attribute rentalCost
 */

package library;

public class Device extends Item{
	
	//Initialize private attribute
	private double rentalCost;							//cost of renting device per day
	
	
	//Constructor with all attributes
	protected Device(String name, double rentalCost){
		super(name);									//set ID and name in item class
		this.rentalCost = rentalCost;					
	}	
	
	//Copy Constructor
	protected Device(Device device){
		super(device);
		this.rentalCost = device.getRentalCost();
	}

	//Clone
	@Override
	public Item clone() {
		return new Device(this);
	}
	
	//Getter
	public double getRentalCost(){
		return rentalCost;
	}
	
	//Setter
	public void setRentalCost(double rentalCost){
		if(rentalCost >= 0)
		this.rentalCost = rentalCost;
	}
	
	//Get late fees for Device
	public double getLateFees(int lateDays){
		return (double)(2*lateDays) + 0.1 * rentalCost;
	}
	
	//toString
	@Override
	public String toString() {
		return "Device [ID = " + getID() + ", name = " + getName() + ", rental cost = $" + getRentalCost() + "]";
	}

	//Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (Double.doubleToLongBits(rentalCost) != Double.doubleToLongBits(other.rentalCost))
			return false;
		return true;
	}	
}
