/**
 * @author Ketan Kumar
 * Illustrating OPERATION TO ADD EMPLOYEE AND REMOVE EMPLOYEE FROM DATABASE
 * PERFORMING FETCH ONE OR ALL EMPLOYEE USING PRIMARY KEY/ EMPLOYEE NAME/ CITY NAME
 * USING SPRING JPA CREATING SPRING BOOT APPLICATION
 */

package com.demospring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

// Creating entity of employee 
@Entity
public class Employee {

	// Using Id annotation to specify primary key of entity
	@Id
	public int empId;
	public String empName;
	public String empPassword;
	public String empCity;
	public int empSalary;
	public String empPhone;
}
