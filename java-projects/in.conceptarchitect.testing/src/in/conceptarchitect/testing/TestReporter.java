package in.conceptarchitect.testing;

import java.util.List;

public class TestReporter {

	List<TestResult> results;

	public TestReporter(List<TestResult> results) {
		super();
		this.results = results;
	}
	
	public String generate() {
		StringBuilder builder=new StringBuilder();
		int total=results.size();
		int passed=0;
		int failed=0;
		int ignored=0;
		int errors=0;
		
		for(var result : results) {
			var status=result.getStatus();
			var name=result.getTestName();
			
			builder.append(String.format("%s:\t %s\n",status, name));
			if(status==TestStatus.Passed) {
				passed++;
				
			} else if(status==TestStatus.Ignored) {
				ignored++;
				
			} else if(status==TestStatus.Failed) {
				builder.append(String.format("\t%s\n",result.getException().getMessage()));
				failed++;
			}else {
				errors++;
				builder.append(String.format("\t%s: %s\n",result.getException(), result.getException().getMessage()));
			}
			
		}
		
		builder.append(String.format("T:%d\tP:%d\tF:%d\tE:%d\tI:%d\n",total,passed,failed,errors,ignored));
		
		return builder.toString();
	}
	
	
}
