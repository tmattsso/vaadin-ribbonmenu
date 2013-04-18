package com.merap.promoren.component.vectorflower.client.vectorflowersizelistenerextension;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.merap.promoren.component.vectorflower.VectorFlowerSizeListenerExtension;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.LayoutManager;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.Connect;

@Connect(VectorFlowerSizeListenerExtension.class)
public class VectorFlowerSizeListenerExtensionConnector extends
		AbstractExtensionConnector {

	private static final long serialVersionUID = 5152424589335640674L;

	public VectorFlowerSizeListenerExtensionConnector() {

	}

	@Override
	protected void extend(ServerConnector target) {
		final Widget theJSWidget = ((ComponentConnector) target).getWidget();
		LayoutManager.get(getConnection()).addElementResizeListener(
				theJSWidget.getElement(), new ElementResizeListener() {

					@Override
					public void onElementResize(ElementResizeEvent e) {
						updateSize(theJSWidget.getElement());

					}
				});
	}

	public static native void updateSize(Element element)
	/*-{
	    element.sizeUpdated();
	}-*/;

}
