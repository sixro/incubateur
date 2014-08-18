package tabl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.text.StrSubstitutor;

public class Columns implements Iterable<Column> {

	public Columns(Column... columns) {
		super();
		this.columns = columns;
	}

	public Columns(Collection<Column> columns) {
		this(columns.toArray(new Column[]{ }));
	}

	public boolean contains(Column column) {
		return ArrayUtils.contains(columns, column);
	}

	public boolean contains(Columns columns) {
		for (Column each : columns) {
			if (! contains(each)) return false;
		}
		return true;
	}
	
	public Iterator<Column> iterator() {
		List<Column> list = new ArrayList<Column>(columns.length);
		for (Column each : columns) list.add(each);
		return list.iterator();
	}

	public int count() {
		return columns.length;
	}
	
	public String namesJoint(String separator) {
		List<String> list = new ArrayList<String>(columns.length);
		for (Column each : columns) list.add(each.name());
		return StringUtils.join(list, separator);
	}
	
	public String namesJoint(String template, String separator) {
		List<String> list = new ArrayList<String>(columns.length);
		Map<String, Object> placeholders = new HashMap<String, Object>();
		for (Column each : columns) {
			placeholders.put("name", each.name());
			String text = StrSubstitutor.replace(template, placeholders);
			list.add(text);
		}
		return StringUtils.join(list, separator);
	}

	public Columns exclude(Columns toexclude) {
		List<Column> remaining = new ArrayList<Column>(columns.length);
		for (Column each : columns) {
			if (toexclude.contains(each)) continue;
			remaining.add(each);
		}
		return new Columns(remaining.toArray(new Column[]{ }));
	}

	@Override public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (! getClass().isAssignableFrom(obj.getClass())) return false;
		
		Columns that = (Columns) obj;
		return Arrays.deepEquals(columns, that.columns);
	}

	@Override public String toString() {
		return new StringBuilder(getClass().getSimpleName())
			.append(Arrays.toString(columns))
			.toString();
	}

	private final Column[] columns;

}
