package databaseadapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

public class Table {

	private final String name;
	private final String remarks;
	
	private List<Column> columns;

	public Table(String name) {
		this(name, null);
	}
	
	public Table(String name, String remarks) {
		Validate.notEmpty(name, "'name' parameter is required");
		
		this.name = name;
		this.remarks = remarks;
		
		this.columns = new LinkedList<Column>();
	}
	
	public String getName() {
		return name;
	}

	public String getRemarks() {
		return remarks;
	}

	public Collection<Column> getColumns() {
		return columns;
	}

	public void setColumns(Collection<Column> columns) {
		this.columns.clear();
		if (columns != null)
			this.columns.addAll(columns);
	}

	public boolean named(String tableName) {
		return name.equalsIgnoreCase(tableName);
	}

	public String columnNamesJointBy(String separator) {
		List<String> names = new ArrayList<String>(columns.size());
		for (Column col : columns) names.add(col.getName());
		return StringUtils.join(names, separator);
	}
	
	@Override public int hashCode() {
		return name.hashCode();
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (! getClass().isAssignableFrom(obj.getClass())) return false;
		
		Table that = (Table) obj;
		return name.equalsIgnoreCase(that.name);
	}

	@Override public String toString() {
		return name;
	}

}
