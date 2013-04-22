package com.merap.promoren.component.officemenu;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.themes.ChameleonTheme;

public class OfficeMenu extends CssLayout {

	private static final long serialVersionUID = -3411790058279262819L;

	static final String HEIGHT_CLOSED = "20px";
	static final String HEIGHT_SECTIONS = "100px";
	static final String HEIGHT_OPEN = "120px";

	private final Resource ARROW_UP = new ThemeResource("images/arrow-up.png");
	private final Resource ARROW_DOWN = new ThemeResource(
			"images/arrow-down.png");

	private final HorizontalLayout captions = new HorizontalLayout();
	private final Panel currentTab = new Panel();

	private final Map<String, MenuTab> tabs = new HashMap<String, MenuTab>();
	private final Map<String, Button> tabCaptions = new HashMap<String, Button>();

	private final Button closeButton;
	private boolean open = false;

	public OfficeMenu() {
		super();

		setWidth("100%");
		// setHeight(HEIGHT_CLOSED);
		addStyleName("officemenu");
		captions.addStyleName("tabcaptions");

		// captions.setHeight(HEIGHT_CLOSED);
		captions.setWidth("100%");
		// currentTab.setHeight(HEIGHT_SECTIONS);
		currentTab.setWidth("100%");

		addComponent(captions);
		addComponent(currentTab);

		closeButton = new Button();
		closeButton.addStyleName("headerclose");
		closeButton.addStyleName(ChameleonTheme.BUTTON_BORDERLESS);
		closeButton.addClickListener(closeButtonListener);
		close();

		captions.addComponent(closeButton);
		captions.setExpandRatio(closeButton, 1);
		captions.setComponentAlignment(closeButton, Alignment.MIDDLE_RIGHT);
	}

	protected void showTabs() {
		// TODO Auto-generated method stub
		currentTab.setVisible(true);
	}

	protected void open() {
		// setHeight(HEIGHT_OPEN);
		// currentTab.setHeight(HEIGHT_SECTIONS);
		showTabs();
		open = true;
		closeButton.setIcon(ARROW_DOWN);
	}

	protected void close() {
		// setHeight(HEIGHT_CLOSED);
		// currentTab.setHeight("0px");
		currentTab.setVisible(false);
		open = false;
		closeButton.setIcon(ARROW_UP);
	}

	public MenuSection addSection(String tabCaption, String desc) {

		MenuTab tab = tabs.get(tabCaption);
		if (tab == null) {
			tab = addTab(tabCaption);
		}

		MenuSection section = tab.addSection(desc);

		return section;
	}

	public MenuTab addTab(String tabCaption, Resource icon, boolean select) {
		MenuTab tab = new MenuTab();
		tabs.put(tabCaption, tab);

		Button caption = new Button(tabCaption);
		caption.addStyleName("tabcaption");
		tabCaptions.put(tabCaption, caption);

		captions.addComponent(caption, captions.getComponentCount() - 1);

		caption.addClickListener(tabChangeListener);

		if (select) {
			caption.click();
		}

		return tab;
	}

	public MenuTab addTab(String tabCaption, Resource icon) {
		return addTab(tabCaption, icon, false);
	}

	public MenuTab addTab(String tabCaption) {
		return addTab(tabCaption, null, false);
	}

	private final ClickListener tabChangeListener = new ClickListener() {

		private static final long serialVersionUID = 4397027389196697692L;

		@Override
		public void buttonClick(ClickEvent event) {
			String tabCaption = event.getButton().getCaption();

			currentTab.setContent(tabs.get(tabCaption));

			showTabs();
		}
	};
	private final ClickListener closeButtonListener = new ClickListener() {

		private static final long serialVersionUID = -933901482894951128L;

		@Override
		public void buttonClick(ClickEvent event) {

			if (open) {
				close();
			} else {
				open();
			}
		}
	};

}
