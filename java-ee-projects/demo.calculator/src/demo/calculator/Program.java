package demo.calculator;

import in.conceptarchitect.calculators.Calculator;

public class Program {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var calc= new Calculator();


		calc.addOperator("+" , (x,y) -> x+y);

		calc.addOperator("-", (x,y) -> x-y);


		calc.calculate(5, "+", 2);  //should print 5+2=7

		calc.calculate(5,"-",2);  //should print 5-2=3
		
		
		calc.setFomatter((a,b,s,r)->r);
		
		calc.setPresenter(System.err::println);
		
		calc.calculate(5, "+", 2);  //should print 5+2=7

		calc.calculate(5,"-",2);  //should print 5-2=3
		

		calc.calculate(5,"*",2); //should throw InvalidArumentException


	}

}
