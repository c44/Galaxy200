package com.pearlmutter.client;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.pearlmutter.shared.User;

public class Content extends Composite {
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
	private FlexTable table = new FlexTable();
	User selectedUser;
	
//	public ArrayList<User> users = new ArrayList<>();
//	public ArrayList<Cell> cells = new ArrayList<>();
	
	public final DBServiceAsync dbService = GWT.create(DBService.class);

	public Content(Galaxy200 app) {
		this.app = app;
		initWidget(main);
		init();
		initUI();
	}

	private void init() {
		
//		users.add(app.users.get(0));
//		cells.add(app.cells.get(0));
		
		selector.addItem("- Select User -");
		selector.addItem("Yonatan", "0");
		selector.addItem("Avia", "0");
		selector.addItem("Jon", "0");

		searchBox.getValueBox().addChangeHandler(new SelectHandler());

		firstNameField.addChangeHandler(new editHandler());
		lastNameField.addChangeHandler(new editHandler());
		idField.addChangeHandler(new editHandler());
		bdField.addValueChangeHandler(new editHandler());

		saveButton.addClickHandler(new saveHandler());
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

	public FlexTable getTable() {
		return table;
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

	public MultiWordSuggestOracle getOracle() {
		return oracle;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public Button getSaveButton() {
		return saveButton;
	}

	public void resetColors() {
		firstNameField.getElement().getStyle().setBackgroundColor("white");
		lastNameField.getElement().getStyle().setBackgroundColor("white");
		idField.getElement().getStyle().setBackgroundColor("white");
		bdField.getElement().getStyle().setBackgroundColor("white");
	}

	private class editHandler implements ChangeHandler, ValueChangeHandler<Date> {

		@Override
		public void onChange(ChangeEvent event) {
			TextBox src = (TextBox) event.getSource();
			src.getElement().getStyle().setBackgroundColor("#a36dcf");
			saveButton.setEnabled(true);
		}

		@Override
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateBox src = (DateBox) event.getSource();
			src.getElement().getStyle().setBackgroundColor("#a36dcf");
			saveButton.setEnabled(true);
		}
	}

	private class saveHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			String firstNameValue = firstNameField.getText();
			String lastNameValue = lastNameField.getText();
			String idValue = idField.getText();
			Date bdValue = bdField.getValue();

			if (selectedUser != null) {
				selectedUser.setFirstName(firstNameValue);
				selectedUser.setLastName(lastNameValue);
				selectedUser.setId(idValue);
				selectedUser.setBirthDay(bdValue);
				
//				resetColors();
//				saveButton.setEnabled(false);

				
				
				dbService.save(app.users, app.cells, new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						resetColors();
						saveButton.setEnabled(false);
					}
					
					@Override
					public void onFailure(Throwable caught) {
						main.add(new Label("FAILD TO SAVE!!"));
					}
				});

			}
		}
	}

	private class SelectHandler implements ChangeHandler {

		@Override
		public void onChange(ChangeEvent event) {
			// TODO Auto-generated method stub

		}
	}
}
