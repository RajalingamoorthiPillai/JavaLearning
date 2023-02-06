package in.concpetarchitect.maths;

public class Factorial {
	
	 int calculate(int x) {
		if(x<=1)
			return 1;
		else
			return x* calculate(x-1);
	}

}
