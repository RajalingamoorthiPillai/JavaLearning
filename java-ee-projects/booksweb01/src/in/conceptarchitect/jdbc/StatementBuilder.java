package in.conceptarchitect.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementBuilder {
	
	void build(PreparedStatement statement) throws SQLException;

}
