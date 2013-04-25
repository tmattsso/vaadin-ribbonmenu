package com.merap.promoren.component.officemenu;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

public class MenuTab extends HorizontalLayout {

	private static final long serialVersionUID = -5951939617377957981L;

	private final List<CustomComponent> sections = new ArrayList<CustomComponent>();

	private final CssLayout dataTransferDump = new CssLayout();

	public MenuTab() {
		addStyleName("menutab");

		addComponent(dataTransferDump);
	}

	public MenuSection addSection(String desc) {
		MenuSection section = new MenuSection(desc, dataTransferDump);
		add(section);

		return section;
	}

	public GridMenuSection addGridSection(String desc, int cols, int rows) {
		GridMenuSection section = new GridMenuSection(desc, cols, rows,
				dataTransferDump);
		add(section);
		return section;
	}

	private void add(CustomComponent c) {
		sections.add(c);
		addComponent(c, getComponentCount() - 1);

		if (sections.size() == 1) {
			c.addStyleName("first");
		}
	}

}