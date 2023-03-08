package in.conceptarchitect.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;



public class ResultSetToObject {

	public static void build(Object object, ResultSet rs) throws SQLException {
		//reflection!!!
		Class cls=object.getClass();
		for(var field : object.getClass().getDeclaredFields()) {
			try {
				var fieldName=field.getName();
				var rsData=rs.getObject(fieldName);
				var setterMethodName=String.format("set%s%s", fieldName.substring(0,1).toUpperCase(),fieldName.substring(1));
				var method=cls.getMethod(setterMethodName, field.getType());
			method.invoke(object, rsData);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
