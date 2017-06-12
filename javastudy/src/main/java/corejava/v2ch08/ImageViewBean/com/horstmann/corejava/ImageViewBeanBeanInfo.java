package corejava.v2ch08.ImageViewBean.com.horstmann.corejava;

import java.awt.Image;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class ImageViewBeanBeanInfo extends SimpleBeanInfo {
	public ImageViewBeanBeanInfo() {
		try {
			propertyDescriptors = new PropertyDescriptor[] { new PropertyDescriptor("fileName", ImageViewBean.class) };
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}

		iconColor16 = loadImage("ImageViewBean_COLOR_16x16.gif");
		iconColor32 = loadImage("ImageViewBean_COLOR_32x32.gif");
		iconMono16 = loadImage("ImageViewBean_MONO_16x16.gif");
		iconMono32 = loadImage("ImageViewBean_MONO_32x32.gif");
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

	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {
		return propertyDescriptors;
	}

	private PropertyDescriptor[] propertyDescriptors;
	private Image iconColor16;
	private Image iconColor32;
	private Image iconMono16;
	private Image iconMono32;

}
