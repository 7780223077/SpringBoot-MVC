package com.charan.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.charan.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee emp = (Employee)target;
		if(emp.getEmpName()==null || emp.getEmpName().isBlank()) {
			errors.rejectValue("empName", "emp.name.required");
		}
		if(emp.getDesignation()==null || emp.getDesignation().isBlank()) {
			errors.rejectValue("designation", "emp.designation.required");
		}
		if(emp.getMgr()==null) {
			errors.rejectValue("mgr", "emp.mgr.required");
		}
		if(emp.getHireDate()==null ) {
			errors.rejectValue("hireDate", "emp.hireDate.required");
		}
		if(emp.getSal()==null || emp.getSal()<0) {
			errors.rejectValue("sal", "emp.sal.required");
		}
		if(emp.getDeptNo()==null || emp.getDeptNo()<0) {
			errors.rejectValue("deptNo", "emp.deptNo.required");
		}
	}
	
}
