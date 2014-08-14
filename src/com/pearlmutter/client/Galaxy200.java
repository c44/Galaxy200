package com.pearlmutter.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.pearlmutter.shared.Cell;
import com.pearlmutter.shared.User;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Galaxy200 implements EntryPoint {

	public final DBServiceAsync dbService = GWT.create(DBService.class);

	private DataLoader dl;
	VerticalPanel main = new VerticalPanel();
	UI ui;
	public ArrayList<User> users;
	public ArrayList<Cell> cells;
	public Galaxy200 app = this;


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		dl = new DataLoader(this);
		ui = new UI(this);
//		String width = String.valueOf(Window.getClientWidth()) + "px";
//		main.setWidth(width);
		RootPanel.get("content").add(main);

	}

	public UI getUi() {
		return ui;
	}

	public DataLoader getDl() {
		return dl;
	}

}
