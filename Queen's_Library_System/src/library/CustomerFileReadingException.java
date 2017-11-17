package library;

public class CustomerFileReadingException extends Exception{
	public CustomerFileReadingException(){
		super("Customer file reading exception.");
	}
	
	public CustomerFileReadingException(String message){
		super(message);
	}
}
