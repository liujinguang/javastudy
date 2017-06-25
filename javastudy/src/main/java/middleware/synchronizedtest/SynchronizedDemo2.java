package middleware.synchronizedtest;

/**
 * @author bob
 * foo3() and foo4() are mutual exclusive for the same instance in different threading
 */
public class SynchronizedDemo2 {
	public synchronized void foo3() {
		
	}
	
	public synchronized void foo4() {
		
	}
}
