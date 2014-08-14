package com.pearlmutter.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.DatePickerCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.pearlmutter.shared.User;

public class ContentTable extends Composite {
	private Galaxy200 app;

	private VerticalPanel main = new VerticalPanel();
	private ScrollPanel scroller = new ScrollPanel(main);

	// private static ArrayList<User> users;

	public ContentTable(Galaxy200 app) {
		this.app = app;
		initWidget(scroller);
		main.add(new Label("Loading..."));
		// init();
	}

	public void init() {

		ArrayList<User> users = app.users;

		CellTable<User> table = new CellTable<User>();
		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		TextColumn<User> idColumn = new TextColumn<User>() {

			@Override
			public String getValue(User object) {
				return object.getId();
			}
		};
		table.addColumn(idColumn, "ID");

		EditTextCell frstNameCell = new EditTextCell();
		Column<User, String> firstNameColumn = new Column<User, String>(frstNameCell) {

			@Override
			public String getValue(User object) {
				return object.getFirstName();
			}
		};
		// TextColumn<User> firstNameColumn = new TextColumn<User>() {
		//
		// @Override
		// public String getValue(User object) {
		// return object.getFirstName();
		// }
		// };
		firstNameColumn.setSortable(true);
		table.addColumn(firstNameColumn, "First Name");

		TextColumn<User> lastNameColumn = new TextColumn<User>() {

			@Override
			public String getValue(User object) {
				return object.getLastName();
			}
		};
		table.addColumn(lastNameColumn, "Last Name");

		DatePickerCell dateCell = new DatePickerCell();
		Column<User, Date> dateColumn = new Column<User, Date>(dateCell) {
			@Override
			public Date getValue(User object) {
				return object.getBirthDay();
			}
		};
		table.addColumn(dateColumn, "Birthday");

		TextColumn<User> cellColumn = new TextColumn<User>() {

			@Override
			public String getValue(User object) {
				return object.getCell();
			}
		};
		table.addColumn(cellColumn, "Cell");

		List<String> opt = new ArrayList<String>();
		opt.add("");
		opt.add("North");
		opt.add("South");
		SelectionCell branchCell = new SelectionCell(opt);
		Column<User, String> branchColumn = new Column<User, String>(branchCell) {

			@Override
			public String getValue(User object) {
				return object.getBranch();
			}
		};

		// TextColumn<User> branchColumn = new TextColumn<User>() {
		//
		// @Override
		// public String getValue(User object) {
		// return object.getBranch();
		// }
		// };
		table.addColumn(branchColumn, "Branch");

		ListHandler<User> sortHandler = new ListHandler<>(users);
		table.addColumnSortHandler(sortHandler);
		sortHandler.setComparator(firstNameColumn, new Comparator<User>() {
			
			@Override
			public int compare(User o1, User o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		});
		

		// final MultiSelectionModel<User> selectionModel = new
		// MultiSelectionModel<User>();
		// table.setSelectionModel(selectionModel);
		// selectionModel.addSelectionChangeHandler(new Handler() {
		//
		// @Override
		// public void onSelectionChange(SelectionChangeEvent event) {
		// User selected = selectionModel.getSelectedObject();
		// if (selected != null) {
		// // Window.alert("You Selected: " + selected.getFirstName());
		// }
		// }
		// });

		main.setBorderWidth(1);
		main.setWidth("100%");

		table.setRowCount(users.size(), true);
		table.setRowData(0, users);
		table.setWidth("100%", true);
		table.setColumnWidth(idColumn, "5%");
		table.setColumnWidth(firstNameColumn, "20%");
		table.setColumnWidth(lastNameColumn, "20%");
		table.setColumnWidth(dateColumn, "40%");
		table.setColumnWidth(cellColumn, "5%");
		

		main.clear();
		main.add(table);

		// RootPanel.get("content").add(main);
	}
}
