package db4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.ClassUtils;

class ToConstructorOrFactoryMethodRowMapper<T> implements RowMapper<T> {

	private static final Log LOG = LogFactory.getLog(ToConstructorOrFactoryMethodRowMapper.class);
	
	private final Class<T> typeClass;

	public ToConstructorOrFactoryMethodRowMapper(Class<T> typeClass) {
		this.typeClass = typeClass;
	}

	@Override
	public T mapRow(ResultSet resultSet, int row) throws SQLException {
		if (LOG.isDebugEnabled()) LOG.debug("mapping row " + row + "...");
		
		ResultSetMetaData metaData = resultSet.getMetaData();
		Object[] values = new Object[metaData.getColumnCount()];
		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			values[i -1] = resultSet.getObject(i);
		}
		
		Class<?>[] parameterTypes = toParameterTypes(values);
		try {
			Constructor<T> constructor = ClassUtils.getConstructorIfAvailable(typeClass, parameterTypes);
			if (constructor != null) {
				T newInstance = constructor.newInstance(values);

				if (LOG.isDebugEnabled()) LOG.debug("... returning " + newInstance);
				return newInstance;
			} else {
				try {
					Method method = ClassUtils.getMethodIfAvailable(typeClass, "valueOf", parameterTypes);
					if (method != null) {
						Object newInstance = method.invoke(null, values);
						T cast = typeClass.cast(newInstance);

						if (LOG.isDebugEnabled()) LOG.debug("... returning " + cast);
						return cast;
					} else {
						throw new DBException("Unable to find a constructor or factory method accepting in input parameters of type " + Arrays.toString(parameterTypes));
					}
				} catch (SecurityException e1) {
					throw new DBException("unable to map row " + row, e1);
				} catch (IllegalAccessException e1) {
					throw new DBException("unable to map row " + row, e1);
				} catch (IllegalArgumentException e1) {
					throw new DBException("unable to map row " + row, e1);
				} catch (InvocationTargetException e1) {
					throw new DBException("unable to map row " + row, e1);
				}
			}
		} catch (SecurityException e) {
			throw new DBException("unable to map row " + row, e);
		} catch (IllegalAccessException e) {
			throw new DBException("unable to map row " + row, e);
		} catch (IllegalArgumentException e) {
			throw new DBException("unable to map row " + row, e);
		} catch (InvocationTargetException e) {
			throw new DBException("unable to map row " + row, e);
		} catch (InstantiationException e) {
			throw new DBException("unable to map row " + row, e);
		}
	}

	protected Class<?>[] toParameterTypes(Object[] values) {
		Class<?>[] parameterTypes = new Class<?>[values.length];
		for (int i = 0; i < values.length; i++) {
			Class<? extends Object> type = values[i].getClass();
			if (Date.class.isAssignableFrom(type))
				type = Date.class;
			
			parameterTypes[i] = type;
		}
		return parameterTypes;
	}

}
