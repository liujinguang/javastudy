package middleware.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*
 * Another typical usage would be to divide a problem into N parts, 
 * describe each part with a Runnable that executes that portion and 
 * counts down on the latch, and queue all the Runnables to an Executor. 
 * When all sub-parts are complete, the coordinating thread will be able 
 * to pass through await. (When threads must repeatedly count down in this 
 * way, instead use a CyclicBarrier.) 
 * */
public class Driver2 {
	public static void main(String[] args) {
		int count = 10;

		CountDownLatch doneSignal = new CountDownLatch(count);
		 Executor executor = Executors.newCachedThreadPool();
		// workQueue);
		for (int i = 0; i < count; i++) {
			executor.execute(new WorkerRunnable(doneSignal, i));
		}

		try {
			doneSignal.await();  //wait for all to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class WorkerRunnable implements Runnable {
	private final CountDownLatch doneSignal;
	private final int i;

	public WorkerRunnable(CountDownLatch doneSignal, int i) {
		this.doneSignal = doneSignal;
		this.i = i;
	}

	public void run() {
		doWork(i);
		doneSignal.countDown();
	}

	public void doWork(int i) {

	}

}
