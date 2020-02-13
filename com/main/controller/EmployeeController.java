package com.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Employee;
import com.main.service.EmployeeServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@Validated
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	/*** Retrieve a Employee ***/

	@PostMapping(value = "/employeeSearch", consumes = "application/json", produces = "application/json")
	public List<Employee> getEmployeeDetails(@RequestBody Employee emp) {
		System.out.println(emp.toString());
		return employeeServiceImpl.getEmployeeDetails(emp.getFirstName(), emp.getStartDate(), emp.getEndDate());
	}

	/*** Creating a new Employee ***/
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public String addEmployee(@Valid @RequestBody Employee emp) {
		System.out.println(emp.toString());
		return employeeServiceImpl.addEmployee(emp);

	}

	/*** Retrieve all Employee ***/
	@GetMapping(value = "/employees", produces = "application/json")
	public List<Employee> getAllEmployees() {
		return employeeServiceImpl.getAllEmployees();
	}

}
