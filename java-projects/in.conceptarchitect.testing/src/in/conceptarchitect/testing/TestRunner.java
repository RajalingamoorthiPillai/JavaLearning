package in.conceptarchitect.testing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class TestRunner {

	public List<TestResult> run(Class cls) {
		
		Method beforeMethod=null;
		Method afterMethod=null;
		List<Method> testMethods=new ArrayList<>();
		List<TestResult> results=new ArrayList<>();
		//Step #1 get a list of needed methods
		for(var method : cls.getMethods()) {
			
			if(method.isAnnotationPresent(Before.class) || method.isAnnotationPresent(Setup.class))
				beforeMethod=method;
			if(method.isAnnotationPresent(After.class) || method.isAnnotationPresent(Cleanup.class))
				afterMethod=method;
			else if(method.isAnnotationPresent(Test.class) || method.isAnnotationPresent(TestMethod.class))
				testMethods.add(method);
			
		}
		
		//Step #2 run test for each method and create the result
		for(var method: testMethods) {
			
			try {
				
				if(method.isAnnotationPresent(Ignore.class)) {
					results.add(new TestResult(method.getName(),TestStatus.Ignored,method));
					continue;
				}
				
				var testObject = cls.getConstructor().newInstance();
				//run the setup metho if present
				if(beforeMethod!=null)
					beforeMethod.invoke(testObject);
				
				method.invoke(testObject);
				
				if(afterMethod!=null)
					afterMethod.invoke(testObject);
				
				results.add(new TestResult(method.getName(), TestStatus.Passed,method));
				
				
				
				
				
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				throw new TestInitializationException("Couldn't Initialize the Test",e);
			}catch(InvocationTargetException ex) {
				var actualException = ex.getCause();
				if(actualException instanceof AssertionError) {
					//test failed
					results.add(new TestResult(method.getName(),TestStatus.Failed,method,actualException));
				} else {
					results.add(new TestResult(method.getName(),TestStatus.Error,method,actualException));
				}
			}
			
		}
		
		
		
		
		
		return results;
		
	}

}
