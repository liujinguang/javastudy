package middleware.atomic;

public class Counter1 {
	private int counter = 0;
	
	public int increate() {
		synchronized(this) {
			counter += 1;
			
			return counter;
		}
	}
	
	public int decrease(){
		synchronized (this) {
			counter -= 1;
			
			return counter;
		}
	}
}
