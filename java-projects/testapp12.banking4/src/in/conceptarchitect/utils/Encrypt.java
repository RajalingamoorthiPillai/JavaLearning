package in.conceptarchitect.utils;

public class Encrypt {
	
	public String encrypt(String string) {
		var output="";
		
		
		
		for(int i=0;i<string.length();i++)
			output+=String.format("%x", (int) string.charAt(i));
		
		return output;
	}

}
