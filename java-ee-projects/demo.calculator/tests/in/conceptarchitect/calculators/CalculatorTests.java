package in.conceptarchitect.calculators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CalculatorTests {

	Calculator calc;
	double x=50;
	double y=30;
	
	
	
	 @BeforeEach
	 public void setup() {
		 calc=new Calculator();
		 calc.addOperator("+", (x,y)->x+y);
		 calc.addOperator("-",(x,y)->x-y);
		 calc.setPresenter(output->{}); //do nothing presenter
	 }
	
	
	@Test
	void throwsErrorForInvalidOperator() {
		
		calc.calculate(10, "*", 2);
		var ex= assertThrows(IllegalArgumentException.class,()->{
			
		});
		
		assertEquals("Invalid operator: *", ex.getMessage());
	}
	
	
	@Test
	public void calculatorCanDoExactCalculationForValidOperator() {
		
		calc.setFomatter((a,s,b,result)->{
			assertEquals(x+y, result);
			return "Result:"+result;
		});
		
		calc.calculate(x, "+" , y);
	}
	
	@Test
	public void calculatorCanDoMinus() {
		
		calc.setFomatter((a,s,b,result)->result);
		
		calc.setPresenter(result-> assertEquals(x-y,(double)result,0.01));
		
		
		calc.calculate(x, "-", y);
	}
	

}
