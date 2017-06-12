package v2ch08.ChartBean.com.horstmann.corejava;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;


/**
 * A custom editor for the titlePosition property of the ChartBean. The editor lets the user
 * choose between Left, Center, and Right
 * @author bob
 *
 */
public class TitlePositionEditor extends PropertyEditorSupport {
	
	
	@Override
	public String getJavaInitializationString() {
		return ChartBean.Position.class.getName().replace('$', ',') + "." + getValue();
	}

	@Override
	public String[] getTags() {
		return tags;
	}

	@Override
	public String getAsText() {
		int index = ((ChartBean.Position) getValue()).ordinal();
		return tags[index];
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		int index = Arrays.asList(tags).indexOf(text);
		if (index >= 0)
			setValue(ChartBean.Position.values()[index]);
	}

	private String[] tags = { "Left", "Center", "Right" };
}
