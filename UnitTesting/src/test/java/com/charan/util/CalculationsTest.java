package com.charan.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName(value = "CALCULATIONS Testing")
@TestMethodOrder(OrderAnnotation.class)
public class CalculationsTest {
	
	private static Calculations calculations;
	
	@BeforeAll
	public static void setCalculations() {
		CalculationsTest.calculations  = new Calculations();
	}
	
	@Test
	@DisplayName("Even test")
	@Order(1)
	@Tag("dev")
	public void testIsEven() {
		assertTrue(calculations.isEven(2));
	}
	
	@Test
	@DisplayName("Odd test")
	@Order(2)
	@Tag("dev")
	public void testIsOdd() {
		assertFalse(calculations.isOdd(2));
	}
	
	@Test
	@Order(3)
	@DisplayName("Time complexity test for Even")
	@Tag("dev")
	@Disabled
	public void testIsEvenTimeComplexity() {
		assertTimeout(Duration.ofMillis(20), ()->calculations.isEven(10));
	}
	
	@Tag("dev")
	@Order(4)
	@ParameterizedTest
	@DisplayName("Even Test Repeated")
	@ValueSource(ints= {10,14,22,30})
	public void testIsEvenMultipleTimes(int num) {
		assertTrue(calculations.isEven(num));
	}
	
	@AfterAll
	public static void closeCalculations() {
		CalculationsTest.calculations  = null;
	}
}
