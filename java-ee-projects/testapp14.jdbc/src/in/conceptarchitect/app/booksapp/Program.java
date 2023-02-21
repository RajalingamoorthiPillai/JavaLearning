package in.conceptarchitect.app.booksapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.conceptarchitect.bookmanagement.BookDbManager;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		//String url="jdbc:postgressql://zahvianw:DSoDS_5wZjDmOjgVeR6OxqgdRjp-NEpp@mahmud.db.elephantsql.com/zahvianw";
		
		String url="jdbc:mysql://localhost/booksdb";
		String userName="root";
		String password="@DM1n.";
		
		var db=new BookDbManager(url, userName, password);
		
		for(var book: db.getAllBooks() )
			System.out.println(book);
			
	}

}
