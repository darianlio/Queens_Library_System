/*
 * 	Name: Darian Lio

 * IMPORTANT NOTES TO UNDERSTAND WHAT I INCLUDED OR DID:
 * 		   a)Every item has an ID and a name, ID uses no setter method and are not passed through constructors
 * 		   b)Set a new ID using a static integer increment
 * 		   c)Each device has an addition rental cost
 * 		   d)Each book has an author, publisher, and year
 * 		   e)Each device and book has a method to get late fee, item has no implementation
 * 		   f)Every rental class has an item, customer ID, rental days, and days late
 * 		   g)Library system holds a collection of rentals using ArrayList and performs 
 * 			 addTransaction, getTotalLateFees, getTotalRentalCost
 * 		   h)Every class has constructors excluding main function 
 * 		   i)Getters, setters, equals are not included for final subclasses(e.g Textbook) since they 
 * 			 contain no necessary private attributes as they are inherited
 * 			 from Device or Book
 * 		   j)All classes are contained in a package called library
 */
package library;

import java.util.ArrayList;

public class LibraryTest {
	
	//Test using main method
	public static void main(String[] args) {
		
		//Initialize array list for library rental collection system
		ArrayList<Rental> rental = new ArrayList<Rental>();
		
		System.out.println("Welcome to Queen's University Library's Rental Tracker:");
		System.out.println();
		
		
		//Create new items and display them toString
		System.out.println("Rented items:");
		Device device = new Device("Some Device", 25);
		System.out.println(device);
		Laptop laptop = new Laptop("Toshiba Laptop",50);
		System.out.println(laptop);
		Adaptor adaptor = new Adaptor("Samsung Adaptor",75);
		System.out.println(adaptor);
		Book book = new Book("Some Book","Book author", "Book Publisher", 1990);
		System.out.println(book);
		Textbook textbook = new Textbook("Knowledgeable Textbook","Cool Dude","Professor Bob", 2000);
		System.out.println(textbook);
		Magazine magazine = new Magazine("Skateboard Magazine","Steven Hawkens","Skateboard Guy", 2010);
		System.out.println(magazine);
		
		System.out.println();
		
		//Initialize library system and add items to library system
		Library library = new Library(rental);
		library.addTransaction(device, 5, 2);
		library.addTransaction(laptop, 6, 3);
		library.addTransaction(adaptor, 7, 4);
		library.addTransaction(book, 8, 5);
		library.addTransaction(textbook, 9, 5);
		library.addTransaction(magazine, 10, 6);
		System.out.println(library);	
	}

}
