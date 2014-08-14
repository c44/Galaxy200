package com.pearlmutter.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UI extends Composite {

	private Galaxy200 app;

//	private final int BORDER_WIDTH = 7;
//	private final String WIDTH = String.valueOf(Window.getClientWidth() - (2 * BORDER_WIDTH));
	private VerticalPanel main = new VerticalPanel();
	private SplitLayoutPanel layoutPanel = new SplitLayoutPanel(7);
	SideBar sidebar;
	Content content;

	public UI(Galaxy200 app) {
		this.app = app;
		initWidget(main);
//		init();
	}

	public void init() {
		content = new Content(app);
		sidebar = new SideBar(app);
		
		layoutPanel.setHeight("500px");
		String width = String.valueOf(Window.getClientWidth() - 14) + "px";
		layoutPanel.setWidth(width);
		layoutPanel.getElement().getStyle().setProperty("border", "7px solid white"/*
																					 * #
																					 * e7e7e7
																					 */);

//		layoutPanel.addWest(new Label("Test"), 250);
//		layoutPanel.add(new Label("Teset2"));
		
		layoutPanel.addWest(sidebar, 250);
		layoutPanel.add(content);
		main.add(layoutPanel);
//		main.add(new Label("Does this work?"));
	}

	public Content getContent() {
		return content;
	}
}
