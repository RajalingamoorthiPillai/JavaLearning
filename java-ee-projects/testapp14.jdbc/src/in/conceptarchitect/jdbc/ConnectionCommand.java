package in.conceptarchitect.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionCommand<T> {

	T execute(Connection connection) throws SQLException;

}
