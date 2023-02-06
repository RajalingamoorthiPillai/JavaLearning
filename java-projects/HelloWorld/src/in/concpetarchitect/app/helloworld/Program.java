package in.concpetarchitect.app.helloworld;


import in.concpetarchitect.maths.Permutation;

public class Program {
	
	

	public static void main(String[] args) {
		int n=5;
		var r=3;
		
		
		
		//Permutation calc=new Permutation();
		var calc=new Permutation();
		
		var p= calc.calculate(n,r);
		
		

		
		System.out.printf("%d P %d  = %d\n",n,r,p );
		
		
	}

}
