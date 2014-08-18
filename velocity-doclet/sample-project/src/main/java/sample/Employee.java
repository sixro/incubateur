package sample;

import java.util.*;

/**
 * Represents an employee.
 *
 * <p>
 * Blah blah blah.
 * </p>
 *
 * @javascript
 */
public class Employee {

    private Long id;

    private final String firstName;
    private final String lastName;
    private final Date birthDate;

    private transient int age;

    public Employee(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;

        calculateAge();
    }

    Employee(Long id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;

        calculateAge();
    }

    private void calculateAge() {
        // this is a fake impl
        this.age = 39; // TODO should be now - birthdate
    }

    public int heyYou(String text) {
        return 0;
    }

    public void heyMe(int byebye, Object wonderful) {
    }

}
