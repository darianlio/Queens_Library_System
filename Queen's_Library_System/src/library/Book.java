/*
 * Book class that extends Item
 * - contains name, author, publisher, and year and super to Item
 * - also contains late fees (Book has no rental cost)
 */

package library;

public class Book extends Item {
	
	private String authors;
	private String publisher;
	private int year;
	
	//Constructor with all attributes
	public Book(String name, String authors, String publisher, int year){
		super(name);
		this.authors = authors;
		this.publisher = publisher;
		this.year = year;
	}
	
	//Copy constructor
	public Book(Book book){
		super(book);
		this.authors = book.getAuthors();
		this.publisher = book.getPublisher();
		this.year = book.getYear();
	}
	
	//Clone
	@Override
	public Item clone(){
		return new Book(this);
	}
	
	//Getter
	public String getAuthors(){
		return authors;
	}
	
	public String getPublisher(){
		return publisher;
	}
	
	public int getYear(){
		return year;
	}
	
	//Setter
	public void setAuthor(String authors){
		if(!authors.equals(""))
		this.authors = authors;
	}
	
	public void setPubisher(String publisher){
		if(!publisher.equals(""))
		this.publisher = publisher;
	}
	
	public void setYear(int year){
		if (year >= 0)
		this.year = year;
	}
	
	//Get late fees
	public double getLateFees(int lateDays){
		return (double)(0.5*lateDays);
	}
	
	//toString method
	@Override
	public String toString(){
		return "Book [ID = " + getID() + ", name = " + getName() + ", author = " + getAuthors() + ", publisher = " + getPublisher() + ", year = " + getYear() + "]";
	}
	
	//equals 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
}
