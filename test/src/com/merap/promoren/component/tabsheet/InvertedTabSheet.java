package com.merap.promoren.component.tabsheet;

import java.util.ArrayList;
import java.util.List;

import com.github.wolfie.popupextension.PopupExtension;
import com.github.wolfie.popupextension.PopupExtension.PopupExtensionManualBundle;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

public class InvertedTabSheet extends CustomComponent {

	private static final long serialVersionUID = -4569440439373757625L;

	private final List<Tab> tabs = new ArrayList<Tab>();
	private Tab selected;

	private final VerticalLayout content = new VerticalLayout();
	private final CssLayout buttons;
	private final Panel tabcontent;

	private PopupExtensionManualBundle bundle;

	private boolean massUpdate = false;

	public InvertedTabSheet() {

		setCompositionRoot(content);
		addStyleName("invertedtabsheet");

		tabcontent = new Panel();
		tabcontent.setSizeFull();
		tabcontent.addStyleName(ChameleonTheme.PANEL_BORDERLESS);

		buttons = new CssLayout();
		buttons.addStyleName("tabcaptions");
		buttons.setWidth("100%");

		content.setSizeFull();
		content.addComponent(tabcontent);
		content.setExpandRatio(tabcontent, 1);
		content.addComponent(buttons);

	}

	public Tab addTab(String caption, Component content) {
		Tab tab = new Tab(true, caption, null, null, content, null);
		tabs.add(tab);
		if (tabs.size() == 1) {
			selected = tab;
		}
		refresh();
		return tab;
	}

	private void refresh() {

		if (massUpdate) {
			return;
		}
		massUpdate = true;

		buttons.removeAllComponents();

		// iterate backwards; float-right will fix order

		final Button open = new Button();
		open.addStyleName("open");
		open.setIcon(new ThemeResource("images/arrow-down.png"));

		open.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 4741866556715191692L;

			@Override
			public void buttonClick(ClickEvent event) {

				if (bundle != null) {
					bundle.getPopupExtension().remove();
					buttons.removeComponent(bundle.getDataTransferComponent());
				}

				bundle = PopupExtension.extendWithManualBundle(open);
				buttons.addComponent(bundle.getDataTransferComponent());
				final PopupExtension ext = bundle.getPopupExtension();

				ext.setPopupStyleName("tabsheet");
				ext.setAnchor(Alignment.TOP_RIGHT);
				ext.setDirection(Alignment.TOP_RIGHT);
				ext.closeOnOutsideMouseClick(true);

				CssLayout menuContent = new CssLayout();
				menuContent.setSizeUndefined();
				menuContent.setHeight("121px");
				menuContent.addStyleName("tabsheetpopup");

				for (Tab t : tabs) {
					Button b = new Button(t.getCaption());
					b.addStyleName("tabcaption");
					b.setDescription(t.getDescription());
					b.setIcon(t.getIcon());
					b.addClickListener(tabChangeListener);
					b.setData(t);
					menuContent.addComponent(b);
				}

				ext.setContent(menuContent);
				ext.open();
			}
		});
		buttons.addComponent(open);

		for (int i = tabs.size() - 1; i > -1; i--) {
			Tab tab = tabs.get(i);
			Button b = new Button(tab.getCaption(), tabChangeListener);
			b.addStyleName("tabcaption");
			b.setIcon(tab.getIcon());
			b.setDescription(tab.getDescription());
			tab.setButton(b);
			b.setData(tab);
			buttons.addComponent(b);
		}

		if (selected != null) {
			selected.getButton().addStyleName("selected");
			tabcontent.setContent(selected.getComponent());
		}
		massUpdate = false;
	}

	private final ClickListener tabChangeListener = new ClickListener() {

		private static final long serialVersionUID = 4617461083732078861L;

		@Override
		public void buttonClick(ClickEvent event) {
			// removePopupComponents();
			selected = (Tab) event.getButton().getData();
			refresh();
		}
	};

	public class Tab {

		public Tab(boolean enabled, String caption, Resource icon,
				String description, Component component, String stylename) {
			super();
			this.enabled = enabled;
			this.caption = caption;
			this.icon = icon;
			this.description = description;
			this.component = component;
			this.stylename = stylename;
		}

		private boolean enabled;
		private String caption;
		private Resource icon;
		private String description;
		private Component component;
		private String stylename;
		private Button button;

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
			refresh();
		}

		public String getCaption() {
			return caption;
		}

		public void setCaption(String caption) {
			this.caption = caption;
			refresh();
		}

		public Resource getIcon() {
			return icon;
		}

		public void setIcon(Resource icon) {
			this.icon = icon;
			refresh();
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
			refresh();
		}

		public Component getComponent() {
			return component;
		}

		public void setComponent(Component component) {
			this.component = component;
			refresh();
		}

		public String getStylename() {
			return stylename;
		}

		public void setStylename(String stylename) {
			this.stylename = stylename;
			refresh();
		}

		public Button getButton() {
			return button;
		}

		public void setButton(Button button) {
			this.button = button;
			refresh();
		}

	}
}
