package unittest.junittest;

import static org.junit.Assert.*;

//import org.hamcrest.Matchers;
//
import static org.hamcrest.Matchers.*;
//
//import org.hamcrest.Matchers;  

import org.junit.Before;
import org.junit.Test;

public class TestCalCulate {
	private Calcuate cal = null;

	// 执行任意一个方法之前都会仔细setUp方法
	@Before
	public void setUp() {
		cal = new Calcuate();
	}

	@Test
	public void testAdd() {
		int rel = cal.add(12, 22);
		assertEquals("add() has issue", rel, 34);
	}

	@Test
	public void testMinus() {
		int rel = cal.minus(20, 10);
		assertEquals(rel, 10);
	}

	@Test(expected = ArithmeticException.class)
	public void testDivideException() {
		cal.divide(20, 0);
	}

	@Test(timeout = 2000)
	public void testTime() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("sleep finishes");
	}

	@Test
	public void testMul() {
		int rel = cal.mul(10, 5);
		assertEquals(rel, 50);
	}
	
	@Test
	public void testHamcrest() {
		assertThat(50, allOf(greaterThan(20), lessThan(60)));
		assertThat("abc.txt", endsWith("txt"));
	}
}
