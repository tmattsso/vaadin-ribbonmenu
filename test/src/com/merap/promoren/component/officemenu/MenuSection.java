package com.merap.promoren.component.officemenu;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Resource;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;

/**
 * A menu section is a collection of {@link MenuItem}s. All items are part of a
 * section, even if they are added directly to the menu (the menu creates a
 * default section for them).
 * <p>
 * A section has a description String
 * 
 * @author Thomas
 */
public class MenuSection extends CustomComponent {

	private static final long serialVersionUID = 5917473030371445997L;

	private final List<MenuItem> items = new ArrayList<MenuItem>();

	private final CssLayout content = new CssLayout();

	public MenuSection(String descString) {

		setCompositionRoot(content);

		setCaption(descString);

		// component expands with additional buttons
		content.setWidth(null);
		addStyleName("menusection");
	}

	public MenuItem addItem(String caption, Resource icon) {
		MenuItem item = new MenuItem(caption, icon, null);
		addItem(item);
		return item;
	}

	public void addItem(MenuItem item) {
		items.add(item);
		content.addComponent(item);
		item.addStyleName("multirow");
	}
}