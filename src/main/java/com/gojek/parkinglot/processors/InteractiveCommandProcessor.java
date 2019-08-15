package com.gojek.parkinglot.processors;

import java.util.Scanner;

import com.gojek.parkinglot.exception.ParkingLotException;

public class InteractiveCommandProcessor extends CommandProcessor{

	@Override
	public void process() {
		sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
        	try {
				doProcess(sc.nextLine());
			} catch (ParkingLotException e) {
				System.out.println("Got Parking Lot exception: "+e);
			}
        }
	}

}
