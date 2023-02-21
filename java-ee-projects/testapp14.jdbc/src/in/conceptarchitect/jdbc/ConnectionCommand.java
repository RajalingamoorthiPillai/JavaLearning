package in.conceptarchitect.jdbc;

import java.sql.Connection;

public interface ConnectionCommand<T> {

	T execute(Connection connection);

}
