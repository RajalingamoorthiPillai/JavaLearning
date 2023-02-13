package in.conceptarchitect.banking.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MySimpleTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before all");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After all");
	}
	
	public MySimpleTest(){
		System.out.println("Test Object created");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before ");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after");
	}

	@Test
	public void test1() {
		System.out.println("test1");
	}
	@Test
	public void test2() {
		System.out.println("test2");
	}
	@Test
	public void test3() {
		System.out.println("test3");
	}
	@Test
	public void test4() {
		System.out.println("test4");
	}

}
