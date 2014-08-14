package com.pearlmutter.client;

import java.util.ArrayList;

import org.w3c.dom.Document;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.pearlmutter.shared.Cell;
import com.pearlmutter.shared.User;

@RemoteServiceRelativePath("xmlRW")
public interface DBService extends RemoteService {
	String getTestText();
//	User[] getUsers();
//	Cell[] getCells();
	void save(ArrayList<User> users, ArrayList<Cell> cells);
	ArrayList<User> getUsers();
	ArrayList<Cell> getCells();
}
