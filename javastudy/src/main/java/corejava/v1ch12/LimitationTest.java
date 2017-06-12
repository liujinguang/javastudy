package v1ch12;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LimitationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRawType() {
		Pair<String> stringPair = new Pair<String>("Hello", "World");
		Pair<Double> doublePair = new Pair<Double>(10.2, 11.3);
		if (stringPair.getClass() == doublePair.getClass()) {
			System.out.println("Pair<String> and Pair<Double> have the same raw type");
			System.out.println(stringPair.getClass());
			
		}
		
		assertEquals(stringPair.getClass(), doublePair.getClass());
		assertTrue(stringPair instanceof Pair);
	}

}
