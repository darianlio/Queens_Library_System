/* Customer Class
 * - created enum type Student and Employee
 * - initialized private attributes customerID, name, and department
 * - created constructors, getters and setters for customer
 */

package library;

public class Customer {
	
	//customer enum type of student or employee
	enum Type {Student, Employee};
	
	//private attributes
	private int customerID;
	private String name;
	private String department;
	private Type customer;
	
	//Customer constructor
	protected Customer(Type customer, int id, String name, String department){
		this.customer = customer;
		this.customerID = id;
		this.name = name;
		this.department = department;
	}
	
	//Create copy constructor
	protected Customer(Customer customer){
		this.customer = customer.getType();
		this.customerID = customer.getID();
		this.name = customer.getName();
		this.department = customer.getDepartment();
	}
	
	//clone
	public Customer clone(){
		return new Customer(this);
	}
	
	//Getters
	public Type getType(){
		return customer;
	}
	
	public int getID(){
		return customerID;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDepartment(){
		return department;
	}

	//Setters
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void setCustomer(Type customer) {
		this.customer = customer;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}

	//toString
	@Override
	public String toString() {
		return "Customer [customerID=" + getID() + ", customer=" + customer + ", name=" + getName() + ", department=" + getDepartment() + "]";
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
		Customer other = (Customer) obj;
		if (customer != other.customer)
			return false;
		if (customerID != other.customerID)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
