/*
 * WrongRentalCost exception
 * - occurs when the rental cost is less than $0
 */

package library;

public class WrongRentalCost extends Exception{
	public WrongRentalCost(){
		super("Wrong rental cost.");
	}
	
	public WrongRentalCost(String message){
		super(message);
	}
}
