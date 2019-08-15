package com.gojek.parkinglot.processors;

public class CommandProcessorFactory {

	public static CommandProcessor getCommandProcessor(String[] args) {
		if(args.length >= 1) {
			return new FileCommandProcessor(args[0]);
		} else {
			return new InteractiveCommandProcessor();
		}
	}
}
