package tabl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;

import org.apache.commons.lang.StringUtils;

public class DBTable<Cs extends Columns> extends Table<Cs> {

	protected DBTable(Cs columns, Columns keys, Connection connection, String from) {
		super(columns, keys);
		this.connection = connection;
		this.from = from;
	}

	protected DBTable(Cs columns, Column key, Connection connection, String from) {
		this(columns, new Columns(key), connection, from);
	}

	public static <Cs extends Columns> DBTable<Cs> of(Cs columns, Columns keys, Connection connection, String from) {
		return new DBTable<Cs>(columns, keys, connection, from);
	}

	public static <Cs extends Columns> DBTable<Cs> of(Cs columns, Column key, Connection connection, String from) {
		return new DBTable<Cs>(columns, key, connection, from);
	}

	@Override public void add(Row<Cs> row) {
		Columns insertStatementColumns = insertStatementColumns();
		String sql = insertSQL(from, insertStatementColumns);
		PreparedStatement statement = null;
		try {
			try {
				statement = prepareStatement(connection, sql, insertStatementColumns, row);
			} catch (SQLException e) {
				throw new RuntimeException("Unable to prepare statement for insert " + row, e);
			}

			try {
				statement.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Unable to insert row " + row, e);
			}
		} finally {
			if (statement != null)
				try { statement.close(); } catch (SQLException ignore) { }
		}
	}

	@Override public void update(Row<Cs> row) {
		if (! row.contains(keys)) throw new IllegalArgumentException("row has to contains keys " + keys);

		Columns columnsToSet = row.columns().exclude(keys);
		if (columnsToSet.count() == 0) throw new IllegalArgumentException("row has to contains columns to update (obtained " + row + ")");
		
		String sql = updateSQL(from, columnsToSet, keys);
		PreparedStatement statement = null;
		try {
			try {
				statement = prepareStatement(connection, sql, columnsToSet, keys, row);
			} catch (SQLException e) {
				throw new RuntimeException("Unable to prepare statement for update " + row, e);
			}

			try {
				int affected = statement.executeUpdate();
				if (affected == 0)
					throw new IllegalStateException("no row found with keys in " + row + " (keys: " + keys + ")");
			} catch (SQLException e) {
				throw new RuntimeException("Unable to update row " + row, e);
			}
		} finally {
			if (statement != null)
				try { statement.close(); } catch (SQLException ignore) { }
		}
	}

	@Override public void update(Map<Column, Object> newValues, Map<Column, Object> match) {
		if (newValues == null || newValues.size() == 0) throw new IllegalArgumentException("newValues cannot be empty");
		if (match == null || match.size() == 0) throw new IllegalArgumentException("match cannot be empty");
		
		Map<Column, Object> _newValues = supportsSorting(newValues)
			? newValues
			: new LinkedHashMap<Column, Object>(newValues);
		Map<Column, Object> _match = supportsSorting(match)
			? match
			: new LinkedHashMap<Column, Object>(match);
		
		Columns columnsToSet = new Columns(_newValues.keySet());
		Columns columnsToFind = new Columns(_match.keySet());
		
		String sql = updateSQL(from, columnsToSet, columnsToFind);
		PreparedStatement statement = null;
		try {
			try {
				statement = prepareStatement(connection, sql, _newValues, _match);
			} catch (SQLException e) {
				throw new RuntimeException("Unable to prepare statement for update", e);
			}

			try {
				statement.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Unable to update", e);
			}
		} finally {
			if (statement != null)
				try { statement.close(); } catch (SQLException ignore) { }
		}
	}

	@Override public void remove(Row<Cs> row) {
		if (! row.contains(keys)) throw new IllegalArgumentException("row has to contains keys " + keys);

		String sql = deleteSQL(from, keys);
		PreparedStatement statement = null;
		try {
			try {
				statement = prepareStatement(connection, sql, keys, row);
			} catch (SQLException e) {
				throw new RuntimeException("Unable to prepare statement for delete " + row, e);
			}

			try {
				int affected = statement.executeUpdate();
				if (affected == 0)
					throw new IllegalStateException("no row found with keys in " + row + " (keys: " + keys + ")");
			} catch (SQLException e) {
				throw new RuntimeException("Unable to delete row " + row, e);
			}
		} finally {
			if (statement != null)
				try { statement.close(); } catch (SQLException ignore) { }
		}
	}

