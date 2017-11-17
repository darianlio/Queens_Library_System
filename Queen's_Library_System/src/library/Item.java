/*
 * Item Class
 * - has no implementation so it is the abstract class which requires subclasses to work
 * - has abstract clone method 
 * - this class has ID and Name
 * - did not include getLateFee in item since it doesn't have an implementation unless its a device or a book
 * - has another constructor with given ID
* 
* IF NECESSARY
* - make abstract getLateFee and override in all the other classes
* getLateFee ABSTRACT METHOD BELOW
* public abstract double getLateFee(int daysLate);
*
*/

package library;

public abstract class Item {
	
	//Initialize private attributes
	private static int ID = 10000;					//initialize static integer for ID
	private int itemID;								
	private String name;
	
	//Constructor with all attributes
	protected Item(String name){
		this.itemID = ID++;
		this.name = name;
	}
	
	//Constructor with given ID
	protected Item(String name, int id){
		this.name = name;
		this.itemID = id;
	}
		
	//Create a copy constructor
	protected Item(Item item){
		this.itemID = item.getID();
		this.name = item.getName();
	}
	
	//Clone
	public abstract Item clone();
	
	//Getters
	public int getID(){
		return itemID;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		if (!name.equals(""))
			this.name = name;
	}
	
	//toString
	@Override
	public String toString() {
		return "Item [ID = " + getID() + ", name = " + getName() + "]";
	}
	
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemID != other.itemID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	//abstract get late fees
	public abstract double getLateFees(int lateDays);
}
