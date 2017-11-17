/*
 * 	Name: Darian Lio
 *  Student ID: 10181505 
 *  Net ID: 14dl50
 *  Title: Queen's Library System V2
 *  Course: CMPE212
 *  Professor: Hesham Farahat
 *  Date: Thursday, March 30, 2017

 * IMPORTANT NOTES TO UNDERSTAND WHAT I INCLUDED OR DID:
 * 		   a) Added a few items
 * 		   b) Created multiple dates to test rental date, estimated date, and days late
 * 		   c) Created transactions with the old dates
 * 		   d) Printed all late transactions
 * 		   e) More descriptions in each class
 */
package library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import library.Customer.Type;

public class Assn4_10181505 {
	
	//Test using main method
	public static void main(String[] args) throws ParseException {
		
		//-----DECLARATION-----
		//Format the date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		//Create default dates to rent
		Date rentalDate1 = sdf.parse("2017-03-01 14:59:05");
		Date rentalDate2 = sdf.parse("2017-02-25 12:01:35");
		Date rentalDate3 = sdf.parse("2015-01-31 01:07:42");
		
		//Estimated date that should be returned 
		Date estimatedDate1 = sdf.parse("2017-03-12 12:00:00"); 
		Date estimatedDate2 = sdf.parse("2017-03-25 12:00:00");
		
		//Get current date as the late day
 		Date lateDate = sdf.parse("2017-03-26 12:00:00");  
 		
		//Created customers
		Customer student = new Customer(Type.Student, 10181505, "Darian", "Engineering");
		Customer employee = new Customer(Type.Employee, 525301617, "Robert", "Accountant");
		
		//Create hashmap
		HashMap<Integer,Rental> rental = new HashMap<Integer,Rental>();
		
		//Create Library
		Library library = new Library(rental);
		
		//-------INTRO--------
		System.out.println("Welcome to Queen's University Library's Rental Tracker:");
		System.out.println();
		
		//Print customers
		System.out.println("CUSTOMERS:");
		System.out.println(student);
		System.out.println(employee + "\n");
		
		//Create new items and display them toString
		System.out.println("RENTAL ITEMS:");
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
		
		//----------TESTING------------
		System.out.println("IMPLEMENTATION: ");
		
		//Rented items for each person
		System.out.println("Currently rented items:");
		Rental rental1 = new Rental(laptop, student, rentalDate1, estimatedDate1);
		Rental rental2 = new Rental(textbook, employee, rentalDate2, estimatedDate2);
		
		System.out.println(rental1);
		System.out.println(rental2 + "\n");
		
		//Returning item and closed transactions
		try {
			rental1.itemReturned(lateDate);
			rental2.itemReturned(estimatedDate2);
		} catch (DateReturnedBeforeDateRented exception) {
			System.out.println(exception);
		}
		
		//Returned items
		System.out.println("After returning items:");
		System.out.println(rental1);
		System.out.println(rental2 + "\n");
		
		//Check if late
		System.out.println("Checking if a person is late:");
		System.out.println("Is the student late?: " + rental1.isLate());
		System.out.println("Is the employee late?: " + rental2.isLate() + "\n");
		
		//Get late fees
		System.out.println("Get late fees of each person:");
		System.out.println("Student Late Fee (25% discount): $" + rental1.getLateFee());
		System.out.println("Employee Late Fee: $" + rental2.getLateFee() + "\n");
		
		//Get rental fees
		try{
			System.out.println("Get rental fees of each person:");
			System.out.println("Student Rental Fee: $" + rental1.getRentalCost());
			System.out.println("Employee Rental Fee: $" + rental2.getRentalCost() + "\n");
		} catch (WrongRentalCost exception){
			System.out.println(exception);
		}
		//Get total to be paid
		try{
			System.out.println("Get total to be paid by each person:");
			System.out.println("Student total to be paid: $" + rental1.getTotalToBePaid());
			System.out.println("Employee total to be paid: $" + rental2.getTotalToBePaid() + "\n");
		} catch (WrongRentalCost exception){
			System.out.println(exception);
		}
		
		System.out.println("");
		
		//----------EXCEPTION TESTING----------
		System.out.println("EXCEPTION TESTING:");
		
		//Duplicate Item ID
		try{
			Laptop laptop1 = new Laptop("Lenovo", 10, 20);
			Laptop laptop2 = new Laptop("Lenovo", 10, 20);
			library.addItem(laptop1);
			library.addItem(laptop2);
		} catch (DuplicateItemID | WrongRentalCost exception){
			System.out.println(exception);
		}
		
		//Duplicate Customer ID
		Customer random1 = new Customer(Type.Student, 123456789, "Bob", "Science");
		Customer random2 = new Customer(Type.Student, 123456789, "Bob", "Science");
		
		try {
			library.addCustomer(random1);
			library.addCustomer(random2);
		} catch (DuplicateCustomerID exception){
			System.out.println(exception);
		}
		
		//Duplicate Transaction ID
		Rental rental3 = new Rental(adaptor, student, rentalDate3, estimatedDate1);
		Rental rental4 = rental3.clone();
		
		try{
			library.addTransaction(rental3);
			library.addTransaction(rental4);
		} catch (DuplicateTransactionID exception){
			System.out.println(exception);
		}
		
		//Date returned before date rented
		Rental rental5 = new Rental(laptop, student, rentalDate1, estimatedDate1);
		try {
			rental5.itemReturned(rentalDate1);					
		} catch (DateReturnedBeforeDateRented exception){
			System.out.println(exception);
		}
		
		//Wrong rental cost
		try {
			Device device2 = new Device("Device", 10, -5);
		} catch (WrongRentalCost exception){
			System.out.println(exception);
		}
	}
}
