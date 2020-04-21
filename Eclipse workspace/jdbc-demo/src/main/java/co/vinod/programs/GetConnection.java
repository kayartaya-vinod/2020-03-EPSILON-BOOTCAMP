package co.vinod.programs;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class GetConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// load the Type-4 driver
		Class.forName("org.h2.Driver"); // not needed anymore
		
		System.out.println("List of registered drivers: ");
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while(drivers.hasMoreElements()) {
			Driver d = drivers.nextElement();
			System.out.println(d.getClass().getName());
		}
		
		// http://104.26.0.44:80/artifact
		// http://mvnrepository.com:80/artifact
		
		String url = "jdbc:h2:tcp://localhost/~/epsilon-training";
		
		// url = "jdbc:mysql://localhost/epsilon_training";
		// url = "jdbc:oracle:thin:@localhost/ORCL";
		String user = "vinod";
		// user = "root";
		String password = "secret";
		// password = "Welcome#123";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		System.out.println("Got a connection of type: " + conn.getClass().getName());
	}

}
