package jfc.ch03.example03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.beans.*;

public class Test extends JFrame {
	JTree tree = new JTree();

	public Test() {
		Container contentPane = getContentPane();
		JScrollPane scrollPane = new JScrollPane(tree);

		contentPane.add(new ControlPanel(), BorderLayout.NORTH);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		tree.addPropertyChangeListener(new PropertyListener());
	}
	class ControlPanel extends JPanel {
		JCheckBox showRoot = new JCheckBox("show root node");

		public ControlPanel() {
			showRoot.setSelected(tree.isRootVisible());

			setLayout(new FlowLayout());
			add(showRoot);

			showRoot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tree.setRootVisible(showRoot.isSelected());	
				}
			});
		}
	}
	class PropertyListener implements PropertyChangeListener {
		public void propertyChange(PropertyChangeEvent e) {
			String name = e.getPropertyName();

			if(name.equals(JTree.ROOT_VISIBLE_PROPERTY)) {
				String msg = "Root Visible Property: " +
							  e.getNewValue().toString();

				JOptionPane.showMessageDialog(
					Test.this, 					// parent comp
					msg,						// message	
					"Property Change", 			// title
					JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	public static void main(String args[]) {
	    MyGJApp.launch(new Test(), 
					"Model Property Changes",300,300,450,300);
	}
}

class MyGJApp extends WindowAdapter {
	static private JPanel statusArea = new JPanel();
	static private JLabel status = new JLabel(" ");
	static private ResourceBundle resources;

	public static void launch(final JFrame f, String title,
							  final int x, final int y, 
							  final int w, int h) {
		launch(f,title,x,y,w,h,null);	
	}
	public static void launch(final JFrame f, String title,
							  final int x, final int y, 
							  final int w, int h,
							  String propertiesFilename) {
		f.setTitle(title);
		f.setBounds(x,y,w,h);
		f.setVisible(true);

		statusArea.setBorder(BorderFactory.createEtchedBorder());
		statusArea.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		statusArea.add(status);
		status.setHorizontalAlignment(JLabel.LEFT);

		f.setDefaultCloseOperation(
							WindowConstants.DISPOSE_ON_CLOSE);

		if(propertiesFilename != null) {
			resources = ResourceBundle.getBundle(
						propertiesFilename, Locale.getDefault());
		}

		f.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	static public JPanel getStatusArea() {
		return statusArea;
	}
	static public void showStatus(String s) {
		status.setText(s);
	}
	static Object getResource(String key) {
		if(resources != null) {
			return resources.getString(key);
		}
		return null;
	}
}
