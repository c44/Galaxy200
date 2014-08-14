package com.pearlmutter.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;
import com.pearlmutter.shared.User;

public class CellTableTest implements EntryPoint {

	private static ArrayList<User> Contacts = new ArrayList<>();

	@Override
	public void onModuleLoad() {
		Contacts.add(0, new User("joe", "Blow", "1"));
		Contacts.add(1, new User("jseph", "Blowseph", "2"));
		Contacts.add(2, new User("john", "Doe", "3"));

		CellTable<User> table = new CellTable<User>();
		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		TextColumn<User> firstNameColumn = new TextColumn<User>() {

			@Override
			public String getValue(User object) {
				return object.getFirstName();
			}
		};
		table.addColumn(firstNameColumn, "First Name");

//		DateCell dateCell = new DateCell();
//		Column<Contact, Date> dateColumn = new Column<Contact, Date>(dateCell) {
//			@Override
//			public Date getValue(Contact object) {
//				return object.birthday;
//			}
//		};
//		table.addColumn(dateColumn, "Birthday");
		
		TextColumn<User> lastNameColumn = new TextColumn<User>() {

			@Override
			public String getValue(User object) {
				return object.getLastName();
			}
		};
		table.addColumn(lastNameColumn, "Last Name");
		
		TextColumn<User> idColumn = new TextColumn<User>() {

			@Override
			public String getValue(User object) {
				return object.getId();
			}
		};
		table.addColumn(idColumn, "ID");
		
		final SingleSelectionModel<User> selectionModel = new SingleSelectionModel<User>();
		table.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				User selected = selectionModel.getSelectedObject();
				if (selected != null) {
//					Window.alert("You Selected: " + selected.getFirstName());
				}
			}
		});
		
		table.setRowCount(Contacts.size(), true);
		table.setRowData(0, Contacts);
		
		
		VerticalPanel panel = new VerticalPanel();
		panel.setBorderWidth(1);
		
		panel.add(table);
		
		RootPanel.get("content").add(panel);
		
		
		

		RootPanel.get("content").add(new Label("Another Entry Point?"));
	}

}
