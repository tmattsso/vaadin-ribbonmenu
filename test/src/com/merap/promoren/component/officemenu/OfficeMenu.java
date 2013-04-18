package com.merap.promoren.component.officemenu;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.themes.BaseTheme;

public class OfficeMenu extends CssLayout {

	private static final long serialVersionUID = -3411790058279262819L;

	static final String HEIGHT_CLOSED = "20px";
	static final String HEIGHT_SECTIONS = "100px";
	static final String HEIGHT_OPEN = "120px";

	private final CssLayout captions = new CssLayout();
	private MenuTab currentTab = new MenuTab();

	private final Map<String, MenuTab> tabs = new HashMap<String, MenuTab>();
	private final Map<String, Button> tabCaptions = new HashMap<String, Button>();

	public OfficeMenu() {
		super();

		setWidth("100%");
		setHeight(HEIGHT_CLOSED);
		addStyleName("officemenu");
		captions.addStyleName("tabcaptions");

		captions.setHeight(HEIGHT_CLOSED);
		captions.setWidth("100%");
		currentTab.setHeight(HEIGHT_SECTIONS);
		currentTab.setWidth("100%");

		addComponent(captions);
		addComponent(currentTab);
	}

	protected void open() {
		setHeight(HEIGHT_OPEN);
		currentTab.setHeight(HEIGHT_SECTIONS);
	}

	protected void close() {
		setHeight(HEIGHT_CLOSED);
		currentTab.setHeight("0px");
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
		caption.addStyleName(BaseTheme.BUTTON_LINK);
		caption.addStyleName("tabcaption");
		tabCaptions.put(tabCaption, caption);
		captions.addComponent(caption);

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

			replaceComponent(currentTab, tabs.get(tabCaption));
			currentTab = tabs.get(tabCaption);

			open();
		}
	};
}
