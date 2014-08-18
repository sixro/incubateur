package sample;

import java.util.*;

/**
 * Represents a repository.
 *
 * @repository
 */
public interface Repository {

    /**
     * Returns an employee searching by its id.
     *
     * @param employeeID
     * @return an {@link Employee}
     *
     * @sql SELECT * FROM employee WHERE employee_id = :employeeID
     */
    Employee findEmployeeByID(Long employeeID);

    /**
     * Returns employees born between specified dates.
     *
     * @param from a date
     * @param to a date
     * @return list of employees
     *
     * @sql SELECT * FROM employee WHERE birth_date BETWEEN :from AND :to
     */
    Employee[] findEmployeesBornBetween(Date from, Date to);

    /**
     * Store specified employee.
     *
     * @param employee
     *
     * @sql UPDATE employee SET first_name = :employee.firstName, last_name = :employee.lastName, birth_date = :employee.birthDate WHERE employee_id = :employee.id
     * @sql UPDATE employee_x SET y = 'a'
     */
    void storeEmployee(Employee employee);

}
