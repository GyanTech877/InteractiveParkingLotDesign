package com.gojek.parkinglot;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.gojek.parkinglot.processors.CommandProcessorFactory;
import com.gojek.parkinglot.processors.FileCommandProcessor;
import com.gojek.parkinglot.processors.InteractiveCommandProcessor;

class CommandProcessorFactoryTest {

	@Test
	void getCommandProcessorWithArgument() {
		assertEquals(FileCommandProcessor.class, CommandProcessorFactory.getCommandProcessor(new String[] {"test.text"}).getClass());
	}
	@Test
	void getCommandProcessorWithoutArgument() {
		assertEquals(InteractiveCommandProcessor.class, CommandProcessorFactory.getCommandProcessor(new String[] {}).getClass());
	}

}
