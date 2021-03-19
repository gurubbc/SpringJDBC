package com.ofss.service;

import com.ofss.model.Employee;
import java.util.*;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	void getAllEmployees();
	void getEmployeeById(String empid);
}

