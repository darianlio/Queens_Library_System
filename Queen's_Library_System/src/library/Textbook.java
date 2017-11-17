/*
 * Textbook class that extends Book
 * - contains name, author, publisher, and year and super to Book
 * - also has late fees, (Book so no rental cost)
 * - has another constructor with given ID
 */

package library;

public class Textbook extends Book{
	
	//Constructor containing the attributes
	public Textbook(String name, String author, String publisher, int year){
		super(name, author, publisher, year);
	}

	//Constructor containing the attributes
	public Textbook(String name, int id, String author, String publisher, int year){
		super(name, id, author, publisher, year);
	}
	
	//Copy constructor
	public Textbook(Textbook textbook){
		super(textbook);
	}
	
	//Clone
	@Override
	public Item clone(){
		return new Textbook(this);
	}
	
	//toString
	@Override
	public String toString(){
		return "Textbook [ID = " + getID() + ", name = " + getName() + ", author = " + getAuthors() + ", publisher = " + getPublisher() + ", year = " + getYear() + "]";
	}
	
	
	//Get late fees of Textbook = $1/day
	@Override
	public double getLateFees(int lateDays){
		return (double)(1*lateDays);
	}

}
