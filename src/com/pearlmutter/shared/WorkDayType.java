package com.pearlmutter.shared;

public enum WorkDayType {
	PrivateTraining("Private Training"), Targil("Targil");
	
	private String name;
	
	private WorkDayType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
