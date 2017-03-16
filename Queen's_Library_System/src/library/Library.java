/*
 *  Library class
 * 	- class that creates rental collection using ArrayList
 *  - contains addTransaction, getTotalLateFees, getTotalRentalCost
 */

package library;

import java.util.ArrayList;

public class Library {
	
	//Initialize Private Attribute
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();
	
	//Initialize Constructor with All Attributes 
	protected Library(ArrayList<Rental> rental){
		rental = new ArrayList<Rental>();
		this.rentalList = rental;
	}
	
	//Copy constructor
	protected Library(Library library){
		this.rentalList = library.rentalList;
	}
	
	//Clone
	@Override
	public Library clone(){
		return new Library(this);
	}
	
	//Add new transaction to rental collection
	public void addTransaction(Item item, int rentalDays, int daysLate){
		Rental rental = new Rental(item, rentalDays, daysLate);
		rentalList.add(rental);
	}
	
	//Calculate and return total late fees of all the rented items in the library
	public double getTotalLateFees(){
		
		//initialize total late fees
		double total = 0;
		
		//check each item
		for (Rental rental : rentalList){
			
			//check if item is device class, if it is, add device late fees to total
			if (rental.getItem() instanceof Device){
				total += (((Device) rental.getItem()).getLateFees(rental.getDaysLate()));		
			}
			
			//if not device class, it must be a book class, add book late fees to total
			else {
				total += (((Book) rental.getItem()).getLateFees(rental.getDaysLate()));
			}
		}
		
		//return total late fees
		return total;
	}
	
	//Calculate and return the total rental cost of all rented devices in the library
	public double getTotalRentalCosts(){
		
		//initialize total rental costs
		double total = 0;
		
		//check each item
		for (Rental rental : rentalList){
		
			//check if item is device class, if not then check next item
			if (rental.getItem() instanceof Device){
				//sum the rental cost of device multiplied by number of days rented
				total += ((Device) rental.getItem()).getRentalCost()*(double)rental.getRentalDays();
			}
		}
		
		//return total rental cost
		return total;
	}
	
	//Getter
	public ArrayList<Rental> getLibrary(){
		return rentalList;
	}
	
	
	//Setter
	public void setLibrary(ArrayList<Rental> library){
		library = new ArrayList<Rental>();
		this.rentalList = library;
	}

	//toString
	@Override
	public String toString() {
		return "Library System " + getLibrary() + "\n[Total Late Fees = $" + getTotalLateFees() + ", Total Rental Cost = $" + getTotalRentalCosts() + "]";
	}

	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Library other = (Library) obj;
		if (rentalList == null) {
			if (other.rentalList != null)
				return false;
		} else if (!rentalList.equals(other.rentalList))
			return false;
		return true;
	}
}