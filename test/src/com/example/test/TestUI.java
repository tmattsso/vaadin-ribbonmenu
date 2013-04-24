package com.example.test;

import com.merap.promoren.component.officemenu.GridMenuSection;
import com.merap.promoren.component.officemenu.MenuCommand;
import com.merap.promoren.component.officemenu.MenuItem;
import com.merap.promoren.component.officemenu.MenuSection;
import com.merap.promoren.component.officemenu.MenuTab;
import com.merap.promoren.component.officemenu.OfficeMenu;
import com.merap.promoren.component.officemenu.SubMenuItem;
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

		MenuCommand dummyCommand = new MenuCommand() {

			@Override
			public void menuItemClicked(SubMenuItem item) {
				Notification.show("HELLO!");
			}
		};

		menu.addEmptySection("File", new ThemeResource("images/add.png"),
				new MenuCommand() {

					@Override
					public void menuItemClicked(SubMenuItem item) {
						Notification.show("File menu clicked!");
					}
				});

		/* TASK */
		MenuTab tab = menu.addTab("Task");

		MenuSection section = tab.addSection("New");
		MenuItem item = section.addItem("New from Favourites",
				new ThemeResource("images/add.png"));
		item.addSubItem("Favourite 1", new ThemeResource("images/add.png"),
				dummyCommand);

		GridMenuSection grid = tab.addGridSection("Wizard", 1, 2);
		grid.addItem("View", new ThemeResource("images/add.png"), 0, 0);
		grid.addItem("Edit", new ThemeResource("images/add.png"), 0, 1);

		section = tab.addSection("Notes");
		section.addItem("View / edit", new ThemeResource("images/add.png"));

		section = tab.addSection("Barcodes");
		section.addItem("Manage", new ThemeResource("images/add.png"));

		grid = tab.addGridSection("Calendar", 2, 2);
		item = grid.addItem("Go To...", new ThemeResource("images/add.png"), 0,
				0);
		item.addSubItem("Go to 1", new ThemeResource("images/add.png"),
				dummyCommand);
		grid.addItem("View Month", new ThemeResource("images/add.png"), 0, 1);
		grid.addItem("New Event", new ThemeResource("images/add.png"), 1, 0, 1,
				1);

		grid = tab.addGridSection("Manage tasks", 1, 2);
		grid.addItem("Unfollow", new ThemeResource("images/add.png"), 0, 0);
		grid.addItem("Archive", new ThemeResource("images/add.png"), 0, 1);

		grid = tab.addGridSection("Workflow", 3, 2);
		grid.addItem("Local History", new ThemeResource("images/add.png"), 0, 0);
		grid.addItem("Global History", new ThemeResource("images/add.png"), 0,
				1);
		item = grid.addItem("Forward to..",
				new ThemeResource("images/add.png"), 1, 0, 1, 1);
		item.addSubItem("User 1", new ThemeResource("images/add.png"),
				dummyCommand);
		grid.addItem("Auto Forward", new ThemeResource("images/add.png"), 2, 0,
				2, 1);

		/* DOCS */
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
