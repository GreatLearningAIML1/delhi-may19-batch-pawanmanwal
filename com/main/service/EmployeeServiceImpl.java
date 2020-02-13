package com.main.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.dao.EmployeeDAOImpl;
import com.main.model.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;

	@Override
	public String addEmployee(Employee emp) {
		String retVal = null;
		if (emp.getStartDate().getTime() > emp.getEndDate().getTime()) {
			retVal = "Start Date cannot be later than End Date. Please try again with valid data";
		} else {
			boolean tempRetVal = employeeDAOImpl.addEmployee(emp);
			if (tempRetVal) {
				retVal = "Employee has been added successfully";
			} else {
				retVal = "Error occured while persisting the details.";
			}
		}
		return retVal;
	}

	@Override
	public List<Employee> getEmployeeDetails(String name, Date startDate, Date endDate) {
		return employeeDAOImpl.getEmployeeDetails(name, startDate, endDate);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = employeeDAOImpl.getAllEmployees();
		return empList;
	}

}
