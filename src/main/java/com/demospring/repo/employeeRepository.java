/**
 * @author Ketan Kumar
 * Illustrating OPERATION TO ADD EMPLOYEE AND REMOVE EMPLOYEE FROM DATABASE
 * PERFORMING FETCH ONE OR ALL EMPLOYEE USING PRIMARY KEY/ EMPLOYEE NAME/ CITY NAME
 * USING SPRING JPA CREATING SPRING BOOT APPLICATION
 */

package com.demospring.repo;

import com.demospring.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// @Repository is a Spring annotation that 
// indicates that the this class is acting as a repository for program 
// and handle the data.
@Repository
public interface employeeRepository extends JpaRepository<Employee, Integer> {

	Iterable<Employee> findByEmpName(String name);

	Iterable<Employee> findByEmpCity(String city);

	@Query(value = "select * from Employee where emp_Salary > ?1", nativeQuery = true)
	Iterable<Employee> findByEmpSalary(int salary);
}
