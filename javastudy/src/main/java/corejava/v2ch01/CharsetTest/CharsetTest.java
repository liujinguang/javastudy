package v2ch01.CharsetTest;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

public class CharsetTest {
	public static void main(String[] args) {
		Charset charset = Charset.forName("ISO-8859-1");
		Set<String> aliases = charset.aliases();
		for (String alias : aliases) {
			System.out.println(alias);
		}
		
		Map<String, Charset> charsets = Charset.availableCharsets();
		for (String name:charsets.keySet()) {
			System.out.println(name);
		}
	}
}
