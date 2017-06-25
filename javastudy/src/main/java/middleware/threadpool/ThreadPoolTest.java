package middleware.threadpool;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	public static void testWithPool(int count) {
		long startTime = System.currentTimeMillis();
		final List<Integer> l = new LinkedList<Integer>();

		ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>(count));
		final Random random = new Random();

		for (int i = 0; i < count; i++) {
			tp.execute(new Runnable() {

				public void run() {
					l.add(random.nextInt());
				}
			});
		}
		tp.shutdown();

		try {
			tp.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(l.size());
	}

	public static void testWithoutPool(int count) {
		long startTime = System.currentTimeMillis();
		final List<Integer> l = new LinkedList<Integer>();

		final Random random = new Random();

		for (int i = 0; i < count; i++) {
			Thread thread = new Thread(new Runnable() {

				public void run() {
					l.add(random.nextInt());

				}
			});

			thread.start();

			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(l.size());
	}

	public static void main(String[] args) {
		testWithPool(200000);
		testWithoutPool(200000);

	}

}
