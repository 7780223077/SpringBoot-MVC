package com.charan.validator;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.charan.model.Employee;

@Component
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee emp = (Employee)target;
		
		if(emp.getEmpName()==null || emp.getEmpName().isBlank()) {
			errors.rejectValue("empName", "emp.empName.required");
		}
		else if(emp.getEmpName().length()<5 || emp.getEmpName().length()>20) {
			errors.rejectValue("empName", "emp.empName.length");
		}
		
		if(emp.getDesignation()==null || emp.getDesignation().isBlank()) {
			errors.rejectValue("designation", "emp.designation.required");
		}
		else if(emp.getDesignation().length()<5 || emp.getDesignation().length()>20) {
			errors.rejectValue("designation", "emp.designation.length");
		}
		
		if(emp.getMgr()==null) {
			errors.rejectValue("mgr", "emp.mgr.required");
		}
		
		if(emp.getHireDate()==null) {
			errors.rejectValue("hireDate", "emp.hireDate.required");
		}
		else if(emp.getHireDate().isAfter(LocalDateTime.now())) {
			errors.rejectValue("hireDate", "emp.hireDate.valid");
		}
		
		if(emp.getSal()==null) {
			errors.rejectValue("sal", "emp.sal.required");
		}
		else if(emp.getSal()<25000.0) {
			errors.rejectValue("sal", "emp.sal.range");
		}
		
		if(emp.getDeptNo()==null) {
			errors.rejectValue("deptNo", "emp.deptno.required");
		}
		else if(emp.getDeptNo()<10 || emp.getDeptNo()>90) {
			errors.rejectValue("deptNo", "emp.deptno.range");
		}
	}
}
