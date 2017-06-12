package interview.string;

public class StringTest {
	
	public StringTest() {
		System.out.println(name);
	}
	
	//对于字符串常量，如果内容相同，Java 认为它们代表同一个 String 对象。而用关键字 new 
	//调用构造器，总是会创建一个新的对象，无论内容是否相同。
	public static void testcase01() {
		String str1 = "Hello";
		String str2 = "Hello";
		
		System.out.println(str1 == str2);
	}
	
	public static void testcase02() {
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		
		System.out.println(str1 == str2);	
	}
	
	/*
	 * 如果经常对字符串进行各种各样的修改，或者说，不可预见的修改，那么使用 String 来代表字符串的话会引起很大的内存开销。
	 * 因为 String 对象建立之后不能再改变，所以对于每一个不同的字符串，都需要一个 String 对象来表示。这时，应该考虑使用
	 *  StringBuffer 类，它允许修改，而不是每个不同的字符串都要生成一个新的对象。并且，这两种类的对象转换十分容易。
	 */
	public static void testcase03() {
		String str1 = "hello";
		String str2 = "he" + new String("llo");
		System.err.println(str1 == str2);  
	}
	
	public static void testcase04() {
		String str1;
		
//		System.out.println(str1);
	}
	
	
	/*
	 * 第一条语句打印的结果为 false ，第二条语句打印的结果为 true，这说明 Javac 编译可以对字符串常量直接相加的表达式进
	 * 行优化，不必要等到运行期去进行加法运算处理，而是在编译时去掉其中的加号，直接将其编译成一个这些常量相连的结果。
	 */
	public static void testcase05() {
		String s1 = "a";

		String s2 = s1 + "b";

		String s3 = "a" + "b";

		System.out.println(s2 == "ab");

		System.out.println(s3 == "ab");	
	}

	public static void main(String[] args) {
//		testcase01();
		
//		testcase02();
//		
//		new StringTest();
		
		testcase05();

	}

	private String name;
}
