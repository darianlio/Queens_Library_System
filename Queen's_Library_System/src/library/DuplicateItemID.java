/*
 * DuplicateItemID exception
 * - occurs when there is duplicate itemID
 */


package library;

public class DuplicateItemID extends Exception{
	public DuplicateItemID(){
		super("Duplicate item id.");
	}
	
	public DuplicateItemID(String message){
		super(message);
	}
}
