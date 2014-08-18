package db4j;

import java.util.Date;

public class Employee {

	private Object id;
	private final String firstName;
	private final String lastName;
	private final Date birthDate;
	
	public Employee(String firstName, String lastName, Date birthDate) {
		super();
		this.id = null;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public Object getID() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
	public static Employee valueOf(Integer idAsInt, String firstName, String lastName, Date birthDate) {
		Employee employee = new Employee(firstName, lastName, birthDate);
		employee.id = idAsInt;
		return employee;
	}

	@Override
	public String toString() {
		return "Employee<" + id + ">[firstName=" + firstName
				+ ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
	}
	
}
