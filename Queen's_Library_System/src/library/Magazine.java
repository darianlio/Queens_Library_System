/*
 * Magazine class that extends Book
 * - contains name, author, publisher, and year and super to Book
 * - also has late fees, (Book so no rental cost)
 * - has another constructor with given ID
 */

package library;

public class Magazine extends Book {
	
	//Constructor with all the attributes
	protected Magazine(String name, String author, String publisher, int year){
		super(name, author, publisher, year);
	}
	
	//Constructor with given ID
	protected Magazine(String name, int id, String author, String publisher, int year){
		super(name, id, author, publisher, year);
	}
	
	//Copy constructor
	protected Magazine(Magazine magazine){
		super(magazine);
	}
	
	//Clone
	@Override
	public Item clone(){
		return new Magazine(this);
	}
	
	//toString
	@Override
	public String toString(){
		return "Magazine [ID = " + getID() + ", name = " + getName() + ", author = " + getAuthors() + ", publisher = " + getPublisher() + ", year = " + getYear() + "]";
	}
	
	//Get late fees of Magazine = $0.75/day
	@Override
	public double getLateFees(int lateDays){
		return (double)(0.75*lateDays);
	}
}
