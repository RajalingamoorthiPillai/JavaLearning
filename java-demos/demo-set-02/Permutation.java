class Permutation{

	static int calculate(int n,int r){
		
		return Math.factorial(n)/Math.factorial(n-r);

	}

	public static void main(String[]args){
		System.out.println("Help for Permutation:");
		System.out.println("Permutation.calculate(n,r)");
		System.out.printf("Example: Permutation.calculate(8,3)=%d\n",calculate(8,3));
	}

}