/*
 * DuplicateTransactionID exception
 * - occurs when there is duplicate transactionID
 */


package library;

public class DuplicateTransactionID extends Exception{
	public DuplicateTransactionID(){
		super("Duplicate transaction ID.");
	}
	
	public DuplicateTransactionID(String message){
		super(message);
	}
}
