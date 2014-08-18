package tabl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Table<Cs extends Columns> implements Iterable<Row<Cs>>{

	protected Table(Cs columns, Columns keys) {
		if (columns == null || columns.count() == 0) throw new IllegalArgumentException("columns are required");
		if (keys == null || keys.count() == 0) throw new IllegalArgumentException("keys are required");
		if (! columns.contains(keys)) throw new IllegalArgumentException("keys " + keys + " does not seem to be part of columns " +  columns);
		
		this.columns = columns;
		this.keys = keys;
		this.rows = new LinkedList<Row<Cs>>();
	}

	protected Table(Cs columns, Column key) {
		this(columns, new Columns(key));
	}

	public static <Cs extends Columns> Table<Cs> of(Cs columns, Columns keys) {
		return new Table<Cs>(columns, keys);
	}

	public static <Cs extends Columns> Table<Cs> of(Cs columns, Column key) {
		return new Table<Cs>(columns, key);
	}

	public void add(Row<Cs> row) {
		if (contains(row)) throw new IllegalStateException("A row with the same key(s) of " + row + " already exists");
		
		this.rows.add(row);
	}

	public void update(Row<Cs> row) {
		if (! row.contains(keys)) throw new IllegalArgumentException("row has to contains keys " + keys);
		
		int index = findIndex(row);
		if (index == -1)
			throw new IllegalStateException("no row found with keys in " + row + " (keys: " + keys + ")");
		rows.set(index, row);
	}

	public void update(Map<Column, Object> newValues, Map<Column, Object> match) {
		for (Row<Cs> each : rows) {
			if (each.matches(match))
				each.setAll(newValues);
		}
	}

	public void remove(Row<Cs> row) {
		if (! row.contains(keys)) throw new IllegalArgumentException("row has to contains keys " + keys);
		
		int index = findIndex(row);
		if (index == -1)
			throw new IllegalStateException("no row found with keys in " + row + " (keys: " + keys + ")");
		rows.remove(index);
	}
	
	public void remove(Map<Column, Object> match) {
		Iterator<Row<Cs>> it = rows.iterator();
		while (it.hasNext()) {
			Row<Cs> row = it.next();
			if (row.matches(match))
				it.remove();
		}
	}

	public int count() {
		return this.rows.size();
	}

	public Row<Cs> first() {
		if (rows.isEmpty()) throw new IllegalStateException("no rows");
		
		return rows.get(0);
	}

	public Row<Cs> last() {
		if (rows.isEmpty()) throw new IllegalStateException("no rows");
		
		return rows.get(rows.size() -1);
	}

	public boolean contains(Row<Cs> row) {
		if (! row.contains(keys)) throw new IllegalArgumentException("row has to contains keys " + keys);

		for (Row<Cs> each : rows)
			if (each.matches(row, keys)) return true;
		return false;
	}

	public Iterator<Row<Cs>> iterator() {
		return rows.iterator();
	}
	
	private int findIndex(Row<Cs> row) {
		int i = 0;
		int index = -1;
		for (Row<Cs> each : rows) {
			if (each.matches(row, keys)) {
				if (index != -1)
					throw new IllegalStateException("too many rows match keys in " + row + " (keys: " + keys + ")");
				index = i;
			}
			
			i++;
		}
		return index;
	}

	protected final Cs columns;
	protected final Columns keys;
	
	private final List<Row<Cs>> rows;
	
}
