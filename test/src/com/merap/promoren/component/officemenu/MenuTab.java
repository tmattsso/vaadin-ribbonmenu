package com.merap.promoren.component.officemenu;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

public class MenuTab extends HorizontalLayout {

	private static final long serialVersionUID = -5951939617377957981L;

	private final List<MenuSection> sections = new ArrayList<MenuSection>();

	public MenuTab() {

		// component expands with additional buttons
//		setHeight(OfficeMenu.HEIGHT_SECTIONS);
		addStyleName("menutab");
	}

	public MenuSection addSection(String desc) {
		MenuSection section = new MenuSection(desc);
		sections.add(section);
		addComponent(section);

		return section;
	}

	public MenuSection getSection(String caption) {
		for (MenuSection s : sections) {
			if (caption.equals(s.getCaption())) {
				return s;
			}
		}
		return null;
	}
}