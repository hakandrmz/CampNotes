package oop2;

public class Main {

	public static void main(String[] args) {
		
		Customer corporateCustomer1 = new CorporateCustomer(1,"123456","t@t.com","Turkcell","1232123");
		IndividualCustomer individualCustomer = new IndividualCustomer(1,"123456","t@t.com","Turkcell","1232123","123123");

		Customer[] customers = {corporateCustomer1,individualCustomer};
		
		IndividualCustomerManager individualCustomerManager = new IndividualCustomerManager();
		individualCustomerManager.add(individualCustomer);
		
	}

}
