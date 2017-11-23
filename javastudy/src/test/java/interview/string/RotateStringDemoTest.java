package interview.string;

import org.junit.Test;
import static org.junit.Assert.*;
import static interview.string.RotateStringDemo.*;

public class RotateStringDemoTest {
	@Test
	public void testIsRotatedVersion() {
		assertTrue(isRotatedVersion("abc", "bca"));
		assertTrue(isRotatedVersion("abc", "cab"));
		assertTrue(isRotatedVersion("abcead", "dabcea"));
		assertTrue(isRotatedVersion("aabbccdd", "ddaabbcc"));
		assertFalse(isRotatedVersion("abc", "bac"));
		assertFalse(isRotatedVersion("abc", null));
		assertFalse(isRotatedVersion("abc", ""));
		
	}

	@Test
	public void testisRotated() {
		assertTrue(isRotated("1234", "2341"));
		assertTrue(isRotated("1234", "3412"));
		assertTrue(isRotated("1234", "4123"));
		assertTrue(isRotated("abcead", "dabcea"));
		assertTrue(isRotated("aabbccdd", "ddaabbcc"));
		assertFalse(isRotated("1234", "23s41"));
		assertFalse(isRotated("1234", null));
		assertFalse(isRotated("1234", ""));
	}
}
