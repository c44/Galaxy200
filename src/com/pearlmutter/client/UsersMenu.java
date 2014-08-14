package com.pearlmutter.client;

import java.util.ArrayList;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;

public class UsersMenu extends Composite {
	private Galaxy200 app;
	private HorizontalPanel header = new HorizontalPanel();
	private Label title = new Label();
	private Tree tree = new Tree();
	private TreeItem mainItem = new TreeItem(header);
	private ArrayList<TreeItem> items = new ArrayList<TreeItem>();

	public UsersMenu(Galaxy200 app) {
		this.app = app;
		initWidget(tree);
		title.setText("Users");
		content(app);
		header();
	}

	private void header() {
		Image img = new Image("Resources/images/user.png");
		img.setSize("16px", "16px");
		header.add(img);
		header.add(title);
	}

	private void content(Galaxy200 app) {
//		content.setWidth("100%");

		for (int i = 0; i < app.users.size(); i++) {
			TreeItem item = new TreeItem();
			item.setText(app.users.get(i).getFirstName() + " " + app.users.get(i).getLastName());
			items.add(i, item);
			app.getUi().getContent().getOracle().add(item.getText());
		}

		TreeItem north = new TreeItem();
		north.setText("North");
		for (int i = 0; i < app.users.size(); i++) {
			if (app.users.get(i).getBranch().equals("North")) {
				north.addItem(items.get(i));
			}
		}

		TreeItem south = new TreeItem();
		south.setText("South");
		for (int i = 0; i < app.users.size(); i++) {
			if (app.users.get(i).getBranch().equals("South")) {
				south.addItem(items.get(i));
			}
		}

		tree.addSelectionHandler(new selectHandler());

//		tree.addStyleName("tree");
		tree.setAnimationEnabled(true);
		mainItem.addItem(north);
		mainItem.addItem(south);
		mainItem.setState(true);
		tree.addItem(mainItem);
//		tree.setWidth("100px");

//		ScrollPanel wrapper = new ScrollPanel(tree);

//		content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//		content.add(wrapper);
//		wrapper.setSize("194px", "202px");

	}

	public Widget getHeader() {
		return header;
	}

	private class selectHandler implements SelectionHandler<TreeItem> {

		@Override
		public void onSelection(SelectionEvent<TreeItem> event) {
			TreeItem item = event.getSelectedItem();
//			if (item.getText().equals("North") || item.getText().equals("South")) {
//				item.setState(!item.getState());
//			}

			try {
				int j = items.indexOf(item);
				app.getUi().getContent().setSelectedUser(app.users.get(j));
				app.getUi().getContent().setFirstNameField(app.users.get(j).getFirstName());
				app.getUi().getContent().setLastNameField(app.users.get(j).getLastName());
				app.getUi().getContent().setIdField(app.users.get(j).getId());
				app.getUi().getContent().setBdField(app.users.get(j).getBirthDay());

				app.getUi().getContent().resetColors();
				app.getUi().getContent().getSaveButton().setEnabled(false);
			} catch (Exception e) {
//				e.printStackTrace();
			}
		}
	}
}
