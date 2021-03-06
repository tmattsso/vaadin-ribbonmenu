package com.merap.promoren.component.officemenu;

import java.util.ArrayList;
import java.util.List;

import com.github.wolfie.popupextension.PopupExtension;
import com.github.wolfie.popupextension.PopupExtension.PopupExtensionManualBundle;
import com.github.wolfie.popupextension.PopupExtension.PopupVisibilityListener;
import com.vaadin.server.Resource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.MenuBar.Command;

/**
 * Single Menu Item. Always resides inside a {@link MenuSection}.
 * <p>
 * Has an Icon, a description, and an {@link Command}
 * 
 * @author Thomas
 */
public class MenuItem extends SubMenuItem {

	private static final String SPAN = "<span class=\"downarrow\">";

	private static final String STYLE_SUBITEMS = "hassubitems";

	private static final long serialVersionUID = 1093584532903074019L;

	private final List<SubMenuItem> subItems = new ArrayList<SubMenuItem>();

	private PopupExtension popup;
	private CssLayout popupContent;

	MenuItem(String caption, Resource icon, MenuCommand command,
			final ComponentContainer dataTransferDump) {
		super(caption, icon, command, null);

		addStyleName("menuitem");
		removeStyleName("submenuitem");

		realComponent.setHtmlContentAllowed(true);

		realComponent.addClickListener(new ClickListener() {

			private static final long serialVersionUID = -615975673819020510L;

			@Override
			public void buttonClick(final ClickEvent event) {

				if (!subItems.isEmpty()) {
					// open popup
					if (popup != null) {
						popup.remove();
					}

					PopupExtensionManualBundle p = PopupExtension
							.extendWithManualBundle(realComponent);
					popup = p.getPopupExtension();
					dataTransferDump.addComponent(p.getDataTransferComponent());

					popup.addPopupVisibilityListener(new PopupVisibilityListener() {
						@Override
						public void visibilityChanged(boolean isOpened) {
							if (isOpened) {
								realComponent.addStyleName("down");
							} else {
								realComponent.removeStyleName("down");
							}
						}
					});
					popup.setAnchor(Alignment.BOTTOM_LEFT);
					popup.closeOnOutsideMouseClick(true);
					popupContent = new CssLayout();
					popup.setContent(popupContent);

					popupContent.removeAllComponents();
					for (SubMenuItem item : subItems) {
						popupContent.addComponent(item);
					}

					popup.open();
				}
			}
		});
	}

	public SubMenuItem addSubItem(String caption, Resource icon,
			MenuCommand command) {
		SubMenuItem item = new SubMenuItem(caption, icon, command, this);

		if (subItems.isEmpty()) {
			addStyleName(STYLE_SUBITEMS);

			String oldCaption = realComponent.getCaption();
			oldCaption += SPAN;
			realComponent.setCaption(oldCaption);

		}
		subItems.add(item);

		return item;
	}

	public void removeSubItem(SubMenuItem item) {
		subItems.remove(item);
		if (subItems.isEmpty()) {
			removeStyleName(STYLE_SUBITEMS);

			String oldCaption = realComponent.getCaption();
			oldCaption.replaceAll(SPAN, "");
			realComponent.setCaption(oldCaption);
		}
	}

	void closePopup() {
		if (popup != null) {
			popup.close();
		}
	}

}