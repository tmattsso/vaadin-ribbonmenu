package com.merap.promoren.component.officemenu;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.themes.BaseTheme;

/**
 * Single Menu Item. Always resides inside a {@link MenuSection}.
 * <p>
 * Has an Icon, a description, and an {@link Command}
 * 
 * @author Thomas
 */
public class MenuItem extends Button {

	private static final long serialVersionUID = 1093584532903074019L;

	private Command command;

	MenuItem(String caption, Resource icon, Command command) {
		super();

		this.command = command;

		setHeight("100%");
		setWidth("70px");

		addStyleName(BaseTheme.BUTTON_LINK);
		addStyleName("menuitem");

		setCaption(caption);
		setIcon(icon);

		addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO fire event
			}
		});
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

}