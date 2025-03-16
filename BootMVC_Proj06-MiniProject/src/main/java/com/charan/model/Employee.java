package com.charan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee_MVC")
public class Employee {
	
	@Id
	@SequenceGenerator(name = "empGen", sequenceName = "emp_id_seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "empGen", strategy = GenerationType.SEQUENCE)
	private Integer empId;
	
	@Column(length = 30)
	private String empName;
	
	@Column(length = 40)
	private String designation;
	
//	@Column(precision = 12, scale = 2)
	private Double sal;
	
//	@Column(precision = 5)
	private Integer deptNo;
	
	public void setEmpId(Integer id) {
		System.out.print("employee Id : ");
		System.out.println(id);
		this.empId = id;
	}
}
