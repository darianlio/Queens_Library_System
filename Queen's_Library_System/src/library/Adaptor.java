/*
 * Adaptor Class extends from the super class, Device
 * - this gets name and rentalCost
 * - contains late fees method with rental cost included
 */

package library;

public class Adaptor extends Device{
	
	//Constructor with all attributes
	protected Adaptor(String name, double rentalCost){
		super(name, rentalCost);
	}
	
	//Copy constructor
	protected Adaptor(Adaptor adaptor){
		super(adaptor);
	}
	
	//Clone
	@Override
	public Adaptor clone(){
		return new Adaptor(this);
	}

	//toString
	@Override
	public String toString() {
		return "Adaptor [ID = " + getID() + ", name = " + getName() + ", rental cost = $" + getRentalCost() + "]";
	}
	
	//Get late fees of Adaptor = $2.5/day + %15*rentalCost
	public double getLateFees(int lateDays){
		return (double)(2.5*lateDays) + 0.15 * getRentalCost();
	}
}
