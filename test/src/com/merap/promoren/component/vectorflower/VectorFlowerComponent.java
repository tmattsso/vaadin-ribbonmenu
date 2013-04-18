package com.merap.promoren.component.vectorflower;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.server.Resource;
import com.vaadin.ui.AbstractJavaScriptComponent;

@StyleSheet({ "vectorflower.css" })
@JavaScript({ "jquery-1.7.1.min.js", "jquery.smoothZoom.min.js",
		"vectorflower_connector.js" })
public class VectorFlowerComponent extends AbstractJavaScriptComponent {

	private static final long serialVersionUID = -9013562328433460465L;

	public VectorFlowerComponent() {
		new VectorFlowerSizeListenerExtension().extend(this);
	}

	public void setImage(Resource resource) {
		setResource("vf-img", resource);
	}

	@Override
	protected VectorFlowerComponentState getState() {
		return (VectorFlowerComponentState) super.getState();
	}

}
