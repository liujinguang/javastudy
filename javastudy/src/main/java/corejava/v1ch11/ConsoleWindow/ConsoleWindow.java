package v1ch11.ConsoleWindow;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;;

/**
 * A window that displays the bytes sent to System.out and System.err
 * 
 * @author jliu
 *
 */
public class ConsoleWindow {
	public static void init() {
		JFrame frame = new JFrame();
		frame.setTitle("ConsoleWindow");
		final JTextArea output = new JTextArea();
		output.setEditable(false);
		frame.add(new JScrollPane(output));
		frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		frame.setLocation(DEFAULT_LEFT, DEFAULT_TOP);
		frame.setVisible(true);
		frame.setFocusableWindowState(false);

		PrintStream consoleStream = new PrintStream(new OutputStream() {

			@Override
			public void write(int b) throws IOException {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void write(byte[] b, int off, int len) {
				output.append(new String(b, off, len));
			}
		});
		
		System.setOut(consoleStream);
		System.setErr(consoleStream);
	}

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	public static final int DEFAULT_LEFT = 200;
	public static final int DEFAULT_TOP = 200;
}
