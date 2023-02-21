package in.conceptarchitect.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import in.conceptarchitect.bookmanagement.Book;
import in.conceptarchitect.bookmanagement.JdbcException;

public class DbManager {
	String url;
	String userName;
	String password;
	public DbManager(String url, String userName, String password) {
		super();
		this.url = url;
		this.userName = userName;
		this.password = password;
	}
	
	public <X> X  executeCommand(ConnectionCommand<X> command) {
		Connection connection=null;
		try {			
			connection=DriverManager.getConnection(url,userName,password);

			return command.execute(connection);
			
		}catch(SQLException ex) {
			throw new JdbcException(ex.getMessage(),ex);
			
		}finally {
			try { 
				if(connection!=null)
					connection.close();
			}catch(Exception ex) {
				throw new JdbcException(ex.getMessage(),ex);
			}
		}
	}

}
