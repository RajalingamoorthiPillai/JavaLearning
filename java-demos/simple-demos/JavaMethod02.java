class Program{


	

	public static void main(String []args){
		
		int a= sumSquare(5,3); //
		System.out.println(a);

		int b= sumSquare(4,6);
		System.out.println(b);

	}


	static int sumSquare(int a, int b){

		int c= a+b;

		return c*c;
	}

}