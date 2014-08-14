package com.pearlmutter.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SideBar extends Composite {
	private Galaxy200 app;
	private VerticalPanel menu = new VerticalPanel();
	UsersMenu users;
	CellsMenu cells;
	// private Tree menu = new Tree();
	// private UsersMenu users = new UsersMenu(app);
	// private CellsMenu cells = new CellsMenu(app);
	private ScrollPanel scroller = new ScrollPanel(menu);

	// private StackLayoutPanel menu = new StackLayoutPanel(Unit.PX);

	public SideBar(Galaxy200 app) {
		this.app = app;
		initWidget(scroller);
		init();
	}

	void init() {
//		users = new UsersMenu(app);
//		cells = new CellsMenu(app);
//		menu.add(users);
//		menu.add(cells);
		// menu.setWidth("200px");

		menu.addStyleName("menu");
		// menu.add(users, users.getHeader().getElement().toString(), true, 22);
		// menu.add(cells, cells.getHeader().getElement().toString(), true, 22);
	}

	public VerticalPanel getMenu() {
		return menu;
	}

	public UsersMenu getUsers() {
		return users;
	}

	public CellsMenu getCells() {
		return cells;
	}

}
