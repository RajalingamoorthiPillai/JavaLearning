package in.conceptarchitect.calculators;

public class Maths {

	public int factorial(int n) {
		if(n>1)
			return n*factorial(n-1);
		else
			return 1;
	}
	
	public int permutation(int n,int r) {
		return factorial(n)/factorial(n-r);
	}
}
