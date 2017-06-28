package middleware.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;
	
	public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}

	public void run() {
		
		try {
			startSignal.await();
			
			doWork();
			
			doneSignal.countDown();			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void doWork() {
		System.out.println("do work now...");
	}

}
