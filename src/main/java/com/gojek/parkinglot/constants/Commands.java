package com.gojek.parkinglot.constants;

public enum Commands {

	CREATE("create_parking_lot"),
	PARK("park"),
	LEAVE("leave"),
	STATUS("status"),
	CAR_FROM_COLOR("registration_numbers_for_cars_with_colour"),
	SLOT_FROM_COLOR("slot_numbers_for_cars_with_colour"),
	SLOT_FROM_REG_NO("slot_number_for_registration_number");

	private final String name;

	private Commands(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return name;
	}

	public static Commands getCommandByString(String code){
		for(Commands c : values()){
			if(code.equalsIgnoreCase(c.name)) return c;
		}
		return null;
	}
}
