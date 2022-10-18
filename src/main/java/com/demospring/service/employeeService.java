/**
 * @author Ketan Kumar
 * Illustrating OPERATION TO ADD EMPLOYEE AND REMOVE EMPLOYEE FROM DATABASE
 * PERFORMING FETCH ONE OR ALL EMPLOYEE USING PRIMARY KEY/ EMPLOYEE NAME/ CITY NAME
 * USING SPRING JPA CREATING SPRING BOOT APPLICATION
 */

package com.demospring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demospring.model.Employee;
import com.demospring.model.login;
import com.demospring.repo.employeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service marks a Java class that performs some service
// Provide these services to user in controller layer
@Service
public class employeeService {

	@Autowired
	private employeeRepository empRepo;

	// Method 1
	// To Fetch list of all employee from database
	public List<Employee> getAllEmployee() {
		List<Employee> empList = new ArrayList<>();
		empRepo.findAll().forEach(empList::add);
		return empList;
	}

	// Method 2
	// To Register an employee in database
	public String addEmployee(Employee emp) {
		empRepo.save(emp);
		return "Employee Added.";
	}

	// Method 3
	// To add the list of employee in database
	public String addAllEmployee(List<Employee> emp) {
		empRepo.saveAll(emp);
		return "All Employees Added.";
	}

	// Method 4
	// TO give user a login method
	// Employee can login by giving correct employee Name and Password
	public String loginEmployee(login log) {
		Iterable<Employee> empList = new ArrayList<>();
		empList = empRepo.findByEmpName(log.getName());
		if (empList != null) {
			for (Employee emp : empList) {
				if (emp.getEmpPassword().equals(log.getPassword()))
					return "Login Successfull.";
				else
					return "Wrong Password";
			}
		}
		return "User does Not Exist!!! \nPlease Register yourself.";
	}

	// Method 5
	// to fetch detail of employee
	// fetch employee details using primary key
	public Optional<Employee> getEmployee(int id) {
		return empRepo.findById(id);
	}

	// Method 6
	// To Delete employee form database
	// Delete employee using primary key
	public String removeEmployee(int id) {
		empRepo.deleteById(id);
		return "Employee Deleted.";
	}

	// Method 7
	// To fetch employee details from database using name
	// Fetch List of employee with same Name
	public List<Employee> getEmployeeByName(String name) {
		List<Employee> empList = new ArrayList<>();
		empRepo.findByEmpName(name).forEach(empList::add);
		return empList;
	}

	// Method 8
	// To fetch employee details from database using city name
	// Fetch List of employee from same city
	public List<Employee> getEmployeeByCity(String city) {
		List<Employee> empList = new ArrayList<>();
		empRepo.findByEmpCity(city).forEach(empList::add);
		return empList;
	}

	// Method 9
	// To fetch employee details from database using salary amount
	// Fetch list of employee who having more salary than given amount
	public List<Employee> getEmployeeBySalary(int salary) {
		List<Employee> empList = new ArrayList<>();
		empRepo.findByEmpSalary(salary).forEach(empList::add);
		return empList;
	}

}
