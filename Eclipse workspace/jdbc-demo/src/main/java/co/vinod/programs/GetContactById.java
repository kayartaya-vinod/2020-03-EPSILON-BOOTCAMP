package co.vinod.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import co.vinod.util.DbUtil;
import co.vinod.util.KeyboardUtil;

public class GetContactById {

	public static void main(String[] args) {
		int id = KeyboardUtil.getInt("Enter id for searching a contact: ");
		
		String sql = "select * from contacts where id = ?";
		try(
				Connection conn = DbUtil.createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql); // first round-trip to dbms
			) {
			stmt.setInt(1, id);
			try(
					ResultSet rs = stmt.executeQuery();
				) {
				
				if(rs.next()) {
					String name = rs.getString("name");
					String city = rs.getString("city");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					System.out.println("Name    : " + name);
					System.out.println("City    : " + city);
					System.out.println("Email   : " + email);
					System.out.println("Phone   : " + phone);
				}
				else {
					System.out.println("No data found for id " + id);
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
