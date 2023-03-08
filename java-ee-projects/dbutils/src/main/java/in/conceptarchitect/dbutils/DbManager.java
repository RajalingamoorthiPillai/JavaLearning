package in.conceptarchitect.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



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
	
	
	public <X> List<X> queryAll(String query, Class<X> cls, ResultSetObjectBuilder<X> objectBuilder){
		
		return executeCommand(connection->{
			List<X> result=new ArrayList<X>();
			var statement= connection.createStatement();
			var resultSet= statement.executeQuery(query);
			
			while(resultSet.next()) {
				X obj;
				try {
					obj = (X)cls.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					throw new JdbcException("Error creating Object ",e);
				}
				objectBuilder.build(obj,resultSet);
				
				result.add(obj);
			}
			
			
			return result;
		});
	}
	
	public <X>   X   queryOne(String query, Class<X>cls, ResultSetObjectBuilder<X> objectBuilder) {
		return executeCommand(connection->{
			
			var statement= connection.createStatement();
			var resultSet= statement.executeQuery(query);
			
			if(resultSet.next()) {
				
				X obj;
				try {
					obj = (X)cls.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					throw new JdbcException("Error creating Object ",e);
				}
				objectBuilder.build(obj,resultSet);
				
				return obj;
			}
			
			
			return null;
		});
	}
	
	
	
	
	
	
}
