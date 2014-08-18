package tabl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Row<Cs extends Columns> {

	protected Row(Cs columns) {
		this.columns = columns;
		this.values = new LinkedHashMap<Column, Object>();
	}

	public static <Cs extends Columns> Row<Cs> of(Cs columns) {
		return new Row<Cs>(columns);
	}

	public Row<Cs> with(Column column, Object value) {
		if (! columns.contains(column)) throw new IllegalArgumentException("unknown " + column);
		if (! column.accept(value)) throw new IllegalArgumentException("column " + column + " does not support " + value);
		
		values.put(column, value);
		return this;
	}

	public Object get(Column column) {
		if (! columns.contains(column)) throw new IllegalArgumentException("unknown " + column);
		
		return values.get(column);
	}

	public boolean contains(Columns columns) {
		if (! this.columns.contains(columns)) throw new IllegalArgumentException("columns " + columns + " contains unknown column (expected: " + this.columns + ")");
		
		for (Column column : columns) {
			if (! values.containsKey(column)) return false;
		}
			
		return true;
	}

	public boolean matches(Row<Cs> row, Columns keys) {
		for (Column key : keys) {
			Object value = get(key);
			Object thatValue = row.get(key);
			if (! value.equals(thatValue))
				return false;
		}
		return true;
	}

	public boolean matches(Map<Column, Object> match) {
		for (Map.Entry<Column, Object> entry : match.entrySet()) {
			Column column = entry.getKey();
			if (! get(column).equals(entry.getValue()))
				return false;
		}
		return true;
	}

	public void setAll(Map<Column, Object> newValues) {
		for (Column column : newValues.keySet())
			if (! columns.contains(column)) throw new IllegalArgumentException("unknown " + column);

		values.putAll(newValues);
	}

	public Map<Column, Object> getAll(Columns columns) {
		Map<Column, Object> map = new LinkedHashMap<Column, Object>();
		for (Column column : columns) map.put(column, get(column));
		return map;
	}

	public Columns columns() {
		Set<Column> keySet = values.keySet();
		return new Columns(keySet.toArray(new Column[]{ }));
	}

	@Override public int hashCode() {
		return values.hashCode();
	}

	@SuppressWarnings("unchecked")
	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (! getClass().isAssignableFrom(obj.getClass())) return false;
		
		Row<Cs> that = (Row<Cs>) obj;
		return values.equals(that.values);
	}

	@Override public String toString() {
		return values.toString();
	}

	private final Cs columns;
	private final Map<Column, Object> values;
	
}
