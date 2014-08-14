package com.pearlmutter.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.pearlmutter.shared.Cell;
import com.pearlmutter.shared.User;

public class backupgalaxy200 {
	public final DBServiceAsync dbService = GWT.create(DBService.class);

//	private HorizontalPanel mainPanel = new HorizontalPanel();
//	private SplitLayoutPanel layoutPanel = new SplitLayoutPanel(7);
//	private SideBar sidebar = new SideBar(this);
//	private Content content = new Content(this);
//	private ContentTable contentTable = new ContentTable(this);
//	private DataLoader dl = new DataLoader(this);
//	private UI ui = new UI(this);
	public ArrayList<User> users;
//	private boolean gotUsers = false;
	public ArrayList<Cell> cells;
//	private boolean gotCells = false;
//	public Galaxy200 app = this;

	private Label testLabel = new Label();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
//		mainPanel.setSpacing(10);
//		mainPanel.add(new SideBar(this));
//		mainPanel.add(content);
//		layoutPanel.setHeight("500px");
//		layoutPanel.getElement().getStyle().setProperty("border", "7px solid white"/*
//																					 * #
//																					 * e7e7e7
//																					 */);

		dbService.getTestText(new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				testLabel.setText(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				testLabel.setText("error");
			}
		});

//		dbService.getUsers(new AsyncCallback<ArrayList<User>>() {
//
//			@Override
//			public void onSuccess(ArrayList<User> result) {
//				users = result;
//				gotUsers = true;
//				populate();
//				sidebar.users = new UsersMenu(app);
//				sidebar.getMenu().add(sidebar.users);
//				contentTable.init();
//			}
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert("You FAILED at Life (users)");
//			}
//		});
//
//		dbService.getCells(new AsyncCallback<ArrayList<Cell>>() {
//
//			@Override
//			public void onSuccess(ArrayList<Cell> result) {
//				cells = result;
//				gotCells = true;
//				populate();
//				sidebar.cells = new CellsMenu(app);
//				sidebar.getMenu().add(sidebar.cells);
//			}
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert("You FAILED at Life (cells)");
//
//			}
//		});

//		layoutPanel.addWest(sidebar, 250);
//		layoutPanel.add(contentTable);
//		layoutPanel.add(content);
//		String devtest = String.valueOf(layoutPanel.getWidgetSize(sidebar));
//		RootPanel.get("content").add(mainPanel);
//		RootPanel.get("content").add(ui);

//		RootPanel.get("content").add(new Content());

//		RootPanel.get("content").add(testLabel);
//		RootPanel.get("content").add(new Label(devtest));
	}

//	public UI getUi() {
//		return ui;
//	}

//	public void populate() {
//		if (gotCells && gotUsers) {
//			for (int i = 0; i < users.size(); i++) {
//				String cell = users.get(i).getCell();
//				for (int j = 0; j < cells.size(); j++) {
//					if (cells.get(j).getName().equals(cell)) {
//						users.get(i).setCell1(cells.get(j));
//						cells.get(j).getUsers().add(users.get(i));
//					}
//				}
//			}
//			FlexTable testTable = new FlexTable();
//			for (int j = 0; j < cells.size(); j++) {
//				testTable.setText(0, j, cells.get(j).getName());
//				for (int i = 0; i < cells.get(j).getUsers().size(); i++) {
//					testTable.setText(i + 1, j, cells.get(j).getUsers().get(i).getFirstName());
//				}
//			}
//			RootPanel.get("content").add(testTable);
//		}
//	}

//	public Content getContent() {
//		return content;
//	}
}
