package oop2;

public class IndividualCustomerManager {
	public void add(IndividualCustomer customer) {
		System.out.print("added" + customer.getFirstName());
	}
	
	public void update(IndividualCustomer customer) {
		System.out.print("updated " + customer.getFirstName());
	}
	
	public void delete(IndividualCustomer customer) {
		System.out.print("deleted " + customer.getFirstName());
	 }
}