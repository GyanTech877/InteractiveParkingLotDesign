package com.gojek.parkinglot;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gojek.parkinglot.exception.ParkingLotException;
import com.gojek.parkinglot.processors.CommandProcessor;
import com.gojek.parkinglot.processors.InteractiveCommandProcessor;

class CommandProcessorTest {

     CommandProcessor processor = null;

	@BeforeEach
	public void setUp(){
		processor = new InteractiveCommandProcessor();
		try {
			processor.doProcess("create_parking_lot 6");
		} catch (ParkingLotException e) {
		}
	}

	@Test
	public void testCreateCommandPositive() {
		assertDoesNotThrow(()->processor.doProcess("create_parking_lot 6"));
	}

	@Test
	public void testCreateCommandNegative() {
		assertThrows(ParkingLotException.class,()->processor.doProcess("create_parking_lot 6 12 x"));
	}

	@Test
	public void testParkPositive() {
		assertDoesNotThrow(()->processor.doProcess("park Mh14-111 White"));
	}

	@Test
	public void testParkNegative() {
		assertThrows(ParkingLotException.class,()->processor.doProcess("park Mh14-111"));
	}

	@Test
	public void testLeavePositive() {
		assertDoesNotThrow(()->processor.doProcess("leave 4"));
	}

	@Test
	public void testLeaveNegative() {
		assertThrows(ParkingLotException.class,()->processor.doProcess("leave"));
	}

	@Test
	public void testGetStatusPositive() {
		assertDoesNotThrow(()->processor.doProcess("status"));
	}

	@Test
	public void testGetStatusNegative() {
		assertThrows(ParkingLotException.class,()->processor.doProcess("status 4"));
	}

	@Test
	public void testgetRegistrationNumbersPositive() {
		assertDoesNotThrow(()->processor.doProcess("registration_numbers_for_cars_with_colour White"));
	}

	@Test
	public void testgetRegistrationNumbersNegative() {
		assertThrows(ParkingLotException.class,()->processor.doProcess("registration_numbers_for_cars_with_colour White Black Red"));
	}

	@Test
	public void testgetSlotNumbersFromColorPositive() {
		assertDoesNotThrow(()->processor.doProcess("slot_numbers_for_cars_with_colour White"));
	}

	@Test
	public void testgetSlotNumbersFromColorNegative() {
		assertThrows(ParkingLotException.class,()->processor.doProcess("slot_numbers_for_cars_with_colour White Black Blue"));
	}

	@Test
	public void testgetSlotNumberFromRegNoPositive() {
		assertDoesNotThrow(()->processor.doProcess("registration_numbers_for_cars_with_colour 1234"));
	}

	@Test
	public void testgetSlotNumberFromRegNoNegative() {
		assertThrows(ParkingLotException.class,()->processor.doProcess("registration_numbers_for_cars_with_colour 1234 5678 9012"));
	}
}
