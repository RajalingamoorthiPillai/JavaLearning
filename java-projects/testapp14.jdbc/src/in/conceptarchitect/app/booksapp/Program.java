package in.conceptarchitect.app.booksapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		String url="jdbc:postgresql://mahmud.db.elephantsql.com/zahvianw";
		//String url="jdbc:mysql://localhost/booksdb?user=root&password=@DM1n.";
		String user="zahvianw";
		String password="DSoDS_5wZjDmOjgVeR6OxqgdRjp-NEpp";          
		Connection connection=null;
		
		try {
			//Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url,user,password);
			
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
