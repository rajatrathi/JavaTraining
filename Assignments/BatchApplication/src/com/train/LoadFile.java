package com.train;

import java.io.FileNotFoundException;

public class LoadFile implements Runnable
{
	private String fileName;
		FileLoadingService fileloader;
	
	public LoadFile(String fileName) {
		super();
		this.fileName = fileName;     
	}
	@Override
	public void run() {
		try {
			fileloader.loadtoDatabase(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
