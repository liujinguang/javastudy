package jfc.ch03.example04;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicButtonUI;

public class UITest extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new UITest();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(100, 100, 450, 300);
            }
        });
    }

    public UITest() {
        setLayout(new FlowLayout());
        
        JButton button = new JButton(new ImageIcon(UITest.this.getClass()
                .getResource("punch.gif")));
        button.setUI(new PopOutButtonUI());
        
        add(button);
    }
}

class PopOutButtonUI extends BasicButtonUI {
    static protected BasicButtonListener listener;

    @Override
    public void installUI(JComponent c) {
        AbstractButton button = (AbstractButton) c;
        Border border = button.getBorder();
        ImageIcon icon = (ImageIcon) button.getIcon();

        int iconW = icon.getIconWidth();
        int iconH = icon.getIconHeight();

        Image scaled = icon.getImage().getScaledInstance(iconW + (iconW / 3),
                iconH + (iconH / 3), Image.SCALE_SMOOTH);
        c.putClientProperty(" oldBorder", border);
        c.setBorder(null);

        button.setRolloverIcon(new ImageIcon(scaled));

        installListeners(button);
    }

    @Override
    public void uninstallUI(JComponent c) {
        Border border = (Border) c.getClientProperty(" oldBorder");
        c.putClientProperty(" oldBorder", null);
        c.setBorder(border);

        uninstallListeners((AbstractButton) c);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        Dimension ps = super.getPreferredSize(c);

        ps.width += ps.width / 3;
        ps.height += ps.height / 3;

        return ps;
    }

    @Override
    public boolean contains(JComponent c, int x, int y) {
        AbstractButton button = (AbstractButton) c;
        ButtonModel model = button.getModel();
        Icon icon = getIcon(button, model);

        Rectangle iconBounds = new Rectangle(0, 0, icon.getIconWidth(),
                icon.getIconHeight());

        return iconBounds.contains(x, y);
    }

    private Icon getIcon(AbstractButton b, ButtonModel m) {
        return (m.isRollover() && !m.isPressed()) ? b.getRolloverIcon() : b
                .getIcon();
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton button = (AbstractButton) c;
        ButtonModel model = button.getModel();

        Icon icon = getIcon(button, model);
        Insets insets = c.getInsets();

        icon.paintIcon(c, g, insets.left, insets.top);
    }
}
