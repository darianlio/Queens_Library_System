/*
 *  Library class
 * 	- class that creates rental, item, and customer collection using HashMap with unique key
 *  - contains addTransaction, addItem, addCustomer
 *  - can getTotalLateFees and getTotalRentalCost
 */

package library;

import java.util.*;

public class Library {
	
	//Initialize Private Attribute	
	private HashMap<Integer,Rental> rentalCollection = new HashMap<Integer,Rental>();
	private HashMap<Integer,Item> itemCollection = new HashMap<Integer,Item>();
	private HashMap<Integer,Customer> customerCollection = new HashMap<Integer,Customer>();
	
	//Initialize Constructor with All Attributes 
	protected Library(HashMap<Integer,Rental> rental){
		this.rentalCollection = rental;
	}
	
	//Copy constructor
	protected Library(Library library){
		this.rentalCollection = library.getRental();
	}
	
	//Clone
	@Override
	public Library clone(){
		return new Library(this);
	}
	
	//functions to add rental, item, and customer 
	public void addTransaction(Rental rental) throws DuplicateTransactionID{
		if (rentalCollection.containsKey(rental.getTransactionID())) throw new DuplicateTransactionID(); 
		rentalCollection.put(rental.getTransactionID(), rental);
	}
	
	public void addItem(Item item) throws DuplicateItemID{
		if (itemCollection.containsKey(item.getID())) throw new DuplicateItemID();
		itemCollection.put(item.getID(), item);
	}
	
	public void addCustomer(Customer customer) throws DuplicateCustomerID{
		if (customerCollection.containsKey(customer.getID())) throw new DuplicateCustomerID();
		customerCollection.put(customer.getID(), customer);
	}
	
	//Calculate and return total late fees of all the rented items in the library
	public double getTotalLateFees(){
		
		//initialize total late fees
		double total = 0;
		
		//check each item
		for (Integer key : rentalCollection.keySet()){
			
			//check if item is device class, if it is, add device late fees to total
			if ((rentalCollection.get(key).getItem()) instanceof Device){
				total += (((Device) rentalCollection.get(key).getItem()).getLateFees(rentalCollection.get(key).daysBetween(rentalCollection.get(key).getEstimatedReturn(), rentalCollection.get(key).getCurrentDate())));		
			}
			
			//if not device class, it must be a book class, add book late fees to total
			else {
				total += (((Book) rentalCollection.get(key).getItem()).getLateFees(rentalCollection.get(key).daysBetween(rentalCollection.get(key).getEstimatedReturn(), rentalCollection.get(key).getCurrentDate())));
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
		for (Integer key : rentalCollection.keySet()){
		
			//check if item is device class, if not then check next item
			if ((rentalCollection.get(key).getItem())instanceof Device){
				//sum the rental cost  device multiplied by number of days rented
				total += ((Device) rentalCollection.get(key).getItem()).getRentalCost()*(double)rentalCollection.get(key).daysBetween(rentalCollection.get(key).getRentalDate(), rentalCollection.get(key).getCurrentDate());
			}
		}
		
		//return total rental cost
		return total;
	}
	
	//Getter	
	public HashMap<Integer, Rental> getRental(){
		return rentalCollection;
	}
	
	public HashMap<Integer, Item> getItem(){
		return itemCollection;
	}
	
	public HashMap<Integer, Customer> getCustomer(){
		return customerCollection;
	}
	
	//Setter
	public void setRentalCol(HashMap<Integer,Rental> rental){
		rental = new HashMap<Integer,Rental>();
		this.rentalCollection = rental;
	}
	
	public void setItemCol(HashMap<Integer,Item> item){
		item = new HashMap<Integer, Item>();
		this.itemCollection = item;
	}
	
	public void setCustomerCol(HashMap<Integer,Customer> customer){
		customer = new HashMap<Integer,Customer>();
		this.customerCollection = customer;
	}
	
	//toString
	@Override
	public String toString() {
		return "Library [rentalCollection=" + getRental() + ", itemCollection=" + getItem()
				+ ", customerCollection=" + getCustomer() + "] \n[Total Late Fees = $" + getTotalLateFees() + ", Total Rental Cost = $" + getTotalRentalCosts() +"]";
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
		if (customerCollection == null) {
			if (other.customerCollection != null)
				return false;
		} else if (!customerCollection.equals(other.customerCollection))
			return false;
		if (itemCollection == null) {
			if (other.itemCollection != null)
				return false;
		} else if (!itemCollection.equals(other.itemCollection))
			return false;
		if (rentalCollection == null) {
			if (other.rentalCollection != null)
				return false;
		} else if (!rentalCollection.equals(other.rentalCollection))
			return false;
		return true;
	}
}