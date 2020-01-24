package db4idlers;

import java.lang.reflect.*;
import java.sql.*;

import org.apache.commons.logging.*;
import org.springframework.jdbc.core.RowMapper;

public class SimpleRowMapper<T> implements RowMapper<T> {

	private static final Log LOG = LogFactory.getLog(SimpleRowMapper.class);
	
	// TODO warning for multiple instances... probably it's better to have a valueOf caching rowmappers...
	
	private final Class<T> type;
	
	private Method valueOfMethod;
	
	public SimpleRowMapper(Class<T> type) {
		super();
		this.type = type;
		
		this.valueOfMethod = null;
	}

	@Override
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		long start = System.currentTimeMillis();
		
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		Object[] columns = new Object[columnCount];
		for (int i = 1; i <= columnCount; i++)
			columns[i -1] = rs.getObject(i);
		
		long start2 = System.currentTimeMillis();
		
		// TODO first of all search for a cursor: findConstructorMatchingArgs(columns);
		if (valueOfMethod == null)
			valueOfMethod = valueOfMethodMatchingArgs(columns);
		T object = invokeAndCast(valueOfMethod, columns, type);
		
		LOG.debug("[mapRow] data read: " + (start2 - start) + "ms, object creation: " + (System.currentTimeMillis() - start2) + "ms");
		return object;
	}

	private Method valueOfMethodMatchingArgs(Object[] columns) {
		try {
			return type.getDeclaredMethod(
					"valueOf", 
					new Class<?>[]{ 
							String.class,
							String.class,
							String.class,
							String.class,
							String.class,
							String.class,
							String.class
					}
			);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException("Unhandled exception " + e.getClass().getName() + " with message '" + e.getMessage() + "' obtained", e);
		}
	}

	private T invokeAndCast(Method method, Object[] columns, Class<T> type) {
		try {
			Object object = method.invoke(null, columns);
			return type.cast(object);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException("Unhandled exception " + e.getClass().getName() + " with message '" + e.getMessage() + "' obtained", e);
		}
	}
	
}
