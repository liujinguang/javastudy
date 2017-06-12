package v2ch08.ChartBean.com.horstmann.corejava;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyEditorSupport;

import javax.swing.ImageIcon;

/**
 * The property editor for the inverse property of the ChartBean. The inverse property toggles
 * between colored graph bars and colored background
 * @author bob
 *
 */
public class InverseEditor extends PropertyEditorSupport {
	@Override
	public Component getCustomEditor() {
		return new InverseEditorPanel(this);
	}

	@Override
	public boolean supportsCustomEditor() {
		return true;
	}

	@Override
	public boolean isPaintable() {
		return true;
	}

	@Override
	public String getAsText() {
		return null;
	}

	@Override
	public String getJavaInitializationString() {
		return "" + getValue();
	}

	@Override
	public void paintValue(Graphics gfx, Rectangle box) {
		ImageIcon icon = (Boolean) getValue() ? inverseIcon : normalIcon;
		int x = box.x + (box.width - icon.getIconWidth()) / 2;
		int y = box.y + (box.height - icon.getIconHeight()) / 2;
		
		gfx.drawImage(icon.getImage(), x, y, null);
	}

	private ImageIcon inverseIcon = new ImageIcon(getClass().getResource("CharBean_INVERSE_16x16"));
	private ImageIcon normalIcon = new ImageIcon(getClass().getResource("CharBean_MONO_16x16.gif"));

}
