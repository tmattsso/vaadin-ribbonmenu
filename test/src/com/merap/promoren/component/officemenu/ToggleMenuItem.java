package com.merap.promoren.component.officemenu;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.MenuBar.Command;

/**
 * Single Menu Item. Always resides inside a {@link MenuSection}.
 * <p>
 * Has an Icon, a description, and an {@link Command}
 * 
 * @author Thomas
 */
public class ToggleMenuItem extends MenuItem {

	private static final long serialVersionUID = -8309987218017899262L;

	private static String STYLE_PRESSED = "down";
	private static String STYLE_UNPRESSED = "up";

	private boolean isDown = false;

	ToggleMenuItem(String caption, Resource icon, MenuCommand command,
			ComponentContainer dataTransferDump) {
		super(caption, icon, command, dataTransferDump);

		realComponent.addStyleName(STYLE_UNPRESSED);
		realComponent.addClickListener(new ClickListener() {

			private static final long serialVersionUID = -7075018310285745343L;

			@Override
			public void buttonClick(ClickEvent event) {

				if (isDown) {
					isDown = false;
					realComponent.removeStyleName(STYLE_PRESSED);
					realComponent.addStyleName(STYLE_UNPRESSED);
				} else {
					isDown = true;
					realComponent.removeStyleName(STYLE_UNPRESSED);
					realComponent.addStyleName(STYLE_PRESSED);
				}

			}
		});
	}

	public boolean isPressed() {
		return isDown;
	}
}