package middleware.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter2 {
	private AtomicInteger counter = new AtomicInteger();
	
	public int increase() {
		return counter.incrementAndGet();
	}
	
	public int decrease() {
		return counter.decrementAndGet();
	}
}
