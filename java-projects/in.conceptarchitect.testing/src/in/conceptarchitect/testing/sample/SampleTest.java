package in.conceptarchitect.testing.sample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SampleTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void failingTest() {
		fail("Not yet implemented");
	}

	@Test
	public void passingTest() {
		
	}
	
	@Test
	public void yetAnotherFailingTest() {
		assertEquals(2,3);
	}
}
