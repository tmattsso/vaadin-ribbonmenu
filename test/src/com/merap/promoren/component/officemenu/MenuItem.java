package com.merap.promoren.component.officemenu;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.themes.BaseTheme;

/**
 * Single Menu Item. Always resides inside a {@link MenuSection}.
 * <p>
 * Has an Icon, a description, and an {@link Command}
 * 
 * @author Thomas
 */
public class MenuItem extends CustomComponent {

	private static final long serialVersionUID = 1093584532903074019L;

	private MenuCommand command;

	protected final Button realComponent = new Button();

	public MenuItem(String caption, Resource icon, MenuCommand command) {
		super();

		setCompositionRoot(realComponent);

		this.command = command;

		setHeight("100%");
		setWidth("70px");

		realComponent.setHeight("100%");
		realComponent.setWidth("70px");

		realComponent.addStyleName(BaseTheme.BUTTON_LINK);
		addStyleName("menuitem");

		realComponent.setCaption(caption);
		realComponent.setIcon(icon);

		realComponent.addClickListener(new ClickListener() {

			private static final long serialVersionUID = -615975673819020510L;

			@Override
			public void buttonClick(ClickEvent event) {
				if (MenuItem.this.command != null) {
					MenuItem.this.command.menuItemClicked(MenuItem.this);
				}
			}
		});
	}

	public MenuCommand getCommand() {
		return command;
	}

	public void setCommand(MenuCommand command) {
		this.command = command;
	}

}