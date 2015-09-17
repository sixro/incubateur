package sample;

import java.util.*;

import javax.ws.rs.*;

/**
 * Provide information about employees.
 *
 * <p>
 * Blah blah blah.
 * </p>
 */
@Path("/employees")
public class EmployeesResource {

    @GET
    @Produces("application/json")
    public List<Employee> findAll() {
    	return Arrays.asList(
    			new Employee("Mario", "Rossi"), 
    			new Employee("Giuseppe", "Verdi")
    		);
    }
    
}
