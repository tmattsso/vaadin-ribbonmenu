package com.merap.promoren.component.officemenu;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.MenuBar.Command;

/**
 * Single Menu Item. Always resides inside a {@link MenuSection}.
 * <p>
 * Has an Icon, a description, and an {@link Command}
 * 
 * @author Thomas
 */
public class MenuItem extends SubMenuItem {

	private static final String STYLE_SUBITEMS = "hassubitems";

	private static final long serialVersionUID = 1093584532903074019L;

	private final List<SubMenuItem> subItems = new ArrayList<SubMenuItem>();

	public MenuItem(String caption, Resource icon, MenuCommand command) {
		super(caption, icon, command);
		addStyleName("menuitem");
		removeStyleName("submenuitem");

		realComponent.addClickListener(new ClickListener() {

			private static final long serialVersionUID = -615975673819020510L;

			@Override
			public void buttonClick(ClickEvent event) {
				if (!subItems.isEmpty()) {
					// open popup

				}
			}
		});
	}

	public SubMenuItem addSubItem(String caption, Resource icon,
			MenuCommand command) {
		SubMenuItem item = new SubMenuItem(caption, icon, command);
		subItems.add(item);

		addStyleName(STYLE_SUBITEMS);

		return item;
	}

	public void removeSubItem(SubMenuItem item) {
		subItems.remove(item);
		if (subItems.isEmpty()) {
			removeStyleName(STYLE_SUBITEMS);
		}
	}

}