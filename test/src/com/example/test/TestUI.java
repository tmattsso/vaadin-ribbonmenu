package com.example.test;

import com.merap.promoren.component.officemenu.MenuSection;
import com.merap.promoren.component.officemenu.MenuTab;
import com.merap.promoren.component.officemenu.OfficeMenu;
import com.vaadin.annotations.Theme;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
@Theme("menutheme")
public class TestUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSizeFull();
		setContent(layout);

		OfficeMenu menu = new OfficeMenu();

		MenuTab tab = menu.addTab("HELLOOOO1");

		MenuSection section = tab.addSection("trooloololololo");
		section.addItem("LOOL", new ThemeResource("images/add.png"));
		section.addItem("LOOL", new ThemeResource("images/add.png"));
		section.addItem("LOOL", new ThemeResource("images/add.png"));
		section = tab.addSection("trooloololololo");

		section.addItem("LOOL", new ThemeResource("images/add.png"));
		section.addItem("LOOL", new ThemeResource("images/add.png"));
		section.addItem("LOOL", new ThemeResource("images/add.png"));

		tab = menu.addTab("HELLOOOO2");

		section = tab.addSection("trooloololololo");
		section.addItem("LOOL", new ThemeResource("images/add.png"));
		section.addItem("LOOL", new ThemeResource("images/add.png"));
		section.addItem("LOOL", new ThemeResource("images/add.png"));

		layout.addComponent(menu);
	}

}