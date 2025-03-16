package com.charan.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charan.model.Employee;
import com.charan.service.IEmployeeService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
	
	private final HttpSession session;
	
	private final IEmployeeService employeeService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	@GetMapping("/report")
	public String getEmployeesReport(Map<String, Object> map) {
		Iterable<Employee> employeesData = employeeService.getAllEmployees();
		map.put("emp", employeesData);
		return "employee_report";
	}
	
	@GetMapping("/add_emp")
	public String empRegisterForm(@ModelAttribute("emp") Employee emp) {
		return "emp_register";
	}
	
	@PostMapping("/add_emp")
	public String empRegister(@ModelAttribute("emp") Employee emp
				//RedirectAttributes attr
				) {
		String msg = employeeService.save(emp);
		//Iterable<Employee> listOfEmp = employeeService.getAllEmployees();
		//map.put("emp", listOfEmp);
		//attr.addFlashAttribute("addResult", msg);
		session.setAttribute("addResult", msg);
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
}
