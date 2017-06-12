package v1ch11.StackTraceTest;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * A program that displays a trace feature of a recursive method call
 * @author jliu
 *
 */
public class StackTraceTest {
	public static int factorial(int n) {
		System.out.println("factorial(" + n +")");
		Throwable t = new Throwable();
		StackTraceElement[] frames = t.getStackTrace();
		for (StackTraceElement f:frames) {
			System.out.println(f);
		}
		
		int r;
		if (n <=1) {
			r=1;
		} else {
			r = n * factorial(n-1);
		}
		
		System.out.println("return " + r);
//		Logger.global.info("return " + r);
		Logger.getGlobal().info("return " + r);
		
		return r;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter n:");
		int n = in.nextInt();
		assert n > 0;
		factorial(n);
	}
}
