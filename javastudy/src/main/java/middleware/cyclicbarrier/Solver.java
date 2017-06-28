package middleware.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
 * A synchronization aid that allows a set of threads to all wait for each other 
 * to reach a common barrier point. CyclicBarriers are useful in programs involving 
 * a fixed sized party of threads that must occasionally wait for each other. The 
 * barrier is called cyclic because it can be re-used after the waiting threads are released.
 * A CyclicBarrier supports an optional Runnable command that is run once per barrier 
 * point, after the last thread in the party arrives, but before any threads are released. 
 * This barrier action is useful for updating shared-state before any of the parties continue. 
 * */
public class Solver {

	class Worker implements Runnable {
		int myRow;
		
		public Worker(int row) {
			myRow = row;
		}
		
		public void run() {
			//process row here
			
			try {
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public Solver(float[][] matrix) {
		data = matrix;
		N = matrix.length;
		
		barrier = new CyclicBarrier(N, new Runnable() {
			
			public void run() {
				//merge row here
			}
		});
		
		for (int i = 0; i < N; i++) {
			new Thread(new Worker(i)).start();
		}
		
		
		//wait until done
	}
	
	private final int N;
	private float[][] data;
	private CyclicBarrier barrier;
}
