package in.conceptarchitect.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

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
			
			//new com.mysql.jdbc.Driver();
			
			//Class.forName("com.mysql.jdbc.Driver");
			
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

	public int executeUpdate(String qry) {
		
		return executeCommand(connection->{
			var statement=connection.createStatement();
			return statement.executeUpdate(qry);
		});
	}
	
	public int executePrepared(String query, StatementBuilder builder) {
		
		return executeCommand(connection->{
			
			var statement= connection.prepareStatement(query);
			builder.build(statement);
			return statement.executeUpdate();
			
		}) ;
	}
	
	
	public <X> List<X> queryAll(String query/*,???*/){
		
		return null;
	}
	
	public <X>   X   queryOne(String query /*,???*/) {
		return null;
	}
	
	
	
	
	
	
}
