package com.pearlmutter.shared;

import java.io.Serializable;
import java.util.Date;

public class WorkDay implements Serializable {
	private Date date;
	private WorkDayType type;
	private boolean approval;

	public WorkDay() {

	}
	
	public WorkDay(Date date, WorkDayType type, boolean approval) {
		this.date = date;
		this.type = type;
		this.approval = approval;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type.toString();
	}

	public void setType(WorkDayType type) {
		this.type = type;
	}

	public boolean isApproved() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}
}
