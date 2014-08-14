package com.pearlmutter.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.pearlmutter.shared.Cell;
import com.pearlmutter.shared.User;

public class DataLoader {

	public final DBServiceAsync dbService = GWT.create(DBService.class);

	Galaxy200 app;
	private boolean gotUsers = false;
	private boolean gotCells = false;

	public DataLoader(Galaxy200 app) {
		this.app = app;
		init();
	}

	void init(){
		getUsers();
		getCells();
	}
	
	public void getUsers() {
		dbService.getUsers(new AsyncCallback<ArrayList<User>>() {

			@Override
			public void onSuccess(ArrayList<User> result) {
				app.users = result;
				gotUsers = true;
				loadUi();
//				app.getUi().sidebar.users = new UsersMenu(app);
//				app.getUi().sidebar.getMenu().add(app.getUi().sidebar.users);
//				populate();
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("You FAILED at Life (users)");
			}
		});
	}

	public void getCells() {
		dbService.getCells(new AsyncCallback<ArrayList<Cell>>() {

			@Override
			public void onSuccess(ArrayList<Cell> result) {
				app.cells = result;
				gotCells = true;
				loadUi();
//				app.getUi().sidebar.cells = new CellsMenu(app);
//				app.getUi().sidebar.getMenu().add(app.getUi().sidebar.cells);
//				populate();
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("You FAILED at Life (cells)");
			}
		});
	}

	void loadUi() {
		if (gotCells && gotUsers) {
//			app.ui = new UI(app);
			app.getUi().init();
			app.getUi().sidebar.users = new UsersMenu(app);
			app.getUi().sidebar.getMenu().add(app.getUi().sidebar.users);
			app.getUi().sidebar.cells = new CellsMenu(app);
			app.getUi().sidebar.getMenu().add(app.getUi().sidebar.cells);
			app.main.add(app.ui);
		}
	}

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
}
