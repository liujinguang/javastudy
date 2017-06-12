package v2ch06;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LongListFrame extends JFrame {
	
	public LongListFrame() {
		setTitle("LongListTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		wordlist = new JList(new WordListModel(3));
		wordlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		wordlist.setPrototypeCellValue("www");
		JScrollPane scrollPane = new JScrollPane(wordlist);
		
		JPanel panel = new JPanel();
		panel.add(scrollPane);
		wordlist.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				StringBuilder word = (StringBuilder) wordlist.getSelectedValue();
				setSubject(word.toString());
			}
		});
		
		Container contentPanel = getContentPane();
		contentPanel.add(panel, BorderLayout.NORTH);
		label = new JLabel(prefix + suffix);
		contentPanel.add(label, BorderLayout.SOUTH);
		setSubject("fox");
	}
	
	public void setSubject(String word) {
		StringBuilder text = new StringBuilder(prefix);
		text.append(word);
		text.append(suffix);
		label.setText(text.toString());
	}
	
	public static void main(String[] args) {
		JFrame frame = new LongListFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
	
	private JList wordlist;
	private JLabel label;
	private String prefix = "The quick brown ";
	private String suffix = " jumps over the lazy dog.";
}

/**
 * A model that dynamically generates n-letter words
 * 
 * @author jliu
 *
 */
class WordListModel extends AbstractListModel {

	public WordListModel(int n) {
		length = n;
	}

	public int getSize() {
		return (int) Math.pow(LAST - FIRST + 1, length);
	}

	public Object getElementAt(int n) {
		StringBuilder r = new StringBuilder();

		for (int i = 0; i < length; i++) {
			char c = (char) (FIRST + n % (LAST - FIRST + 1));
			r.insert(0, c);
			n = n / (LAST - FIRST + 1);
		}
		return r;
	}

	private int length;
	public static final char FIRST = 'a';
	public static final char LAST = 'z';
}
