package com.epsilon.training.programs;

import com.epsilon.training.entity.Customer;

public class CreateCustomerObject {

	
	
	public static void main(String[] args) {
		
		// Variable declaration
		// c1 is a reference type variable
		// c1 gets 8 bytes in the stack
		// At this time, the class Customer is not loaded to VM yet!
		Customer c1;
		
		// For this statement to work, the class "Customer" must be loaded into VM.
		// A class is loaded only once, and once loaded, stays in the VM for ever.
		// The "new" keyword allocates memory required by the customer object (sum
		// of bytes required by the fields of Customer class). Once the allocation
		// is done, it calls the constructor specified. It records the actual address
		// against a reference number, and returns that reference number, which is
		// then collected and stored by c1.
		c1 = new Customer();
		
		c1.setId(1);
		c1.setName("Vinod Kumar");
		c1.setEmail("vinod@vinod.co");
		c1.setPhone("9731424784");
	
		System.out.println(c1);
		
		Customer c2 = new Customer("Vishal");
		System.out.println(c2);
		
		Customer c3 = new Customer(3, "John Doe", "johndoe@xmpl.com", "5559383733");
		System.out.println(c3);
		
	}
}