	@Override public void remove(Map<Column, Object> match) {
		if (match == null || match.size() == 0) throw new IllegalArgumentException("match cannot be empty");

		Map<Column, Object> _match = supportsSorting(match)
			? match
			: new LinkedHashMap<Column, Object>(match);
			
		Columns columnsToFind = new Columns(_match.keySet());

		String sql = deleteSQL(from, columnsToFind);
		PreparedStatement statement = null;
		
		try {
			try {
				statement = prepareStatement(connection, sql, _match);
			} catch (SQLException e) {
				throw new RuntimeException("Unable to prepare statement for delete", e);
			}

			try {
				statement.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Unable to delete", e);
			}
		} finally {
			if (statement != null)
				try { statement.close(); } catch (SQLException ignore) { }
		}
	}
	
	@Override public Row<Cs> first() {
		String sql = selectSQL(from, columns);
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			try {
				statement = prepareStatement(connection, sql);
			} catch (SQLException e) {
				throw new RuntimeException("Unable to prepare statement for select first", e);
			}

			try {
				rs = statement.executeQuery();
				return (rs.next()) ? toRow(rs, columns) : null;
			} catch (SQLException e) {
				throw new RuntimeException("Unable to select first", e);
			}
		} finally {
			if (rs != null)
				try { rs.close(); } catch (SQLException ignore) { }
			if (statement != null)
				try { statement.close(); } catch (SQLException ignore) { }
		}
	}

	@Override public Row<Cs> last() {
		String sql = selectSQL(from, columns);
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			try {
				statement = prepareStatement(connection, sql);
			} catch (SQLException e) {
				throw new RuntimeException("Unable to prepare statement for select first", e);
			}

			try {
				rs = statement.executeQuery();
				Row<Cs> last = null;
				while (rs.next()) last = toRow(rs, columns);
				return last;
			} catch (SQLException e) {
				throw new RuntimeException("Unable to select first", e);
			}
		} finally {
			if (rs != null)
				try { rs.close(); } catch (SQLException ignore) { }
			if (statement != null)
				try { statement.close(); } catch (SQLException ignore) { }
		}
	}

	@Override public int count() {
		String sql = selectCountSQL(from);
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			try {
				statement = prepareStatement(connection, sql);
			} catch (SQLException e) {
				throw new RuntimeException("Unable to prepare statement for select count", e);
			}

			try {
				rs = statement.executeQuery();
				return rs.next() ? rs.getInt(1) : 0; 
			} catch (SQLException e) {
				throw new RuntimeException("Unable to select count", e);
			}
		} finally {
			if (rs != null)
				try { rs.close(); } catch (SQLException ignore) { }
			if (statement != null)
				try { statement.close(); } catch (SQLException ignore) { }
		}
	}

	@Override public boolean contains(Row<Cs> row) {
		if (! row.contains(keys)) throw new IllegalArgumentException("row has to contains keys " + keys);

		String sql = selectCountSQL(from, keys);
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			try {
				statement = prepareStatement(connection, sql, keys, row);
			} catch (SQLException e) {
				throw new RuntimeException("Unable to prepare statement to see if table contains " + row, e);
			}

			try {
				rs = statement.executeQuery();
				return rs.next() ? rs.getInt(1) > 0 : false; 
			} catch (SQLException e) {
				throw new RuntimeException("Unable to see if table contains " + row, e);
			}
		} finally {
			if (rs != null)
				try { rs.close(); } catch (SQLException ignore) { }
			if (statement != null)
				try { statement.close(); } catch (SQLException ignore) { }
		}
	}
	
	@Override public Iterator<Row<Cs>> iterator() {
		String sql = selectSQL(from, columns);
		PreparedStatement statement = null;
		try {
			statement = prepareStatement(connection, sql);
		} catch (SQLException e) {
			throw new RuntimeException("Unable to prepare statement to iterate", e);
		}

		try {
			final ResultSet resultSet = statement.executeQuery();
			return new Iterator<Row<Cs>>() {

				{ moveToNext(); }
				
				@Override public boolean hasNext() {
					return hasNext;
				}

				@Override public Row<Cs> next() {
					Row<Cs> toReturn = row;
					moveToNext();
					return toReturn;
				}

				@Override public void remove() {
					throw new UnsupportedOperationException("remove is not supported");
				}
				
				private void moveToNext() {
					try {
						if (resultSet.next()) {
							hasNext = true;
							row = toRow(resultSet, columns);
						} else {
							hasNext = false;
							try { resultSet.close(); } catch (SQLException ignore) { }
						}
					} catch (SQLException e) {
						throw new RuntimeException("unable to move on next row of ResultSet", e);
					}
				}

				private boolean hasNext;
				private Row<Cs> row;
				
			};
		} catch (SQLException e) {
			throw new RuntimeException("Unable to iterate", e);
		}
	}

	protected Columns insertStatementColumns() {
		return columns;
	}
	
	protected String insertSQL(String table, Columns columns) {
		return new StringBuilder("INSERT INTO ")
			.append(table)
			.append(" (")
			.append(columns.namesJoint(","))
			.append(") VALUES (")
			.append(StringUtils.join(Collections.nCopies(columns.count(), "?"), ","))
			.append(")")
			.toString();
	}
	
	protected String updateSQL(String table, Columns columnsToSet, Columns keys) {
		return new StringBuilder("UPDATE ")
			.append(table)
			.append(" SET ")
			.append(columnsToSet.namesJoint("${name} = ?", ","))
			.append(" WHERE ")
			.append(keys.namesJoint("${name} = ?", ","))
			.toString();
	}

	protected String selectSQL(String from, Columns columns) {
		return new StringBuilder("SELECT ")
			.append(columns.namesJoint(","))
			.append(" FROM ")
			.append(from)
			.toString();
	}

	protected String selectCountSQL(String from) {
		return new StringBuilder("SELECT COUNT(*) FROM ")
			.append(from)
			.toString();
	}
	
	protected String selectCountSQL(String from, Columns keys) {
		return new StringBuilder(selectCountSQL(from))
			.append(" WHERE ")
			.append(keys.namesJoint("${name} = ?", ","))
			.toString();
	}
	
	protected String deleteSQL(String from, Columns keys) {
		return new StringBuilder("DELETE FROM ")
			.append(from)
			.append(" WHERE ")
			.append(keys.namesJoint("${name} = ?", ","))
			.toString();
	}

	protected PreparedStatement prepareStatement(Connection connection, String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}

	protected PreparedStatement prepareStatement(Connection connection, String sql, Columns columns, Row<Cs> row) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql);
		bindParameters(statement, columns, row, 1);
		return statement;
	}

	protected PreparedStatement prepareStatement(Connection connection, String sql, Columns columnsToSet, Columns keys, Row<Cs> row) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql);
		bindParameters(statement, columnsToSet, row, 1);
		bindParameters(statement, keys, row, columnsToSet.count() +1);
		return statement;
	}

	protected PreparedStatement prepareStatement(Connection connection, String sql, Map<Column, Object> newValues, Map<Column, Object> match) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql);
		bindParameters(statement, newValues, 1);
		bindParameters(statement, match, newValues.size() +1);
		return statement;
	}

	protected PreparedStatement prepareStatement(Connection connection, String sql, Map<Column, Object> columnsAndValues) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql);
		bindParameters(statement, columnsAndValues, 1);
		return statement;
	}

	protected void bindParameter(PreparedStatement statement, int parameterIndex, Object value) throws SQLException {
		if (value instanceof Date)
			statement.setTimestamp(parameterIndex, new Timestamp(((Date) value).getTime()));
		else
			statement.setObject(parameterIndex, value);
	}

	protected <C extends Columns> Row<C> toRow(ResultSet rs, C columns) throws SQLException {
		Row<C> row = Row.of(columns);
		for (Column column : columns)
			row.with(column, readValue(rs, column));
		return row;
	}

	protected Object readValue(ResultSet rs, Column column) throws SQLException {
		if (column.isA(Column.Type.NUMBER))
			return rs.getBigDecimal(column.name());
		if (column.isA(Column.Type.DATETIME))
			return rs.getTimestamp(column.name());
		if (column.isA(Column.Type.BOOLEAN))
			return rs.getBoolean(column.name());
		return rs.getString(column.name());
	}
	
	private void bindParameters(PreparedStatement statement, Columns columns, Row<Cs> row, int startingIndex) throws SQLException {
		for (Column column : columns)
			bindParameter(statement, startingIndex++, row.get(column));
	}

	private void bindParameters(PreparedStatement statement, Map<Column, Object> columnsAndValues, int startingIndex) throws SQLException {
		for (Map.Entry<Column, Object> entry : columnsAndValues.entrySet())
			bindParameter(statement, startingIndex++, entry.getValue());
	}

	private boolean supportsSorting(Map<Column, Object> map) {
		return map instanceof LinkedHashMap<?, ?> || map instanceof SortedMap<?, ?>;
	}

	protected final Connection connection;
	protected final String from;

}
