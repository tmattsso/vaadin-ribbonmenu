package com.merap.promoren.component.officemenu;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Resource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;

/**
 * A menu section is a collection of {@link MenuItem}s. All items are part of a
 * section, even if they are added directly to the menu (the menu creates a
 * default section for them).
 * <p>
 * A section has a description String
 * 
 * @author Thomas
 */
public class GridMenuSection extends CustomComponent {

	private static final long serialVersionUID = 5917473030371445997L;

	private final List<MenuItem> items = new ArrayList<MenuItem>();

	private final GridLayout content;

	public GridMenuSection(String descString, int columns, int rows) {
		content = new GridLayout(columns, rows);
		setCompositionRoot(content);

		setCaption(descString);

		content.setWidth(null);
		addStyleName("menusection");
		addStyleName("grid");
	}

	public MenuItem addItem(String caption, Resource icon, int col, int row) {
		MenuItem item = new MenuItem(caption, icon, null);
		addItem(item, col, row);
		return item;
	}

	public void addItem(MenuItem item, int col, int row) {
		items.add(item);
		content.addComponent(item, col, row);
	}

	public MenuItem addItem(String caption, Resource icon, int colStart,
			int rowStart, int colEnd, int rowEnd) {
		MenuItem item = new MenuItem(caption, icon, null);
		addItem(item, colStart, rowStart, colEnd, rowEnd);
		return item;
	}

	public void addItem(MenuItem item, int colStart, int rowStart, int colEnd,
			int rowEnd) {
		items.add(item);
		content.addComponent(item, colStart, rowStart, colEnd, rowEnd);
	}
}