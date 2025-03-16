package com.charan.service;

import org.springframework.stereotype.Service;

import com.charan.entity.Employee;
import com.charan.repository.IEmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService{

	private IEmployeeRepository employeeRepository;
	
	
	@Override
	public boolean registerEmployee(Employee emp) {
		if(emp == null) {
			throw new NullPointerException();
		}
//		else if(emp.getJob().equals("Designer")) {
//			return false;
//		}
		Employee savedEmployee = employeeRepository.save(emp);
		if(savedEmployee!=null) {
			return true;
		}
		return false;
	}
}
