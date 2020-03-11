package com.epsilon.training.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Customer {

	// fields (generally must be private)

	private int id;
	private String name;
	private String email;
	private String phone;

	public Customer(String name) {
		// "this" is a reference to invoking object
		this.name = name;
	}

	
}
