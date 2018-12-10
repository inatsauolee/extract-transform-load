package com.ensah.etl.bean;

import java.util.List;

public class File {

	private int idFile;

	private String name;
	
	private String description;
	
	private List<String> headers;
	
	private String data;

	public File(int idFile, String name, String description, List<String> headers, String data) {
		this.idFile = idFile;
		this.name = name;
		this.description = description;
		this.headers = headers;
		this.data = data;
	}

	public int getIdFile() {
		return idFile;
	}

	public void setIdFile(int idFile) {
		this.idFile = idFile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
	
	
	