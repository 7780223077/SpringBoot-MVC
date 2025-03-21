package com.charan.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charan.model.Employee;
import com.charan.service.IEmployeeService;
import com.charan.validator.EmployeeValidator;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
	
//	private final HttpSession session;
	
	private final EmployeeValidator empValidator;
	
	private final IEmployeeService employeeService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	@GetMapping("/report")
	public String getEmployeesReport(Map<String, Object> map, @PageableDefault(page = 0, size = 3)
			Pageable pageable) {
		Page<Employee> employeesData = employeeService.getAllEmployees(pageable);
		map.put("emp", employeesData);
		return "employee_report";
	}
	
	@GetMapping("/add_emp")
	public String empRegisterForm(@ModelAttribute("emp") Employee emp) {
		return "emp_register";
	}
	
	@PostMapping("/add_emp")
	public String empRegister(@ModelAttribute("emp") Employee emp, RedirectAttributes attr,	BindingResult errors){
		if(empValidator.supports(Employee.class)) {
			System.out.println("Validations");
			empValidator.validate(emp, errors);
			if(errors.hasErrors()) {
				System.out.println("validations failed");
				return "emp_register";
			}
		}
		String msg = employeeService.save(emp);
		//Iterable<Employee> listOfEmp = employeeService.getAllEmployees();
		//map.put("emp", listOfEmp);
		attr.addFlashAttribute("addResult", msg);
		//session.setAttribute("addResult", msg);
		return "redirect:report";
	}
	
	@GetMapping("/edit")
	public String editEmployeeForm(@ModelAttribute("emp") Employee emp, @RequestParam("id") Integer empId ) {
		Employee employee = employeeService.getEmployeeByEmpId(empId);
		BeanUtils.copyProperties(employee, emp);
		return "emp_edit";
	}
	
	@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attr) {
		String msg = employeeService.update(emp);
		attr.addFlashAttribute("addResult", msg);
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") Integer empid, RedirectAttributes attr ) {
		String msg = employeeService.delete(empid);
		attr.addFlashAttribute("addResult", msg);
		return "redirect:report";
	}
	
	@GetMapping("/delete-all")
	public String deleteAllEmployees(RedirectAttributes attr ) {
		String msg = employeeService.deleteAll();
		attr.addFlashAttribute("addResult", msg);
		return "redirect:report";
	}
	
}
