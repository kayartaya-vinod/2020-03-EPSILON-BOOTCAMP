package co.vinod.programs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import co.vinod.util.DbUtil;
import co.vinod.util.KeyboardUtil;

public class SqlInjectionDemo {

	public static void main(String[] args) {
		String username = KeyboardUtil.getString("Enter username: ");
		String password = KeyboardUtil.getString("Enter password: ");
		
		String sql = String.format("select * from users where username='%s' and password='%s'", username, password);
		System.out.println(sql);
		
		try (Connection conn = DbUtil.createConnection(); Statement stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("Login successful");
			} else {
				System.out.println("Invalid username/password");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
