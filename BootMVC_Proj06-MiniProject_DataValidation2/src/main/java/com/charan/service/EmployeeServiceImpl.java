package com.charan.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.charan.exceptions.EmployeeNotFoundException;
import com.charan.model.Employee;
import com.charan.repository.IEmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService{
		
	private final IEmployeeRepository employeeRepository;
	
	@Override
	public Page<Employee> getAllEmployees(Pageable pageable){
		return employeeRepository.findAll(pageable);
	}

	@Override
	public String save(Employee emp) {
		Employee employee = employeeRepository.save(emp);
		return "employee is saved with id "+employee.getEmpId();
	}

	@Override
	public Employee getEmployeeByEmpId(int id) {
		return employeeRepository.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException("Employee not found with id : "+id));
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

	@Override
	public String deleteAll() {
		employeeRepository.deleteAll();
		return "deleted successfully";
	}
}
