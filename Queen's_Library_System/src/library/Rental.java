/*
 * Rental Class
 * - created enum status depending on active, late, or closed
 * - initialize status as null
 * - referenced item and customer
 * - created transactionID using static counter
 * - set status active when rental constructor called
 * - created Status modifier functions isLate(), and itemReturned()
 * - created getLateFee and getRentalCost (if student, give 25% discount)
 * - created getTotalToBePaid
 * - created daysBetween method to determine the amount of days of the rental
 */

package library;

import java.util.*;
import library.Customer.Type;

public class Rental{
	
	//Initialize status of rental
	enum Status {Active, Late, Closed};
	Status currentStatus = null;		//empty status until declared
	
	//Initialize private attributes
	private Item item;
	private Customer customer;
	private static int counter = 1;
	private int transactionID = 1;
	private Date rentalDate;
	private Date estimatedReturn;
	private Date actualReturn;	
	
	//Constructor with all attributes
	protected Rental(Item item, Customer customer, Date rentalDate, Date estimatedReturn){
		this.transactionID = counter++;
		this.customer = customer;
		this.item = item;
		this.rentalDate = rentalDate;
		this.estimatedReturn = estimatedReturn;
		this.currentStatus = Status.Active;				//make rental item active
	}
	
	//Constructor with given ID
	protected Rental(Item item, Customer customer, int transactionID, Date rentalDate, Date estimatedReturn){
		this.transactionID = transactionID;
		this.customer = customer;
		this.item = item;
		this.rentalDate = rentalDate;
		this.estimatedReturn = estimatedReturn;
		this.currentStatus = Status.Active;				//make rental item active
	}
	
	//Copy constructor
	protected Rental(Rental rental){
		this.transactionID = rental.getTransactionID();
		this.item = rental.getItem();
		this.rentalDate = rental.getRentalDate();
		this.currentStatus = rental.getStatus();
	}

	//Clone
	@Override
	public Rental clone() {
		return new Rental(this);
	}
	
	//Getters	
	public Item getItem(){
		return item;
	}
	
	public Customer getCustomer(){
		return customer;
	}

	public Date getRentalDate(){
		return rentalDate;
	}
	
	public Date getEstimatedReturn(){
		return estimatedReturn;
	}
	
	public Date getActualReturn(){
		return actualReturn;
	}
	
	public Date getCurrentDate(){
		return new Date();
	}
	
	public int getTransactionID(){
		return transactionID;
	}
	
	public Status getStatus(){
		return currentStatus;
	}

	//Setters
	public void setItem(Item item){
		this.item = item;
	}
	
	public void setCustomer(Customer customer){
		this.customer = customer;
	}
	
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public void setEstimatedReturn(Date estimatedReturn) {
		this.estimatedReturn = estimatedReturn;
	}

	public void setActualReturn(Date actualReturn) {
		this.actualReturn = actualReturn;
	}
	
	public void setStatus(Status currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	//get rental cost of item
	public double getRentalCost() throws WrongRentalCost{
		if(getItem() instanceof Device){
			//if customer is a student, give 25% discount
			if(customer.getType() == Type.Student){
				return ((Device)getItem()).getRentalCost()*0.75;
			}
			else {
				return ((Device) getItem()).getRentalCost();
			}
		}
		return 0;
	}
	
	//get total paid to be paid from rental cost and late fees, discount in rentalCost method
	public double getTotalToBePaid() throws WrongRentalCost{
		double total = 0;
		return total += getRentalCost() + getLateFee();
	}

	//Status modifier functions
	public boolean isLate(){
		if (actualReturn.after(estimatedReturn)){
			this.currentStatus = Status.Late;
			return true;
		}
		return false;
	}
	
	public boolean itemReturned(Date date) throws DateReturnedBeforeDateRented{
		actualReturn = date;
		if(actualReturn.before(rentalDate)) throw new DateReturnedBeforeDateRented();
		this.currentStatus = Status.Closed;
		return true;
	}
	
	//get late fees of item
	public double getLateFee(){
		return item.getLateFees(daysBetween(getEstimatedReturn(), getActualReturn()));
	}
	
	//get days between 2 days
	public int daysBetween(Date date1, Date date2){
        return (int)( (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	//toString
	@Override
	public String toString() {
		return "Rental [currentStatus=" + getStatus() + ", item=" + getItem() + ", customer=" + getCustomer()
				+ ", transactionID=" + getTransactionID() + ", rentalDate=" + getRentalDate() + ", estimatedReturn="
				+ getEstimatedReturn() + ", actualReturn=" + getActualReturn() + "]";
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
		if (actualReturn == null) {
			if (other.actualReturn != null)
				return false;
		} else if (!actualReturn.equals(other.actualReturn))
			return false;
		if (currentStatus != other.currentStatus)
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (estimatedReturn == null) {
			if (other.estimatedReturn != null)
				return false;
		} else if (!estimatedReturn.equals(other.estimatedReturn))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (rentalDate == null) {
			if (other.rentalDate != null)
				return false;
		} else if (!rentalDate.equals(other.rentalDate))
			return false;
		if (transactionID != other.transactionID)
			return false;
		return true;
	}
}