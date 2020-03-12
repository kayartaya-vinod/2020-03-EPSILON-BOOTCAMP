package com.epsilon.programs;

import com.epsilon.entity.Employee;
import com.epsilon.entity.Gender;
import com.epsilon.util.KeyboartUtil;

public class CreateEmployees {

	public static void main(String[] args) throws Exception {

		Employee e1 = new Employee();

		int id = KeyboartUtil.getInt("Enter id: ");
		e1.setId(id);

		String name = KeyboartUtil.getString("Enter name: ");
		e1.setName(name);

		double salary = KeyboartUtil.getDouble("Enter salary: ");
		e1.setSalary(salary);

		Gender[] genders = { Gender.FEMALE, Gender.MALE };
		int g = KeyboartUtil.getInt("Enter 0 for Female, 1 for Male: ");
		e1.setGender(genders[g]);

		System.out.println(e1);
	}

}
