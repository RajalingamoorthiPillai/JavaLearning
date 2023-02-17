package in.conceptarchitect.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyPad {

	BufferedReader reader;

	public KeyPad() {
		reader=new BufferedReader(new InputStreamReader(System.in));
	}
	
	public String readString(String prompt) {
		try {
			System.out.print(prompt);
			return reader.readLine();
		}catch(Exception ex) {
			return "";
		}
	}
	
	public int readInt(String prompt) {
		try {
			var str=readString(prompt);
			return Integer.parseInt(str);
		}catch(Exception ex) {
			return 0;
		}
	}
	
	
}
