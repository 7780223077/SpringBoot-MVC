package com.charan.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.charan.entity.Employee;
import com.charan.repository.IEmployeeRepository;

public class EmployeeServiceImplTest {
	
	private static IEmployeeService employeeService;
	
	private static IEmployeeRepository employeeRepository;
	
	@BeforeAll
	public static void createObject() {
		employeeRepository = Mockito.mock(IEmployeeRepository.class);
		employeeService = new EmployeeServiceImpl(employeeRepository);
	}
	
	@AfterAll
	public static void clear() {
		employeeRepository = null;
		employeeService = null;
	}
	
//	@Test
	public void testRegisterEmployee() {
		Employee emp = new Employee();
		emp.setJob("Developer");
		emp.setName("Ajay");
		emp.setSal(25000.0f);
		
		Employee emp2 = new Employee();
		emp.setJob("Designer");
		emp.setName("Ajay");
		emp.setSal(25000.0f);
		
		Mockito.when(employeeRepository.save(emp)).thenReturn(emp);
//		Mockito.when(employeeRepository.save(null)).thenReturn(null);
//		Mockito.when(employeeRepository.save(emp2)).thenReturn(null);
		
//		assertFalse(employeeService.registerEmployee(null));
		assertThrows(NullPointerException.class, ()->employeeService.registerEmployee(null));
		assertTrue(employeeService.registerEmployee(emp));
		assertFalse(employeeService.registerEmployee(emp2));
	}
	
	@Test
	public void testRegisterEmployeeWithSpy() {
		IEmployeeRepository empRepoSpy = Mockito.spy(IEmployeeRepository.class);
		IEmployeeService employeeService = new EmployeeServiceImpl(empRepoSpy);
		
		Employee emp = new Employee();
		emp.setJob("Developer");
		emp.setName("Ajay");
		emp.setSal(25000.0f);
		
		Employee emp2 = new Employee();
		emp.setJob("Designer");
		emp.setName("Ajay");
		emp.setSal(25000.0f);
		
		employeeService.registerEmployee(emp);
		employeeService.registerEmployee(emp2);
		
		Mockito.verify(empRepoSpy, Mockito.times(1)).save(emp);
		Mockito.verify(empRepoSpy, Mockito.never()).save(emp2);
	}
}
