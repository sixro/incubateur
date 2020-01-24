package db4idlers;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class DB {

	private static final Log LOG = LogFactory.getLog(DB.class);
	
	@SuppressWarnings("unused")
	private final DataSource dataSource;
	private final JdbcTemplate jdbc;

	public DB(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
		this.jdbc = new JdbcTemplate(dataSource, true /* lazy init */);
	}

	/**
	 * Returns an array of objects of specified type loaded in the specific way and with specific parameters.
	 * 
	 * <p>
	 * The {@code way} parameter is used to lookup for a resource in the same package of
	 * required class. E.g. if you call:
	 * </p>
	 * <pre>
	 *     db.list(myapp.Employee.class, "with-status", "deleted");
	 * </pre>
	 * <p>
	 * the method searches for file {@code /myapp/Employee_with-status.sql} and execute SQL inside it.
	 * </p>
	 *   
	 * @param type the expected type
	 * @param way the way to list required types
	 * @param parameters parameters to pass to the loaded SQL (use {@code '?'})
	 * @return array of objects of specified type
	 */
	@SuppressWarnings("unchecked")
	public <T> T[] list(Class<T> type, String way, Object... parameters) {
		if (LOG.isInfoEnabled()) LOG.info("[list] listing all " + type.getName() + "(s) *" + way + "* using parameters: " + Arrays.toString(parameters) + " ...");
		long start = System.currentTimeMillis();
		
		String sql = loadSql(type, way);
		if (LOG.isDebugEnabled()) LOG.debug("[list] ... executing SQL '" + sql + "' ...");
		
		List<T> list = jdbc.query(sql, parameters, new SimpleRowMapper<T>(type));
		T[] array = list.toArray((T[]) Array.newInstance(type, list.size()));
		
		if (LOG.isInfoEnabled()) LOG.info("[list] ... returning " + array.length + " " + type.getName() + "(s) in " + (System.currentTimeMillis() - start) + "ms");
		if (LOG.isDebugEnabled()) LOG.debug("[list] ... and they are: " + list);
		return array;
	}

	/**
	 * Returns the first object of specified type loaded in the specific way and with specific parameters.
	 * 
	 * <p>
	 * If the underline SQL query returns more than one object, this method returns the first without giving
	 * any warning/error.
	 * </p>
	 * 
	 * @param type the expected type
	 * @param way the way to list required types
	 * @param parameters parameters to pass to the loaded SQL (use {@code '?'})
	 * @return the first object of specified type loaded in the specific way and with specific parameters or {@code null} if no object is loaded
	 */
	public <T> T fetch(Class<T> type, String way, Object... parameters) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Update specified type into database using specified way and parameters.
	 * 
	 * @param object the object to update
	 * @param way the way to update object
	 * @param parameters parameters to pass to the loaded SQL (use {@code '?'})
	 */
	public <T> void update(Class<T> type, String way, Object... parameters) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Update specified object into database using specified way and parameters.
	 * 
	 * @param object the object to update
	 * @param way the way to update object
	 * @param parameters parameters to pass to the loaded SQL (use {@code '?'})
	 */
	public <T> void update(T object, String way, Object... parameters) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Update specified objects into database using specified way and parameters.
	 * 
	 * @param objects the objects to update
	 * @param way the way to update object
	 * @param parameters parameters to pass to the loaded SQL (use {@code '?'})
	 */
	public <T> void update(T[] objects, String way, Object... parameters) {
		throw new UnsupportedOperationException();
	}

	protected <T> String loadSql(Class<T> type, String way) {
		String resourcePathname = toResourcePathname(type, way);
		if (LOG.isDebugEnabled()) LOG.debug("... resource path name is '" + resourcePathname + "' ...");
		return loadContent(resourcePathname);
	}

	protected <T> String toResourcePathname(Class<T> type, String way) {
		String resourcePath = new StringBuilder(packageAsDir(type))
			.append('/')
			.append(type.getSimpleName())
			.append('_')
			.append(way)
			.append(".sql")
			.toString();
		return resourcePath;
	}
	
	protected String loadContent(String resourcePathname) {
		InputStream stream = DB.class.getResourceAsStream(resourcePathname);
		try {
			return IOUtils.toString(stream);
		} catch (IOException e) {
			throw new RuntimeException("Unhandled exception " + e.getClass().getName() + " with message '" + e.getMessage() + "' obtained", e);
		} finally {
			IOUtils.closeQuietly(stream);
		}
	}
	
	protected String packageAsDir(Class<?> type) {
		return "/" + type.getPackage().getName().replace('.', '/');
	}
	
}
