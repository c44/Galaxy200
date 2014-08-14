package com.pearlmutter.shared;

public enum CellName {
	A(0), C(1), M(2);

	private int id;

	private CellName(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
