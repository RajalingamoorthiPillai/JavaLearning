package in.conceptarchitect.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface ConnectionCommand<T> {

	T execute(Connection connection) throws SQLException;
	
	//void handleError();

}
