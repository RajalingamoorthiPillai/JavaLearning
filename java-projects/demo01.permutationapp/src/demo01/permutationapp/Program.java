package demo01.permutationapp;

import in.conceptarchitect.calculators.Maths;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int r=3;
		Maths m=new Maths();
		
		int p= m.permutation(n,r); 
		System.out.printf("%d P %d = %d\n",n,r,p);
	}

}
