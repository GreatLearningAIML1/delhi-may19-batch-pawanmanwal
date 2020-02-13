package com.main.dao;

import java.sql.Date;
import java.util.List;

import com.main.model.Employee;

public interface EmployeeDAO {
	public boolean addEmployee(Employee emp);

	public List<Employee> getEmployeeDetails(String name, Date startDate, Date endDate);

	public List<Employee> getAllEmployees();

}
