package v2ch06;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ListFrameWB extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new ListFrameWB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListFrameWB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel listPanel = new JPanel();
		contentPane.add(listPanel, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		listPanel.add(scrollPane);

		wordlist = new JList<String>();

		scrollPane.setViewportView(wordlist);
		wordlist.setVisibleRowCount(4);
		wordlist.setModel(new AbstractListModel() {
			String[] values = new String[] { "quick", "brown", "hungry", "wild", "silent", "huge", "private",
					"abstract", "static", "final" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		wordlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				StringBuilder builder = new StringBuilder(prefix);
				List<String> list = wordlist.getSelectedValuesList();

				for (String str : list) {
					builder.append(str);
					builder.append(" ");
				}
				builder.append(suffix);

				label.setText(builder.toString());
			}
		});

		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		makeButton("Vertical", JList.VERTICAL);
		makeButton("Vertical Wrap", JList.VERTICAL_WRAP);
		makeButton("Horizontal", JList.HORIZONTAL_WRAP);

		label = new JLabel(prefix + suffix);
		contentPane.add(label, BorderLayout.CENTER);
	}

	private void makeButton(String name, final int orientation) {
		JRadioButton button = new JRadioButton(name);
		if (buttonGroup.getButtonCount() == 0) {
			button.setSelected(true);
		}
		buttonGroup.add(button);
		buttonPanel.add(button);

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wordlist.setLayoutOrientation(orientation);
				wordlist.revalidate();
			}
		});
	}

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String prefix = "The ";
	private String suffix = "fox jumps over the lazy dog";
	private JPanel buttonPanel;
	private JList<String> wordlist;
	private JLabel label;
}
