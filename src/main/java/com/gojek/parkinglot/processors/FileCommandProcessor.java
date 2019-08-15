package com.gojek.parkinglot.processors;

public class FileCommandProcessor extends CommandProcessor{
	
	private String path;
	
	public FileCommandProcessor(String path) {
		this.path=path;
	}

	public String getPath() {
		return path;
	}
	
	@Override
	public void process() {
	}

}
