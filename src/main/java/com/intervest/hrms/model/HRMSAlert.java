package com.intervest.hrms.model;

public class HRMSAlert {
	private int type;
	private String typeString;
	private String message;

	public HRMSAlert(int type, String typeString, String message) {
		this.type = type;
		this.typeString = typeString;
		this.message = message;

	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTypeString() {
		return typeString;
	}

	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

}
