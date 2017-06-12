package v2ch08.ChartBean.com.horstmann.corejava;

import java.awt.Image;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * The bean info for the chart bean, specifying the property editors
 * @author bob
 *
 */
public class ChartBeanBeanInfo extends SimpleBeanInfo {

	public ChartBeanBeanInfo() {
		iconColor16 = loadImage("ChartBean_COLOR_16x16.gif");
		iconColor32 = loadImage("ChartBean_COLOR_32x32.gif");
		iconMono16 = loadImage("ChartBean_MONO_16x16.gif");
		iconMono32 = loadImage("ChartBean_MONO_32x32.gif");

		try {
			PropertyDescriptor titlePositionDescriptor = new PropertyDescriptor("titlePosition", ChartBean.class);
			titlePositionDescriptor.setPropertyEditorClass(TitlePositionEditor.class);

			PropertyDescriptor inverseDescriptor = new PropertyDescriptor("inverse", ChartBean.class);
			inverseDescriptor.setPropertyEditorClass(InverseEditor.class);

			PropertyDescriptor valuesDescriptor = new PropertyDescriptor("values", ChartBean.class);
			valuesDescriptor.setPropertyEditorClass(DoubleArrayEditor.class);

			propertyDescriptors = new PropertyDescriptor[] { new PropertyDescriptor("title", ChartBean.class),
					titlePositionDescriptor, valuesDescriptor, new PropertyDescriptor("graphColor", ChartBean.class),
					inverseDescriptor };
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {
		return propertyDescriptors;
	}

	@Override
	public Image getIcon(int iconKind) {
		if (iconKind == BeanInfo.ICON_COLOR_16x16) {
			return iconColor16;
		} else if (iconKind == BeanInfo.ICON_COLOR_32x32) {
			return iconColor32;
		} else if (iconKind == BeanInfo.ICON_MONO_16x16) {
			return iconMono16;
		} else if (iconKind == BeanInfo.ICON_MONO_32x32) {
			return iconMono32;
		} else {
			return null;
		}
	}

	private PropertyDescriptor[] propertyDescriptors;
	private Image iconMono16;
	private Image iconMono32;
	private Image iconColor16;
	private Image iconColor32;
}
