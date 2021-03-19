package com.ofss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.dao.EmployeeDaoImpl;
import com.ofss.model.Employee;
import com.ofss.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDaoImpl employeeDao;
	
	
	public void insertEmployee(Employee emp) {
		employeeDao.insertEmployee(emp);
		
	}

	
	public void insertEmployees(List<Employee> employees) {
		employeeDao.insertEmployees(employees);
	}

	
	public void getAllEmployees() {
		List<Employee> employees=employeeDao.getAllEmployees();
		for (Employee emp:employees)
		{
			System.out.println(emp);
		}
	}

	
	public void getEmployeeById(String empId) {
		Employee emp=employeeDAO.getEmployeeById(empId);
		System.out.println(emp);
	}

}
