package in.conceptarchitect.commons;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface Speciality {
	
	//this is treated as a field
	//it is passed as a named parameter to Speciality annotation
	public String behavior();

}
