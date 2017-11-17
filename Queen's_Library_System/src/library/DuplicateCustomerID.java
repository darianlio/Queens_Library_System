package library;

public class DuplicateCustomerID extends Exception {
	public DuplicateCustomerID(){
		super("Duplicate customer ID.");
	}
	
	public DuplicateCustomerID(String message){
		super(message);
	}
}
