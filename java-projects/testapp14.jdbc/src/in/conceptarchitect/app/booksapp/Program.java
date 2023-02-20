package in.conceptarchitect.app.booksapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url="postgres://zahvianw:DSoDS_5wZjDmOjgVeR6OxqgdRjp-NEpp@mahmud.db.elephantsql.com/zahvianw";
		Connection connection=null;
		try {
			
			connection = DriverManager.getConnection(url);
			
			Statement statement= connection.createStatement();
			
			ResultSet rs= statement.executeQuery("select * from books");
			
			while(rs.next()) {
				
				System.out.println(rs.getString("title"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try{
				connection.close();
			}catch(Exception ex) {
				
			}
		}
		
		
	}

}
