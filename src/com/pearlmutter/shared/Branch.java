package com.pearlmutter.shared;

public enum Branch {
	North(0), South(1);

	private int id;

	private Branch(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
