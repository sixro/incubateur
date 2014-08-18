package tabl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Column {

	public Column(String name, Type type) {
		if (name == null || name.trim().length() == 0) throw new IllegalArgumentException("name cannot be null or blank");
		if (type == null) throw new IllegalArgumentException("type cannot be null");
		
		this.name = name;
		this.type = type;
	}
	
	public String name() {
		return name;
	}

	public Type type() {
		return type;
	}

	public boolean isA(Column.Type type) {
		return this.type.equals(type);
	}
	
	public boolean accept(Object value) {
		return type.accept(value);
	}
	
	@Override public int hashCode() {
		return name.hashCode();
	}
	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (! getClass().isAssignableFrom(obj.getClass())) return false;
		
		Column that = (Column) obj;
		return name.equalsIgnoreCase(that.name);
	}
	@Override public String toString() {
		StringBuilder builder = new StringBuilder(name)
			.append("<")
			.append(type.name().charAt(0))
			.append(">");
		return builder.toString();
	}

	private final String name;
	private final Type type;

	public static enum Type {
		
		TEXT, NUMBER, DATETIME, BOOLEAN;

		public boolean accept(Object value) {
			if (value == null) return true;
			return TYPE_TO_JAVA_CLASS.get(this).isAssignableFrom(value.getClass());
		}

		@SuppressWarnings("serial")
		private static final Map<Type, Class<?>> TYPE_TO_JAVA_CLASS = new HashMap<Column.Type, Class<?>>() {{ 
			put(Type.TEXT, String.class);
			put(Type.NUMBER, BigDecimal.class);
			put(Type.DATETIME, Date.class);
			put(Type.BOOLEAN, Boolean.class);
		}}; 
		
	};
	
}
