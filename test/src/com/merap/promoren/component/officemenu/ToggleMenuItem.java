package com.merap.promoren.component.officemenu;

import com.vaadin.server.Resource;
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

	public ToggleMenuItem(String caption, Resource icon, MenuCommand command) {
		super(caption, icon, command);

		addStyleName(STYLE_UNPRESSED);

		addClickListener(new ClickListener() {

			private static final long serialVersionUID = -7075018310285745343L;

			@Override
			public void buttonClick(ClickEvent event) {

				if (isDown) {
					isDown = false;
					removeStyleName(STYLE_PRESSED);
					addStyleName(STYLE_UNPRESSED);
				} else {
					isDown = true;
					removeStyleName(STYLE_UNPRESSED);
					addStyleName(STYLE_PRESSED);
				}

			}
		});
	}

	public boolean isPressed() {
		return isDown;
	}
}