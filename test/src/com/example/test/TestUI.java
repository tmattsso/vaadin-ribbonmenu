package com.example.test;

import com.merap.promoren.component.officemenu.GridMenuSection;
import com.merap.promoren.component.officemenu.MenuCommand;
import com.merap.promoren.component.officemenu.MenuItem;
import com.merap.promoren.component.officemenu.MenuSection;
import com.merap.promoren.component.officemenu.MenuTab;
import com.merap.promoren.component.officemenu.OfficeMenu;
import com.merap.promoren.component.tabsheet.InvertedTabSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
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

		Panel wrapper = new Panel("Wrapper panel");
		wrapper.setHeight("300px");
		wrapper.setWidth("300px");

		InvertedTabSheet tabs = new InvertedTabSheet();
		tabs.setSizeFull();

		tabs.addTab("Back-Office - Application setup", new Label("Content 1"))
				.setIcon(new ThemeResource("images/1366989665_databases.png"));
		tabs.addTab("Workflow Tasks, Documents and Data",
				new Label("Content 2")).setIcon(
				new ThemeResource("images/1366989848_wheel.png"));
		tabs.addTab("Books and Documents Database", new Label("Content 3"))
				.setIcon(new ThemeResource("images/1366990765_books.png"));
		tabs.addTab("Accounting", new Label("Content 4")).setIcon(
				new ThemeResource("images/1366993680_calculator.png"));
		tabs.addTab("Dashboard", new Label("Content 5")).setIcon(
				new ThemeResource("images/1366993830_bar_chart.png"));

		wrapper.setContent(tabs);
		layout.addComponent(wrapper);

		layout.setHeight("100%");
		layout.setSpacing(true);
	}

	private void createTaskMenu(OfficeMenu menu, MenuCommand dummyCommand) {
		/* TASK */
		MenuTab tab = menu.addTab("Task");

		MenuSection section = tab.addSection("New");
		MenuItem item = section
				.addItem("New from Favourites", new ThemeResource(
						"images/1366661309_kde-address-book-new.png"));
		item.addSubItem("Favourite 1", new ThemeResource("images/add.png"),
				dummyCommand);

		GridMenuSection grid = tab.addGridSection("Wizard", 1, 2);
		grid.addItem("View", new ThemeResource("images/1366661776_wand.png"),
				0, 0);
		grid.addItem("Edit",
				new ThemeResource("images/1366661701_wand-hat.png"), 0, 1);

		section = tab.addSection("Notes");
		section.addItem("View / edit", new ThemeResource(
				"images/1366661482_Note_Pinned.png"));

		section = tab.addSection("Barcodes");
		section.addItem("Manage", new ThemeResource(
				"images/1366802180_barcode.png"));

		grid = tab.addGridSection("Calendar", 2, 2);
		item = grid.addItem("Go To...", new ThemeResource(
				"images/1366742095_calendar-today.png"), 0, 0);
		item.addSubItem("Go to 1", new ThemeResource("images/add.png"),
				dummyCommand);
		grid.addItem("View Month", new ThemeResource(
				"images/1366742668_month.png"), 0, 1);
		grid.addItem("New Event", new ThemeResource(
				"images/1366742375_1day.png"), 1, 0, 1, 1);

		grid = tab.addGridSection("Manage tasks", 1, 2);
		grid.addItem("Unfollow", new ThemeResource(
				"images/1366744368_push_pin.png"), 0, 0);
		grid.addItem("Archive", new ThemeResource(
				"images/1366743395_box-label.png"), 0, 1);

		grid = tab.addGridSection("Workflow", 3, 2);
		grid.addItem("Local History", new ThemeResource(
				"images/1366804833_gear_yellow.png"), 0, 0);
		grid.addItem("Global History", new ThemeResource(
				"images/1366660878_kservices.png"), 0, 1);
		item = grid.addItem("Forward to..", new ThemeResource(
				"images/1366744114_cards_bind_address.png"), 1, 0, 1, 1);
		item.addSubItem("User 1", new ThemeResource(
				"images/1366744114_cards_bind_address.png"), dummyCommand);
		grid.addItem("Auto Forward", new ThemeResource(
				"images/1366743868_mail-forward.png"), 2, 0, 2, 1);

	}

	private void createDocsMenu(OfficeMenu menu, MenuCommand dummyCommand) {
		/* DOCS */
		MenuTab tab = menu.addTab("Documents and Data");

		MenuSection section = tab.addSection("Attach");
		section.addItem("Image", new ThemeResource(
				"images/1366738442_scanner.png"));
		section.addItem("Fingerprint", new ThemeResource(
				"images/1366735711_fingerprint.png"));
		section.addItem("Face", new ThemeResource(
				"images/1366736214_PatientData.png"));
		section.addItem("File", new ThemeResource(
				"images/1366736393_usbpendrive_mount.png"));

		section = tab.addSection("PDF");
		MenuItem item = section.addItem("From Template", new ThemeResource(
				"images/1366736521_word.png"));
		item.addSubItem("subItem1", null, dummyCommand);
		item.addSubItem("subItem2", null, dummyCommand);

		section.addItem("From Data", new ThemeResource(
				"images/1366736655_application_form.png"));
		section.addItem("Sign", new ThemeResource(
				"images/1366736761_digital_signature_pen.png"));

		GridMenuSection grid = tab.addGridSection("Full Validation", 1, 2);
		grid.addItem("Local", new ThemeResource(
				"images/1366738334_agt_action_success.png"), 0, 0);
		grid.addItem("Central", new ThemeResource(
				"images/1366738278_mail-mark-not-junk.png"), 0, 1);

		section = tab.addSection("Manage");
		section.addItem("Folder Structure", new ThemeResource(
				"images/1366737801_node-tree.png"));

		section = tab.addSection("Navigate");
		section.addItem("Previous", new ThemeResource(
				"images/1366647745_previous.png"));
		section.addItem("Next", new ThemeResource("images/1366647784_next.png"));
	}

	private void createUtilMenu(OfficeMenu menu, MenuCommand dummyCommand) {
		MenuTab tab = menu.addTab("Utilities");

		MenuSection section = tab.addSection("Services And Data");
		MenuItem item = section.addItem("Service Status", new ThemeResource(
				"images/1366802837_help.png"));
		item.addSubItem("subItem1", null, dummyCommand);
		item.addSubItem("subItem2", null, dummyCommand);
		item = section.addItem("Export / Import", new ThemeResource(
				"images/1366805352_stock_export.png"));
		item.addSubItem("subItem1", null, dummyCommand);
		item.addSubItem("subItem2", null, dummyCommand);

	}

	private void createAdminMenu(OfficeMenu menu, MenuCommand dummyCommand) {
		MenuTab tab = menu.addTab("Admin");

		MenuSection section = tab.addSection("User Information");
		section.addItem("Change Password", new ThemeResource(
				"images/1366802965_gnome-keyring-manager.png"));
		section.addItem("Chat Profile", new ThemeResource(
				"images/1366803074_edu_languages.png"));

		section = tab.addSection("User Working / Absent");
		section.addItem("Change Status", new ThemeResource(
				"images/1366803797_preferences_alt_off.png"));
		section.addItem("Trusted Users", new ThemeResource(
				"images/1366803892_emblem-handshake.png"));

		GridMenuSection grid = tab.addGridSection("Personal Calendar", 2, 2);
		MenuItem item = grid.addItem("Go To ...", new ThemeResource(
				"images/1366742095_calendar-today.png"), 0, 0);
		item.addSubItem("Subitem 1", null, dummyCommand);
		grid.addItem("View Month", new ThemeResource(
				"images/1366742668_month.png"), 0, 1);
		grid.addItem("New Event", new ThemeResource(
				"images/1366742375_1day.png"), 1, 0, 1, 1);
	}

}
