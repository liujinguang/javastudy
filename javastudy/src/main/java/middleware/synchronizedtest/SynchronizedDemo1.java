package middleware.synchronizedtest;

public class SynchronizedDemo1 {
	//these methods are mutual exclusive in diffrent threads
	public synchronized static void foo1() {
		
	}
	
	public synchronized static void foo2() {
		
	}
}
