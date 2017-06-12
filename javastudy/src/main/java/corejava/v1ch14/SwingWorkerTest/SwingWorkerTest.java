package v1ch14.SwingWorkerTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class SwingWorkerTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				JFrame frame = new SwingWorkerFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * This frame has a text area to show the contents of a text file, a menu to
 * open a file and canel the opening process, and a status line to show the file
 * loading progress
 * 
 * @author jliu
 *
 */
class SwingWorkerFrame extends JFrame {
	public SwingWorkerFrame() {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));

		textArea = new JTextArea();
		add(new JScrollPane(textArea));
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		statusLine = new JLabel("");
		add(statusLine, BorderLayout.SOUTH);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		openItem = new JMenuItem("Open");
		fileMenu.add(openItem);
		openItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// show file chooser dialog
				int result = chooser.showOpenDialog(null);

				// if file selected, set it as icon of the label
				if (result == JFileChooser.APPROVE_OPTION) {
					textArea.setText("");
					openItem.setEnabled(false);
					textReader = new TextReader(chooser.getSelectedFile());
					textReader.execute();
					cancelItem.setEnabled(true);
				}
			}
		});

		cancelItem = new JMenuItem("Cancel");
		fileMenu.add(cancelItem);
		cancelItem.setEnabled(false);
		cancelItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textReader.cancel(true);
			}
		});
	}

	private class ProgressData {
		public ProgressData(int number, String line) {
			super();
			this.number = number;
			this.line = line;
		}

		public int getNumber() {
			return number;
		}

		public String getLine() {
			return line;
		}

		private int number;
		private String line;
	}

	private class TextReader extends SwingWorker<StringBuilder, ProgressData> {
		public TextReader(File file) {
			this.file = file;
			text = new StringBuilder();
			// TODO Auto-generated constructor stub
		}

		// the following method excutes in the worker thread, it doesn't touch
		// swing components
		@Override
		protected StringBuilder doInBackground() throws Exception {
			int lineNumber = 0;
			Scanner in = new Scanner(new FileInputStream(file));
			while (in.hasNextLine()) {
				String line = in.nextLine();
				lineNumber++;
				text.append(line);
				text.append("\n");
				ProgressData data = new ProgressData(lineNumber, line);
				publish(data);

				Thread.sleep(2); // to test cancellation, no need to do this in
									// your programs
			}

			return text;
		}

		// the following methods execute in the event dispatch thread
		@Override
		protected void process(List<ProgressData> chunks) {
			if (isCancelled()) {
				return;
			}

			StringBuilder builder = new StringBuilder();
			statusLine.setText("" + chunks.get(chunks.size() - 1).number);
			for (ProgressData d : chunks) {
				builder.append(d.getLine() + "\n");
			}

			textArea.append(builder.toString());
		}

		@Override
		protected void done() {
			StringBuilder result;
			try {
				result = get();
				textArea.setText(result.toString());
				statusLine.setText("Done");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				statusLine.setText("" + e.getCause());
			} catch (CancellationException e) {
//				textArea.setText("");
				statusLine.setText("Cancelled");
			}

			cancelItem.setEnabled(false);
			openItem.setEnabled(true);
		}

		private File file;
		private StringBuilder text;
	}

	private JFileChooser chooser;
	private JTextArea textArea;
	private JLabel statusLine;
	private JMenuItem openItem;
	private JMenuItem cancelItem;
	private SwingWorker<StringBuilder, ProgressData> textReader;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 350;
}