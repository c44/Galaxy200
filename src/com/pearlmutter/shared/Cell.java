package com.pearlmutter.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Cell implements Serializable {
	private String name;
	private ArrayList<User> users = new ArrayList<User>();
	private Double readyness;
	
	public Cell() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public Double getReadyness() {
		return readyness;
	}

	public void setReadyness(Double readyness) {
		this.readyness = readyness;
	}
	
}
