package library;

public class ItemFileReadingException extends Exception {
	public ItemFileReadingException(){
		super("Item file reading exception.");
	}
	
	public ItemFileReadingException(String message){
		super(message);
	}
}
