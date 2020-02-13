package com.main.service;

import java.sql.Date;
import java.util.List;

import com.main.model.Employee;

public interface EmployeeService {
	public String addEmployee(Employee emp);

	public List<Employee> getEmployeeDetails(String name, Date startDate, Date endDate);

	public List<Employee> getAllEmployees();

}
