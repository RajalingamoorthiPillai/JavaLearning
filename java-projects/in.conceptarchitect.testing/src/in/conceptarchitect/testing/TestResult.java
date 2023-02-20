package in.conceptarchitect.testing;

import java.lang.reflect.Method;

public class TestResult {
	
	String testName;
	TestStatus status; //Ignored,Passed,Failed,Error
	Throwable exception;
	Method method;
	public TestResult(String testName, TestStatus status, Method method) {
		super();
		this.testName = testName;
		this.status = status;
		this.method = method;
	}
	public TestResult(String testName, TestStatus status, Method method, Throwable exception) {
		super();
		this.testName = testName;
		this.status = status;
		this.method = method;
		this.exception = exception;
	}
	public String getTestName() {
		return testName;
	}
	public TestStatus getStatus() {
		return status;
	}
	public Throwable getException() {
		return exception;
	}
	public Method getMethod() {
		return method;
	}
	
	
	

}
