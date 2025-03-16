package com.charan.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CensusTest {
	private Census census;
	
	@BeforeEach
	public void set() {
		this.census = new Census();
	}
	
	@RepeatedTest(value=10, name="execution of {displayName} - {currentRepetition}/{totalRepetitions}")
	@DisplayName("Testing Message")
	public void testMsg() {
		assertEquals("hello world", census.msg());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"naresh", "charan"})
	@DisplayName("Hello Msg Test")
	public void testHelloMsg(String name) {
		assertEquals("hello "+name, census.helloMsg(name));
	}

	
	
	@AfterEach
	public void close() {
		census = null;
	}
	
}
