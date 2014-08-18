package db4j;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Represents a DB.
 */
public class DB {
	
	private final JdbcTemplate jdbc;
	private final NamedParameterJdbcTemplate namedJdbc;
	
	public DB(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
		this.namedJdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public <T> List<T> list(Class<T> typeClass, String sql, Object... parameters) {
		return jdbc.query(sql, parameters, new ToConstructorOrFactoryMethodRowMapper<T>(typeClass));
	}

	public <T> List<T> list(Class<T> typeClass, String sql, Map<String, Object> parameters) {
		return namedJdbc.query(sql, parameters, new ToConstructorOrFactoryMethodRowMapper<T>(typeClass));
	}

	public <T> T fetch(Class<T> typeClass, String sql, Object... parameters) {
		Object object = jdbc.queryForObject(sql, parameters, new ToConstructorOrFactoryMethodRowMapper<T>(typeClass));
		T cast = typeClass.cast(object);
		return cast;
	}

	public <T> T fetch(Class<T> typeClass, String sql, Map<String, ? extends Object> parameters) {
		Object object = namedJdbc.queryForObject(sql, parameters, new ToConstructorOrFactoryMethodRowMapper<T>(typeClass));
		T cast = typeClass.cast(object);
		return cast;
	}

	public <T> void update(T object, String sql) {
		Map<String, Object> parameters = toParameters(object);
		namedJdbc.update(sql, parameters);
	}

	protected Map<String, Object> toParameters(final Object object) {
		Map<String, Object> parameters = new LinkedHashMap<>();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (! field.isAccessible())
				field.setAccessible(true);
			
			try {
				parameters.put(field.getName(), field.get(object));
			} catch (IllegalArgumentException e) {
				throw new DBException("Unable to read field " + field.getName() + " from object " + object, e);
			} catch (IllegalAccessException e) {
				throw new DBException("Unable to read field " + field.getName() + " from object " + object, e);
			}
		}
		
		return parameters;
	}
	
}
