package co.vinod.programs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import co.vinod.util.DbUtil;

public class AddContactFromCsvFile {

	public static void main(String[] args) {
		
		String sql = "insert into contacts (name, city, email, phone) values (?,?,?,?)";
		
		try(
			Connection conn = DbUtil.createConnection();
			PreparedStatement stmt = conn.prepareStatement(sql); // first round-trip to dbms
			FileReader file = new FileReader("1000contacts.csv");
			BufferedReader in = new BufferedReader(file);
		) {
			
			in.readLine(); // skip the header
			String line;
			
			while((line = in.readLine()) != null ) {
				String[] fields = line.split(",");
				String name = fields[0];
				String city = fields[1];
				String email = fields[2];
				String phone = fields[3];
				
				stmt.setString(1, name);
				stmt.setString(2, city);
				stmt.setString(3, email);
				stmt.setString(4, phone);
				
				stmt.addBatch(); // the current values will be added to a batch
			}
			
			stmt.executeBatch(); // 2nd round-trip to DBMS
			System.out.println("New contacts added to your database table.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
