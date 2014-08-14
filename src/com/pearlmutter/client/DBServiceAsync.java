package com.pearlmutter.client;

import java.util.ArrayList;

import org.w3c.dom.Document;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.pearlmutter.shared.Cell;
import com.pearlmutter.shared.User;

public interface DBServiceAsync {
	void getTestText(AsyncCallback<String> callback);
//	void getUsers(AsyncCallback<User[]> callback);
//	void getCells(AsyncCallback<Cell[]> callback);
	void save(ArrayList<User> users, ArrayList<Cell> cells, AsyncCallback<Void> callback);
	void getUsers(AsyncCallback<ArrayList<User>> callback);
	void getCells(AsyncCallback<ArrayList<Cell>> callback);
}
