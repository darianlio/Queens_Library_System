/*
 * Rental Class
 * - renting contains information on an item, customerID, rental days, and days late
 */

package library;

public class Rental{
	
	//Initialize private attributes
	private Item item;
	private static int counter = 1;
	private int customerID;
	private int rentalDays;
	private int daysLate;
	
	//Constructor with all attributes
	protected Rental(Item item, int rentalDays, int daysLate) {
		this.customerID = counter++;
		this.item = item;
		this.rentalDays = rentalDays;
		this.daysLate = daysLate;
	}
	
	//Copy constructor
	protected Rental(Rental rental){
		this.customerID = counter++;
		this.item = rental.getItem();
		this.rentalDays = rental.getRentalDays();
		this.daysLate = rental.getDaysLate();
	}

	//Clone
	@Override
	public Rental clone() {
		return new Rental(this);
	}
	
	//Getters
	public int getCustomerID(){
		return customerID;
	}
	
	public Item getItem(){
		return item;
	}

	public int getRentalDays(){
		return rentalDays;
	}
	
	public int getDaysLate(){
		return daysLate;
	}
	
	//Setters
	public void setItem(Item item){
		this.item = item;
	}

	public void setRentalDays(int rentalDays){
		this.rentalDays = rentalDays;
	}
	
	public void setDaysLate(int daysLate){
		this.daysLate = daysLate;
	}
	
	//toString
	@Override
	public String toString() {
		return "Rental [customerID = " + getCustomerID() + ", item = " + getItem() + ", rentalDays = " + getRentalDays() + ", daysLate = " + getDaysLate() + "]\n";
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
		Rental other = (Rental) obj;
		if (daysLate != other.daysLate)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (rentalDays != other.rentalDays)
			return false;
		return true;
	}	
	
	
}