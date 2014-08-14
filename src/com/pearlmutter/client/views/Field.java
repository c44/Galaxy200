package com.pearlmutter.client.views;

public class Field {
	private String name;
//	private String value;
	private FieldType fieldType;
	
	public Field(String name, FieldType fieldType) {
		this.name = name;
		this.fieldType = fieldType;
	}

	public String getName() {
		return name;
	}

	public FieldType getFieldType() {
		return fieldType;
	}
}
