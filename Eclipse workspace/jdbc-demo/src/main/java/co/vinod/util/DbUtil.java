package co.vinod.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DbUtil {
	private DbUtil() {
	}

	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		
		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		
		String driverClassName = rb.getString("jdbc.driverClassName");
		String url = rb.getString("jdbc.url");
		String user = rb.getString("jdbc.user");
		String password = rb.getString("jdbc.password");

		Class.forName(driverClassName); // not needed anymore
		return DriverManager.getConnection(url, user, password);
	}
}
