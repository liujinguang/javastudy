package v1ch14.FutureTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//D:\Github\corejava8\corejava8\src\main\java
		System.out.println("Enter base directory(e.g. /usr/local/jdk5.0/src)");
		String directory = in.nextLine();
		//Thread
		System.out.println("Enter keyword (e.g. volatile)");
		String keyword = in.nextLine();
		in.close();

		MatchCounter counter = new MatchCounter(new File(directory), keyword);
		FutureTask<Integer> task = new FutureTask<Integer>(counter);
		Thread t = new Thread(task);
		t.start();

		try {
			System.out.println(task.get() + " matching files");
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/**
 * This task counts the files in a directory and its subdirectories that contain
 * a keyword
 * 
 * @author jliu
 *
 */
class MatchCounter implements Callable<Integer> {

	public MatchCounter(File directory, String keyword) {
		super();
		this.directory = directory;
		this.keyword = keyword;
	}

	public Integer call() throws Exception {
		count = 0;

		try {
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<Future<Integer>>();

			for (File file : files) {
				if (file.isDirectory()) {
					MatchCounter counter = new MatchCounter(file, keyword);
					FutureTask<Integer> task = new FutureTask<Integer>(counter);
					results.add(task);
					Thread thread = new Thread(task);
					thread.start();
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
}