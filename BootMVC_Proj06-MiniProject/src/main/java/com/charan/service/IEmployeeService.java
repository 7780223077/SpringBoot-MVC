package com.charan.service;

import com.charan.model.Employee;

public interface IEmployeeService {
	public Iterable<Employee> getAllEmployees();
	public String save(Employee emp);
	public Employee getEmployeeByEmpId(int id);
	String update(Employee emp);
	public String delete(Integer empId);
}
