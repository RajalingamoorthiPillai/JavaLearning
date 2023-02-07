package testapp05.stringvsstringbuilder;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testPerformance(10000);
	}
	
	static void testPerformance(int count) {
		
		var start=System.currentTimeMillis();
		var s1=buildStarsString(count);
		var end=System.currentTimeMillis();
		System.out.printf("buildStartsString took %d ms\n",end-start);
		
		
		start=System.currentTimeMillis();
		var s2=buildStarsUsingStringBuilder(count);
		end=System.currentTimeMillis();
		System.out.printf("buildStartsUsingStringBuilder took %d ms\n",end-start);
		
		System.out.printf("s1==s2 : %b\ns1.equals(s2) : %b\n",
				s1==s2,
				s1.equals(s2));
		
		
		
	}
	
	static String buildStarsString(int count) {
		String str="";
		for(int i=0;i<count;i++)
			str+="*";
		
		return str;
	}
	
	static String buildStarsUsingStringBuilder(int count) {
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<count;i++)
			builder.append("*");
		
		return builder.toString();
	}

}
