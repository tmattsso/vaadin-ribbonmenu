package com.example.test;

import com.merap.promoren.component.officemenu.GridMenuSection;
import com.merap.promoren.component.officemenu.MenuCommand;
import com.merap.promoren.component.officemenu.MenuItem;
import com.merap.promoren.component.officemenu.MenuSection;
import com.merap.promoren.component.officemenu.MenuTab;
import com.merap.promoren.component.officemenu.OfficeMenu;
import com.merap.promoren.component.officemenu.SubMenuItem;
import com.merap.promoren.component.officemenu.ToggleMenuItem;
import com.vaadin.annotations.Theme;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
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

		menu.addEmptySection("File", new ThemeResource("images/add.png"),
				new MenuCommand() {

					@Override
					public void menuItemClicked(SubMenuItem item) {
						Notification.show("File menu clicked!");
					}
				});

		MenuTab tab = menu.addTab("Create");

		MenuSection section = tab.addSection("Create");
		section.addItem(new ToggleMenuItem("Toggle me", new ThemeResource(
				"images/add.png"), null));
		section.addItem("Create longer", new ThemeResource("images/add.png"));
		section.addItem("Create a really long thing", new ThemeResource(
				"images/add.png"));

		section = tab.addSection("Save");
		section.addItem("Save", new ThemeResource("images/add.png"));
		section.addItem("Save As", new ThemeResource("images/add.png"));
		section.addItem("Save Copy As", new ThemeResource("images/add.png"));

		GridMenuSection grid = tab.addGridSection("Wizard", 1, 2);
		grid.addItem("View", new ThemeResource("images/add.png"), 0, 0);
		grid.addItem("Edit", new ThemeResource("images/add.png"), 0, 1);

		grid = tab.addGridSection("Test", 2, 2);
		grid.addItem("View", new ThemeResource("images/add.png"), 0, 0);
		MenuItem item = grid.addItem("Edit",
				new ThemeResource("images/add.png"), 0, 1);

		item.addSubItem("subItem2", new ThemeResource("images/add.png"),
				new MenuCommand() {

					@Override
					public void menuItemClicked(SubMenuItem item) {
						Notification.show("HELLO!");
					}
				});

		grid.addItem("Edit", new ThemeResource("images/add.png"), 1, 0, 1, 1);

		tab = menu.addTab("Edit");

		section = tab.addSection("Clipboard");
		section.addItem("Cut", new ThemeResource("images/add.png"));
		section.addItem("Copy", new ThemeResource("images/add.png"));

		item = section.addItem("Paste", new ThemeResource("images/add.png"));

		item.addSubItem("subItem1", null, new MenuCommand() {

			@Override
			public void menuItemClicked(SubMenuItem item) {
				Notification.show("HELLO!");
			}
		});
		item.addSubItem("subItem2", new ThemeResource("images/add.png"),
				new MenuCommand() {

					@Override
					public void menuItemClicked(SubMenuItem item) {
						Notification.show("HELLO!");
					}
				});

		layout.addComponent(menu);
	}

}
