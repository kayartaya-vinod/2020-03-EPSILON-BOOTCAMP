package com.epsilon.programs;

import com.epsilon.dao.DaoFactory;
import com.epsilon.dao.ProductDao;

public class GetProductCount {

	public static void main(String[] args) {
		
		// dependency
		ProductDao dao;
		
		dao = DaoFactory.getProductDao();
		
		long pc = dao.count();
		
		System.out.println("There are " + pc + " products");
	}
}
