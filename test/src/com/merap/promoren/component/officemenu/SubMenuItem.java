package com.merap.promoren.component.officemenu;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar.Command;

/**
 * Sub menu item, available from drop-down menu of {@link MenuItem}.
 * <p>
 * Has an Icon, a description, and an {@link Command}
 * 
 * @author Thomas
 */
public class SubMenuItem extends CustomComponent {

	private static final long serialVersionUID = -5896160617014269235L;

	protected MenuCommand command;

	protected final Button realComponent = new Button();

	public SubMenuItem(String caption, Resource icon, MenuCommand command,
			final MenuItem parent) {

		super();

		removeStyleName("submenuitem");

		setCompositionRoot(realComponent);

		this.command = command;

		setSizeUndefined();
		addStyleName("menuitem");

		realComponent.setCaption(caption);
		realComponent.setIcon(icon);

		realComponent.addClickListener(new ClickListener() {

			private static final long serialVersionUID = -615975673819020510L;

			@Override
			public void buttonClick(ClickEvent event) {
				if (SubMenuItem.this.command != null) {
					SubMenuItem.this.command.menuItemClicked(SubMenuItem.this);
				}
				if (parent != null) {
					parent.closePopup();
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