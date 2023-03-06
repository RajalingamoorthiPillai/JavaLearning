package in.conceptarchitect.dbutils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementBuilder {
	
	void build(PreparedStatement statement) throws SQLException;

}
