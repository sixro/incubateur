package sample;

import java.io.Serializable;
import java.util.*;

/**
 * Represents an employee.
 *
 * <p>
 * Blah blah blah.
 * </p>
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String firstName;
	private final String lastName;

    public Employee(String firstName, String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    }

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

}
