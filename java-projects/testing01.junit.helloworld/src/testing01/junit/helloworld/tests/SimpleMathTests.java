package testing01.junit.helloworld.tests;

//importing a static method from class
//now we can use this static method without using class reference
import static org.junit.Assert.assertEquals; 

import org.junit.Test;

import testing01.junit.helloworld.SimpleMath; 

public class SimpleMathTests {
	
	int x=50;
	int y=15;
	
	@Test
	public void testPlus() {
		var result= SimpleMath.plus(x, y);
		assertEquals(x+y, result);
	}
	@Test
	public void testMinus() {
		var result= SimpleMath.minus(x, y);
		assertEquals(x-y, result);
	}
	@Test
	public void testMultiply() {
		var result= SimpleMath.multiply(x, y);
		assertEquals(x*y, result);
	}
	@Test
	public void testDivide() {
		var result= SimpleMath.divide(x, y);
		assertEquals(x/y, result);
	}

}
