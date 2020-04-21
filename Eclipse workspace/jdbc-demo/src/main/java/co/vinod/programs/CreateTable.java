package co.vinod.programs;

import java.sql.Connection;
import java.sql.Statement;

import co.vinod.util.DbUtil;

public class CreateTable {

	public static void main(String[] args) {
		String sql = "create table contacts (\n" + 
				"    id int primary key auto_increment,\n" + 
				"    name varchar(50) not null,\n" + 
				"    city varchar(50) default 'Bangalore',\n" + 
				"    email varchar(255) unique,\n" + 
				"    phone varchar(255) unique\n" + 
				")";
		
		
		try(
			Connection conn = DbUtil.createConnection();
			Statement stmt = conn.createStatement();
		) {
			stmt.execute(sql); // SQL command is sent to the DBMS
			System.out.println("Table created!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
