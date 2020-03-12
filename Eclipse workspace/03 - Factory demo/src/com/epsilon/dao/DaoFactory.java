package com.epsilon.dao;

public final class DaoFactory {

	// fallback value; ideally must be input from
	// an external source such as properties file or
	// env variables.
	private static String discriminator = "DUMMY";

	private DaoFactory() {
	}

	public static ProductDao getProductDao() {
		switch (discriminator.toLowerCase()) {
		case "jdbc":
			return new ProductDaoJdbcImpl();
		case "dummy":
			return new ProductDaoDummyImpl();
		default:
			throw new RuntimeException("Invalid discriminator");
		}
	}

}
