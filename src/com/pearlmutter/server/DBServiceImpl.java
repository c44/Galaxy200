package com.pearlmutter.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.pearlmutter.client.DBService;
import com.pearlmutter.shared.Cell;
import com.pearlmutter.shared.User;

@SuppressWarnings("serial")
public class DBServiceImpl extends RemoteServiceServlet implements DBService {

	XMLSave save;
	
	@Override
	public String getTestText() {
		return "HELLO WORLDDDDD!!!!!??!!?!?!?!?!";
	}

	@Override
	public void save(ArrayList<User> users, ArrayList<Cell> cells) {
		new XMLSave(users, cells);
	}

	@Override
	public ArrayList<User> getUsers() {
		return new XMLReader().getUsers();
	}

	@Override
	public ArrayList<Cell> getCells() {
		return new XMLReader().getCells();
	}

}
