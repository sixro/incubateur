package sample;

import java.util.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class App extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
		classes.add(EmployeesResource.class);
		return classes;
	}
	
}
