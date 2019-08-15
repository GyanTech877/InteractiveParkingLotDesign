package com.gojek.parkinglot;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.gojek.parkinglot.processors.FileCommandProcessor;

class FileCommandProcessorTest {

	FileCommandProcessor fileCommandProcessor;
	@Test
	void testProcessWithFile() {
		fileCommandProcessor= new FileCommandProcessor("file_input.txt");
		assertDoesNotThrow(()->fileCommandProcessor.process());
	}
}
