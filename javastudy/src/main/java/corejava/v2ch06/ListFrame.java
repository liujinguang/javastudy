package v2ch06;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListFrame extends JFrame {
	public ListFrame() {
		setTitle("ListTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		String[] words = {"quick", "brown", "hungry", "wild", "silent", "huge", "private",
				"abstract", "static", "final"};
		
		wordlist = new JList<String>(words);
		wordlist.setVisibleRowCount(4);
		JScrollPane scrollPane = new JScrollPane(wordlist);
		listPanel = new JPanel();
		listPanel.add(scrollPane);
		wordlist.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				Object[] values = wordlist.getSelectedValues();
				StringBuilder text = new StringBuilder(prefix);
				for (int i = 0; i < values.length; i++) {
					String word = (String) values[i];
					text.append(word);
					text.append(" ");
				}
				text.append(suffix);
				
				label.setText(text.toString());
			}
		});
		
		buttonPanel = new JPanel();
		buttonGroup = new ButtonGroup();
		makeButton("Vertical", JList.VERTICAL);
		makeButton("Vertical Wrap", JList.VERTICAL_WRAP);
		makeButton("Horizontal", JList.HORIZONTAL_WRAP);
		
		add(listPanel, BorderLayout.NORTH);
		label = new JLabel(prefix +  suffix);
		add(label, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private void makeButton(String label, final int orientation) {
		JRadioButton button = new JRadioButton(label);
		buttonPanel.add(button);
		if (buttonGroup.getButtonCount() == 0) {
			button.setSelected(true);
		}
		buttonGroup.add(button);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				wordlist.setLayoutOrientation(orientation);
				listPanel.revalidate();
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new ListFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

	private JList<String> wordlist;
	private JPanel listPanel;
	private JLabel label;
	private JPanel buttonPanel;
	private ButtonGroup buttonGroup;

	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
	private String prefix = "The ";
	private String suffix = "fox jumps over the lazy dog";
}
