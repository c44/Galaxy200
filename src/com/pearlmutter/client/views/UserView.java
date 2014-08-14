package com.pearlmutter.client.views;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.pearlmutter.client.Galaxy200;
import com.pearlmutter.shared.User;

public class UserView extends Composite {
	private Galaxy200 app;
	private VerticalPanel main = new VerticalPanel();
	private ListBox selector = new ListBox();
	private MultiWordSuggestOracle oracle = new MultiWordSuggestOracle(); // test
	private SuggestBox searchBox = new SuggestBox(oracle); // test
	private Button saveButton = new Button("Save");
	private TextBox firstNameField = new TextBox();
	private TextBox lastNameField = new TextBox();
	private TextBox idField = new TextBox();
	private DateBox bdField = new DateBox();
	private User user;
	private FlexTable table = new FlexTable();
	

	public UserView(Galaxy200 app, User user) {
		this.app = app;
		this.user = user;
//		table = app.getUi().getContent().getTable();
		initWidget(main);
		init();
		initUI();
	}
	
	private void init() {
		
	}
	
	private void initUI() {
		table.setText(0, 0, "First Name:");
		table.setText(1, 0, "last Name:");
		table.setText(2, 0, "ID:");
		table.setText(3, 0, "Birth Day:");

		table.setWidget(0, 1, firstNameField);
		table.setWidget(1, 1, lastNameField);
		table.setWidget(2, 1, idField);
		bdField.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd/MM/yyyy")));
//		bdField.setWidth("100%");
		table.setWidget(3, 1, bdField);
		main.addStyleName("content");
//		main.add(selector);
//		main.add(searchBox); // test
		main.add(table);
//		main.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		saveButton.setEnabled(false);
		main.add(saveButton);

	}
	
	public void setFirstNameField(String firstName) {
		firstNameField.setText(firstName);
	}

	public void setLastNameField(String lastName) {
		lastNameField.setText(lastName);
	}

	public void setIdField(String id) {
		idField.setText(id);
	}

	public void setBdField(Date bd) {
		bdField.setValue(bd);
	}
}
