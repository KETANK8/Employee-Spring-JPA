/**
 * @author Ketan Kumar
 * Illustrating OPERATION TO ADD EMPLOYEE AND REMOVE EMPLOYEE FROM DATABASE
 * PERFORMING FETCH ONE OR ALL EMPLOYEE USING PRIMARY KEY/ EMPLOYEE NAME/ CITY NAME
 * USING SPRING JPA CREATING SPRING BOOT APPLICATION
 */

package com.demospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// Settiing a model for login method
public class login {

	// using login name and password to match with employee name and password
	private String name;
	private String password;
}
