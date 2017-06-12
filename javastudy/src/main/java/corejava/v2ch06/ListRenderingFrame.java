package v2ch06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListRenderingFrame extends JFrame {

	public ListRenderingFrame() {
		setTitle("ListRenderingTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		Container contentPanel = getContentPane();

		ArrayList<Font> fonts = new ArrayList<Font>();
		fonts.add(new Font("Serif", Font.PLAIN, SIZE));
		fonts.add(new Font("SansSerif", Font.PLAIN, SIZE));
		fonts.add(new Font("Monospaced", Font.PLAIN, SIZE));
		fonts.add(new Font("Dialog", Font.PLAIN, SIZE));
		fonts.add(new Font("DialogInput", Font.PLAIN, SIZE));
		fontList = new JList(fonts.toArray());
		fontList.setVisibleRowCount(4);
		fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fontList.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				Font font = (Font)fontList.getSelectedValue();
				text.setFont(font);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(fontList);
		JPanel panel = new JPanel();
		panel.add(scrollPane);
		contentPanel.add(panel, BorderLayout.SOUTH);
		
		text = new JTextArea("The quick brown fox jumps over the lazy dog");
		text.setFont((Font)fonts.get(0));
		
		
	}

	private JTextArea text;
	private JList fontList;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
	private static final int SIZE = 24;
}


class FontCellRender extends JComponent implements ListCellRenderer{

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private Font font;
	private Color background;
	private Color foreground;
}
