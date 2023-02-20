package in.conceptarchitect.app;

import in.conceptarchitect.testing.TestReporter;
import in.conceptarchitect.testing.TestRunner;
import testapp13.reflection.ReflectionTests;

public class Program {

	public static void main(String[] args) {
		TestRunner runner=new TestRunner();
	
		var results = runner.run(ReflectionTests.class);
		
		var reporter=new TestReporter(results);
		
		var report =reporter.generate();
		
		System.out.println(report);
		
	}
	

}
