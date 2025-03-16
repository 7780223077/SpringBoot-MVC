package com.charan.service;

import org.springframework.stereotype.Service;

import com.charan.model.Employee;
import com.charan.repository.IEmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService{
		
	private final IEmployeeRepository employeeRepository;
	
	@Override
	public Iterable<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

	@Override
	public String save(Employee emp) {
		Employee employee = employeeRepository.save(emp);
		return "employee is saved with id "+employee.getEmpId();
	}

	@Override
	public Employee getEmployeeByEmpId(int id) {
		return employeeRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Employee not found with id : "+id));
	}
	
	@Override
	public String update(Employee emp) {
		Employee employee = employeeRepository.save(emp);
		return "employee updated with id "+employee.getEmpId();
	}

	@Override
	public String delete(Integer empId) {
		employeeRepository.findById(empId)
			.orElseThrow(()->new IllegalArgumentException("Employee not found with id : "+empId));
		employeeRepository.deleteById(empId);
		return "employee deleted successfully with id : "+empId;
	}
}
