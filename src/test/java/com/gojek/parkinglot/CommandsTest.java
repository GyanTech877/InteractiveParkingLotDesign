package com.gojek.parkinglot;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.gojek.parkinglot.constants.Commands;

class CommandsTest {

	@Test
	void getCommandByStringCreate() {
		Commands command = Commands.getCommandByString("create_parking_lot");
    	assertTrue(command == Commands.CREATE);
	}
	@Test
	void getCommandByStringPark() {
		Commands command = Commands.getCommandByString("park");
    	assertTrue(command == Commands.PARK);
	}
	@Test
	void getCommandByStringLeave() {
		Commands command = Commands.getCommandByString("leave");
    	assertTrue(command == Commands.LEAVE);
	}
	@Test
	void getCommandByStringStatus() {
		Commands command = Commands.getCommandByString("status");
    	assertTrue(command == Commands.STATUS);
	}
	@Test
	void getCommandByStringCarFromColor() {
		Commands command = Commands.getCommandByString("registration_numbers_for_cars_with_colour");
    	assertTrue(command == Commands.CAR_FROM_COLOR);
	}
	@Test
	void getCommandByStringSlotFromColor() {
		Commands command = Commands.getCommandByString("slot_numbers_for_cars_with_colour");
    	assertTrue(command == Commands.SLOT_FROM_COLOR);
	}
	@Test
	void getCommandByStringSlotFromRegNo() {
		Commands command = Commands.getCommandByString("slot_number_for_registration_number");
    	assertTrue(command == Commands.SLOT_FROM_REG_NO);
	}
	
	@Test
	void getCommandByStringNegative() {
		Commands command = Commands.getCommandByString("unknown command");
    	assertTrue(command == null);
	}

}
