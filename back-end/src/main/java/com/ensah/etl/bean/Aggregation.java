package com.ensah.etl.bean;

public class Aggregation {
	
	private String ID;
	private String column;
	
	public Aggregation() {
	}

	public Aggregation(String iD, String column) {
		ID = iD;
		this.column = column;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}
	
	
	
	
}
