package com.gojek.parkinglot.processors;

import java.util.Scanner;

import com.gojek.parkinglot.ParkingLotImpl;
import com.gojek.parkinglot.constants.Commands;
import com.gojek.parkinglot.entities.Car;
import com.gojek.parkinglot.exception.ParkingLotException;

public abstract class CommandProcessor {
	protected Scanner sc;
	public abstract void process();
	private ParkingLotImpl parkingLotImpl;

	public void doProcess(String inputString) throws ParkingLotException{

		String[] splittedInput = inputString.split(" ");
		if(splittedInput[0].equals("")) {
			System.out.println("Thanks for using GoJek Parking Lot program");
			parkingLotImpl.destroy();
			return;
		}

		//Get the proper command from first part of input string
		Commands command = Commands.getCommandByString(splittedInput[0]);

		if(command == null) {
			System.out.println("Please Enter a valid command");
			return;
		}

		switch(command) {
		case CREATE:
			if(splittedInput.length != 2) {
				throw new ParkingLotException("Please enter valid 2 arguments for command : " + command);
			} 
			int noOfSlots = Integer.parseInt(splittedInput[1]);
			parkingLotImpl = ParkingLotImpl.createParkingLot(noOfSlots);
			System.out.println("Created a parking lot with "+noOfSlots+" slots");
			break;
		case PARK:
			if(parkingLotImpl==null) {
				throw new ParkingLotException("Please create parking lot using "+Commands.CREATE.toString()+" command before using : " + command);
			}
			if(splittedInput.length != 3) {
				throw new ParkingLotException("Please enter valid 3 arguments for command : " + command);
			} 
			String regNo = splittedInput[1];
			String color = splittedInput[2];
			parkingLotImpl.parkCar(new Car(regNo, color));
			break;
		case LEAVE:
			if(parkingLotImpl==null) {
				throw new ParkingLotException("Please create parking lot using "+Commands.CREATE.toString()+" command before using : " + command);
			}
			if(splittedInput.length != 2) {
				throw new ParkingLotException("Please enter valid 2 arguments for command : " + command);
			} 
			int slotNo = Integer.parseInt(splittedInput[1]);
			parkingLotImpl.leaveCar(slotNo);
			break;
		case STATUS:
			if(parkingLotImpl==null) {
				throw new ParkingLotException("Please create parking lot using "+Commands.CREATE.toString()+" command before using : " + command);
			}
			if(splittedInput.length != 1) {
				throw new ParkingLotException("Please enter valid 1 argument for command : " + command);
			}
			parkingLotImpl.getStatus();
			break;
		case CAR_FROM_COLOR:
			if(parkingLotImpl==null) {
				throw new ParkingLotException("Please create parking lot using "+Commands.CREATE.toString()+" command before using : " + command);
			}
			if(splittedInput.length != 2) {
				throw new ParkingLotException("Please enter valid 2 arguments for command : " + command);
			}
			parkingLotImpl.getRegistrationNumbers(splittedInput[1]); 
			break;
		case SLOT_FROM_COLOR:
			if(parkingLotImpl==null) {
				throw new ParkingLotException("Please create parking lot using "+Commands.CREATE.toString()+" command before using : " + command);
			}
			if(splittedInput.length != 2) {
				throw new ParkingLotException("Please enter valid 2 arguments for command : " + command);
			}
			parkingLotImpl.getSlotNumbersFromColor(splittedInput[1]);  
			break;
		case SLOT_FROM_REG_NO:
			if(parkingLotImpl==null) {
				throw new ParkingLotException("Please create parking lot using "+Commands.CREATE.toString()+" command before using : " + command);
			}
			if(splittedInput.length != 2) {
				throw new ParkingLotException("Please enter valid 2 arguments for command : " + command);
			}
			parkingLotImpl.getSlotNumberFromRegNo(splittedInput[1]); 
			break;
		default:
			System.out.println("Please Enter a valid command");
		}
	}
}
