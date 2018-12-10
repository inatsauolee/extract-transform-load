package com.ensah.etl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ensah.etl.bean.File;


@Service
public interface FileService{

	//Save File:
	public File saveFile(File p);

	//Update File:
	public File updateFile(File p);
	
	//Delete File:
	public void deleteFile(File p);
	
	//Delete File by ID:
	public void deleteFileById(int id);
	
	//Get File by ID:
	public File getFileById(int id);

	//Get Files Count
	public long getFilesCount();
}
