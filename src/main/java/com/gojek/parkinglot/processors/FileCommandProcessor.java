package com.gojek.parkinglot.processors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.gojek.parkinglot.exception.ParkingLotException;

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
		File inputFile = new File(path);
		try {
			sc = new Scanner(inputFile);
			while(sc.hasNextLine()) {
				doProcess(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (ParkingLotException e) {
			System.out.println("Got Parking Lot exception: "+e);
		}
	}

}
