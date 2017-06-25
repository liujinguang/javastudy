package middleware.synchronizedtest;

public class SynchronizedDemo3 {
	public void foo5() {
		synchronized(this) { ///same as usage SynchronizedDemo2
			
		}
	}
	
	public void foo6() {
		synchronized(SynchronizedDemo3.class) { ///same as usage SynchronizedDemo1
			
		}
	}
}
