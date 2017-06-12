package v1ch14.blockingQueue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter base directory (e.g. /usr/local/jdk1.6.0/src):");
		String directory = in.nextLine();
		System.out.print("Enter keyword (e.g. volatile):");
		String keyword = in.nextLine();
		
		final int FILE_QUEUE_SIZE = 10;
		final int SEARCH_THREADS = 100;
		
		BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);
		new Thread(new FileEnumerationTask(queue, new File(directory))).start();
		
		for (int i = 1; i <= SEARCH_THREADS; i++) {
			new Thread(new SearchTask(queue, keyword)).start();  
		}
	}
}

/**
 * This task enumerates all files in a directory and its subdirectories
 * 
 * @author jliu
 *
 */
class FileEnumerationTask implements Runnable {

	public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory) {
		super();
		this.queue = queue;
		this.startingDirectory = startingDirectory;
	}

	public void run() {
		try {
			enumerate(startingDirectory);
			queue.put(DUMMY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enumerate(File directory) throws InterruptedException {
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				enumerate(file);
			} else {
				queue.put(file);
			}
		}
	}

	public static File DUMMY = new File("");

	private BlockingQueue<File> queue;
	private File startingDirectory;

}

/**
 * This task search files for a given keyword
 * 
 * @author jliu
 *
 */
class SearchTask implements Runnable {

	/**
	 * Constructs a SearchTask
	 * 
	 * @param queue
	 * @param keyword
	 */
	public SearchTask(BlockingQueue<File> queue, String keyword) {
		super();
		this.queue = queue;
		this.keyword = keyword;
	}

	public void run() {
		try {
			boolean done = false;
			while (!done) {
				File file = queue.take();
				if (file == FileEnumerationTask.DUMMY) {
					queue.put(file);
					done = true;
				} else {
					search(file);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

	public void search(File file) throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream(file));

		int lineNumber = 0;

		while (in.hasNextLine()) {
			lineNumber++;
			String line = in.nextLine();
			if (line.contains(keyword)) {
				System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
			}
		}
		in.close();
	}

	private BlockingQueue<File> queue;
	private String keyword;
}
