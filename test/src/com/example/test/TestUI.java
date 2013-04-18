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

		MenuTab tab = menu.addTab("File");

		MenuSection section = tab.addSection("create");
		section.addItem("Create", new ThemeResource("images/add.png"));
		section.addItem("Create longer", new ThemeResource("images/add.png"));
		section.addItem("Create a really long thing", new ThemeResource(
				"images/add.png"));

		section = tab.addSection("save");
		section.addItem("Save", new ThemeResource("images/add.png"));
		section.addItem("Save As", new ThemeResource("images/add.png"));
		section.addItem("Save Copy As", new ThemeResource("images/add.png"));

		tab = menu.addTab("Edit");

		section = tab.addSection("clipboard");
		section.addItem("Cut", new ThemeResource("images/add.png"));
		section.addItem("Copy", new ThemeResource("images/add.png"));
		section.addItem("Paste", new ThemeResource("images/add.png"));

		layout.addComponent(menu);
	}

}