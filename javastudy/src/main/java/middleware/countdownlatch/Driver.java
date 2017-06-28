package middleware.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Driver {
	public static void main(String[] args) {
		int count = 10;
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(count);
		
		for (int i = 0; i < count; i++) {
			new Thread(new Worker(startSignal, doneSignal)).start();
		}
		
		//don't let run yet, do something else here.
		
		//let all threads proceed
		startSignal.countDown();
		
		//do something else
		
		//wait for all to finish
		try {
			doneSignal.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
