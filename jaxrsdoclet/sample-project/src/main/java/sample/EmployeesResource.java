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

	private final Repository repository;

    public EmployeesResource(Repository repository) {
    	this.repository = repository;
    }

    @GET
    public List<Employee> findAll() {
    	return Arrays.asList(repository.findAll());
    }
    
}
