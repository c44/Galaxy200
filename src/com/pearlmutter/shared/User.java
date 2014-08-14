package com.pearlmutter.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class User implements Serializable {

	private String firstName;
	private String lastName;
	private String id;
	private String branch;
	private String cell;
	private Cell cell1;
	private Date birthDay;
	private ArrayList<WorkDay> workDays = new ArrayList<>();

	public User() {

	}

	public User(String firstName, String lastName, String id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public ArrayList<WorkDay> getWorkDays() {
		return workDays; // TODO work on this
	}

	public void setWorkDays(ArrayList<WorkDay> workDays) {
		this.workDays = workDays; // TODO work on this
	}

	public void addWorkDay(Date date, WorkDayType type, boolean approval) {
		workDays.add(new WorkDay(date, type, approval));
	}

	public void addWorkDay(WorkDay wd) {
		workDays.add(wd);
	}

	public Cell getCell1() {
		return cell1;
	}

	public void setCell1(Cell cell1) {
		this.cell1 = cell1;
	}

}