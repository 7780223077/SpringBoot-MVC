package com.charan.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.charan.model.Employee;

public interface IEmployeeService {
	public Page<Employee> getAllEmployees(Pageable pageable);
	public String save(Employee emp);
	public Employee getEmployeeByEmpId(int id);
	String update(Employee emp);
	public String delete(Integer empId);
	public String deleteAll();
}
