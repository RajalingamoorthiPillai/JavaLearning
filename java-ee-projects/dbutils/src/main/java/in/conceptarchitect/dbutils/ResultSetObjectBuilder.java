package in.conceptarchitect.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetObjectBuilder<T> {

	void build(T obj, ResultSet resultSet) throws SQLException;

}
