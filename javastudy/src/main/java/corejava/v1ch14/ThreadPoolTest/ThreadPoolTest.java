package v1ch14.ThreadPoolTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// D:\Github\corejava8\corejava8\src\main\java
		System.out.println("Enter base directory(e.g. /usr/local/jdk5.0/src)");
		String directory = in.nextLine();
		// Thread
		System.out.println("Enter keyword (e.g. volatile)");
		String keyword = in.nextLine();
		in.close();
		
		ExecutorService pool = Executors.newCachedThreadPool();

		MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
		Future<Integer> result = pool.submit(counter);

		try {
			System.out.println(result.get() + " matching files");
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown();
		
		int largestPoolSize =  ((ThreadPoolExecutor)pool).getLargestPoolSize();
		System.out.println("largest pool size=" + largestPoolSize);
		
	}
}

/**
 * This task counts the files in a directory and its sub-directories that contain
 * a keyword
 * 
 * @author jliu
 *
 */
class MatchCounter implements Callable<Integer> {

	/**
	 * @param directory the directory in which to start the search
	 * @param keyword the keyword to look for 
	 * @param pool the thread pool for submitting subtasks
	 */
	public MatchCounter(File directory, String keyword, ExecutorService pool) {
		super();
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
	}

	public Integer call() throws Exception {
		count = 0;

		try {
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<Future<Integer>>();

			for (File file : files) {
				if (file.isDirectory()) {
					MatchCounter counter = new MatchCounter(file, keyword, pool);
					Future<Integer> result = pool.submit(counter);
					results.add(result);
				} else {
					if (search(file))
						count++;
				}
			}

			for (Future<Integer> result : results) {
				try {
					count += result.get();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}

		} catch (InterruptedException e) {
			// TODO: handle exception
		}

		return count;
	}

	public boolean search(File file) {
		try {
			Scanner in = new Scanner(new FileInputStream(file));
			boolean found = false;

			while (!found && in.hasNextLine()) {
				String line = in.nextLine();
				if (line.contains(keyword)) {
					found = true;
				}
			}
			in.close();

			return found;
		} catch (IOException e) {
			return false;
		}
	}

	private File directory;
	private String keyword;
	private int count;
	private ExecutorService pool;
}