package com.pearlmutter.client;

import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;

public class Item extends TreeItem {
	private boolean type;
	
	public Item(){
		super();
	}
	
	public Item(Widget widget){
		super(widget);
	}
	
	public void setAsTitle() {
		type = false;
	}
	
	public void setAsItem() {
		type = true;
	}
}
