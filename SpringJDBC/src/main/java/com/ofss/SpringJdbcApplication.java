package com.ofss;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ofss.model.Employee;
import com.ofss.service.EmployeeService;

@SpringBootApplication
public class SpringJdbcApplication {

	@Autowired
	EmployeeService employeeService;
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
//		Uncomment required things 
//		Employee e1=new Employee();
//		e1.setEmpId(15);	
//		e1.setEmpName("Guru");		
//		employeeService.insertEmployee(e1);
//		
//		Employee e2=new Employee();	e2.setEmpId(25);	e2.setEmpName("Amar");
//		
//		Employee e3=new Employee();	e3.setEmpId(35);	e3.setEmpName("Akbar");
//		
//		Employee e4=new Employee();	e4.setEmpId(45);	e4.setEmpName("Anthony");
//
//		List<Employee> employees=Arrays.asList(e2,e3,e4);
//		employeeService.insertEmployees(employees);

//		employeeService.getAllEmployees();
//		employeeService.getEmployeeById("25");
	}
}
