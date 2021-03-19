package com.ofss.dao;

import java.util.List;

import com.ofss.model.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(String empId);
}
