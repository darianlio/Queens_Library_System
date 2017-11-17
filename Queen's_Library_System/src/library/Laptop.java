/*
 * Laptop Class extends from the super class, Device
 * - this gets name and rentalCost
 * - contains late fees method with rental cost included
 * - has another constructor with given ID
 */

package library;

public class Laptop extends Device {
	
	//Constructor with all attributes
	protected Laptop(String name, double rentalCost){
		super(name, rentalCost);
	}
	
	//Constructor with given ID
	protected Laptop(String name, int id, double rentalCost) throws WrongRentalCost{
		super(name, id, rentalCost);
	}
		
	
	//Copy constructor
	protected Laptop(Laptop laptop){
		super(laptop);
	}
	
	//Clone 
	@Override
	public Item clone(){
		return new Laptop(this);
	}

	//toString
	@Override
	public String toString() {
		return "Laptop [ID = " + getID() + ", name = " + getName() + ", rental cost = $" + getRentalCost() + "]";
	}

	//Get late fees of Laptop = $5/day + %20*rentalCost
	@Override
	public double getLateFees(int lateDays){
		return (double)(5*lateDays) + 0.2 * getRentalCost();
	}
	
	
}
