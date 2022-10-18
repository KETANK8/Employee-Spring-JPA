/**
 * @author Ketan Kumar
 * Illustrating OPERATION TO ADD EMPLOYEE AND REMOVE EMPLOYEE FROM DATABASE
 * PERFORMING FETCH ONE OR ALL EMPLOYEE USING PRIMARY KEY/ EMPLOYEE NAME/ CITY NAME
 * USING SPRING JPA CREATING SPRING BOOT APPLICATION
 */

package com.demospring.controller;

import java.util.List;
import java.util.Optional;

import com.demospring.model.Employee;
import com.demospring.model.login;
import com.demospring.service.employeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// RestController annotation is applied to a class to mark it as a request handler
@RestController
public class employeeController {

	@Autowired
	private employeeService empService;

	// Request Method 1
	// Method to handle the request to get employee data
	// setting request mapping with get method to retrive data
	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	public List<Employee> getAllEmployee() {
		// calling getAllEmployee method from service
		// to return list of employee
		return empService.getAllEmployee();
	}

	// Request Method 2
	// Method to handle the request to register an employee
	// Setting request mapping with post method to store data
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String addEmployee(@RequestBody Employee emp) {
		// calling addEmployee method form service
		// to add the employee in database
		// return success message
		return empService.addEmployee(emp);
	}

	// Request Method 3
	// Method to handle the request to add a list of employee in database
	// Setting request mapping with post method to store the list
	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	public String addAllEmployee(@RequestBody List<Employee> emp) {
		// calling addAllEmployee method from service
		// to add the employee list in database
		// return success message
		return empService.addAllEmployee(emp);
	}

	// Request Method 4
	// Method to handle the request to login an employee using Name and Password
	// Setting request mapping with get method to fetch and match the name and
	// password
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String loginEmployee(@RequestBody login log) {
		// calling loginEmployee method from service layer
		// to fetch and match the employee name and password
		// with given name and password for login
		// return message of success or unsuccessful login
		return empService.loginEmployee(log);
	}

	// Request Method 5
	// Method to handle the request to fetch employee detail using primary key
	// Setting request mapping with get method to fetch employee details
	@RequestMapping(method = RequestMethod.GET, value = "/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {// using pathvariable to create variable url using
																	// primary key
		// calling getEmployee method from service layer
		// to fetch employee details
		// return employee object
		return empService.getEmployee(id);
	}

	// Request Method 6
	// Method to handle the request to delete employee from database using primary
	// key
	// Setting request mapping with delete method to delete employee details
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
	public String removeEmployee(@PathVariable int id) {// using pathvariable to create variable url using primary key
		// calling remove employee fro service layer
		// to delete employee details
		// return success message
		return empService.removeEmployee(id);
	}

	// Request Method 7
	// Method to handle the request to fetch employee detail using employee name
	// Setting request mapping with get method to fetch employee details
	@RequestMapping(method = RequestMethod.GET, value = "/employeename/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name) {// using pathvariable to create variable url
																		// using employee name
		// calling getEmployeeByName method from service layer
		// to fetch employee details
		// return employee list with same name
		return empService.getEmployeeByName(name);
	}

	// Request Method 8
	// Method to handle the request to fetch employee detail using employee city
	// name
	// Setting request mapping with get method to fetch employee details
	@RequestMapping(method = RequestMethod.GET, value = "/employeecity/{city}")
	public List<Employee> getEmployeeByCity(@PathVariable String city) {// using pathvariable to create variable url
																		// using city name
		// calling getEmployeeByCity method from service layer
		// to fetch employee details
		// return list of employee from same city
		return empService.getEmployeeByCity(city);
	}

	// Request Method 9
	// Method to handle the request to fetch employee detail using employee salary
	// Setting request mapping with get method to fetch employee details
	@RequestMapping(method = RequestMethod.GET, value = "/employeesalary/{salary}")
	public List<Employee> getEmployeeBySalary(@PathVariable int salary) {// using pathvariable to create variable url
																			// using salary amount
		// calling getEmployeeBySaary method from service layer
		// to fetch employee details
		// return list of employee whose salary more than the given salary amount
		return empService.getEmployeeBySalary(salary);
	}
}