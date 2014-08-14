package com.pearlmutter.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CellsMenu extends Composite {
	private Galaxy200 app;
	private HorizontalPanel header = new HorizontalPanel();
	private Tree tree = new Tree();
	private TreeItem mainItem = new TreeItem(header);
	private Label title = new Label();
	
	public CellsMenu(Galaxy200 app) {
		this.app = app;
		initWidget(tree);
		title.setText("Cells");
		content();
		header();
	}
	
	private void header() {
		Image img = new Image("Resources/images/cell.png");
		img.setSize("16px", "16px");
		header.add(img);
		header.add(title);
	}
	
	private void content() {
		for (int i = 0; i < app.cells.size(); i++) {
			TreeItem item = new TreeItem();
			item.setText(app.cells.get(i).getName());
			mainItem.addItem(item);
		}
		
		tree.setAnimationEnabled(true);
//		mainItem.setState(true);
		tree.addItem(mainItem);
	}
	
	public Widget getHeader() {
		return header;
	}
}
