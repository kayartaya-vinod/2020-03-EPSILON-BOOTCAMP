package co.vinod.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import co.vinod.util.DbUtil;

public class GetContactsFromCity {

	public static void main(String[] args) throws Exception {
		
		String city = "Kuala Lumpur";
		String sql = "select * from contacts where city = ?";
		
		try(
			Connection conn = DbUtil.createConnection();
			PreparedStatement stmt = conn.prepareStatement(sql); // first round-trip to dbms
		) {
			stmt.setString(1, city);
			try(
				ResultSet rs = stmt.executeQuery();
			) {
				System.out.println("People in your contacts from " + city);
				while(rs.next()) {
					String name = rs.getString("name"); // rs.getString(2);
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					System.out.printf("%-25s %-50s %-30s\n", name, email, phone);
				}
			}
		}
		
	}
}
