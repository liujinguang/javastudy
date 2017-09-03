package corejava.v2ch01.ZipTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 * @author bob
 *
 */
public class ZipTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				ZipTestFrame frame = new ZipTestFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class ZipTestFrame extends JFrame {

	public ZipTestFrame() {
		setTitle("ZipTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// add the menu and the open and Exit menu items
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");

		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("."));

				int r = chooser.showOpenDialog(ZipTestFrame.this);
				if (r == JFileChooser.APPROVE_OPTION) {
					zipname = chooser.getSelectedFile().getPath();
					fileCombo.removeAllItems();
					scanZipFile();
				}
			}
		});

		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menuBar.add(menu);
		setJMenuBar(menuBar);

		// add the text area and combo box
		fileText = new JTextArea();
		fileCombo = new JComboBox<String>();
		fileCombo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				loadZipFile((String) fileCombo.getSelectedItem());
			}
		});

		add(fileCombo, BorderLayout.SOUTH);
		add(new JScrollPane(fileText), BorderLayout.CENTER);
	}

	public void scanZipFile() {
		new SwingWorker<Void, String>() {

			@Override
			protected Void doInBackground() throws Exception {
				ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
				ZipEntry entry;

				while ((entry = zin.getNextEntry()) != null) {
					publish(entry.getName());
					zin.closeEntry();
				}

				zin.close();

				return null;
			}

			protected void process(List<String> chunks) {
				for (String name : chunks) {
					fileCombo.addItem(name);
				}
			};

		}.execute();
	}

	/**
	 * Loads a file from the ZIP archive into the text area.
	 * 
	 * @param name
	 */
	public void loadZipFile(final String name) {
		fileCombo.setEnabled(false);
		fileText.setText("");

		new SwingWorker<Void, Void>() {

			@Override
			protected Void doInBackground() throws Exception {
				try {
					ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
					ZipEntry entry;

					// find entry with matching name in archive
					while ((entry = zin.getNextEntry()) != null) {
						if (entry.getName().equals(name)) {
							// read entry into text area
							Scanner in = new Scanner(zin);
							while (in.hasNextLine()) {
								fileText.append(in.nextLine());
								fileText.append("\n");
							}
						}
						zin.closeEntry();
					}
					zin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return null;
			}

			protected void done() {
				fileCombo.setEnabled(true);
			};

		}.execute();
	}

	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 300;
	private JComboBox<String> fileCombo;
	private JTextArea fileText;
	private String zipname;
}
