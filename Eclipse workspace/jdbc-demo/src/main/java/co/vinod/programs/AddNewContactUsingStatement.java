package co.vinod.programs;

import java.sql.Connection;
import java.sql.Statement;

import co.vinod.util.DbUtil;
import co.vinod.util.KeyboardUtil;

public class AddNewContactUsingStatement {

	public static void main(String[] args) {
		String name = KeyboardUtil.getString("Enter name: ");
		String city = KeyboardUtil.getString("Enter city: ");
		String email = KeyboardUtil.getString("Enter email: ");
		String phone = KeyboardUtil.getString("Enter phone: ");

		// problem #1: difficult to construct a string sql command
		// String sql = "insert into contacts (name, city, email, phone) values ('" + name + "', '" + city + "', '" + email + "', '" + phone + "')";
		String sql = "insert into contacts (name, city, email, phone) values ('%s','%s','%s','%s')";
		sql = String.format(sql, name, city, email, phone);
		
		try(
			Connection conn = DbUtil.createConnection();
			Statement stmt = conn.createStatement();		
		) {
			stmt.executeUpdate(sql);
			System.out.println("New contact added to your database table.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
