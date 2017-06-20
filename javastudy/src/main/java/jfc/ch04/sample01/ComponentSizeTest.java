package jfc.ch04.sample01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class ComponentSizeTest extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComponentSizeTest frame = new ComponentSizeTest();
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
	public ComponentSizeTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLayout(new FlowLayout());
		final JComboBox<String> sizeCombo = new JComboBox<String>(new String[]{"null", "100x100"});
		final JList<String> lst = new JList<String>(new String[]{"item 1", "item 2", "item 3", "item 4", "item 5"});
		lst.setSelectedIndex(0);
		lst.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		add(lst);
		add(new JLabel("preferred size for list: "));
		add(sizeCombo);
		
		sizeCombo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int index = sizeCombo.getSelectedIndex();
				if (index == 0) {
					lst.setPreferredSize(null);
				} else {
					lst.setPreferredSize(new Dimension(100, 100));
				}
				
				//force the content pane to update
				lst.revalidate();
			}
		});
		
	}

}
