package co.vinod.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;

import co.vinod.util.DbUtil;
import co.vinod.util.KeyboardUtil;

public class AddNewContactUsingPreparedStatement {

	public static void main(String[] args) {
		
		String sql = "insert into contacts (name, city, email, phone) values (?,?,?,?)";
		
		try(
			Connection conn = DbUtil.createConnection();
			PreparedStatement stmt = conn.prepareStatement(sql); // first round-trip to dbms
		) {
			String name = KeyboardUtil.getString("Enter name: ");
			String city = KeyboardUtil.getString("Enter city: ");
			String email = KeyboardUtil.getString("Enter email: ");
			String phone = KeyboardUtil.getString("Enter phone: ");

			stmt.setString(1, name);
			stmt.setString(2, city);
			stmt.setString(3, email);
			stmt.setString(4, phone);
			
			stmt.executeUpdate(); // 2nd round-trip to DBMS
			System.out.println("New contact added to your database table.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
