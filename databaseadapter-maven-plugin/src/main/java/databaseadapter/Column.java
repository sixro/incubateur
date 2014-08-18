package databaseadapter;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.Validate;

public class Column {

	private final String name;
	private final String remarks;
	private final int dataType;
	private final int columnSize;
	private final int decimalDigits;
	private final boolean nullable;

	public Column(String name, int dataType, int columnSize, int decimalDigits, boolean nullable) {
		this(name, dataType, columnSize, decimalDigits, nullable, "");
	}

	public Column(String name, int dataType, int columnSize, int decimalDigits, boolean nullable, String remarks) {
		Validate.notEmpty(name, "'name' parameter is required");

		this.name = name;
		this.remarks = remarks;
		this.dataType = dataType;
		this.columnSize = columnSize;
		this.decimalDigits = decimalDigits;
		this.nullable = nullable;
	}

	public String getName() {
		return name;
	}

	public String getRemarks() {
		return remarks;
	}

	public int getDataType() {
		return dataType;
	}

	public int getColumnSize() {
		return columnSize;
	}

	public int getDecimalDigits() {
		return decimalDigits;
	}

	public boolean isNullable() {
		return nullable;
	}

	@Override public int hashCode() {
		return name.hashCode();
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (! getClass().isAssignableFrom(obj.getClass())) return false;
		
		Column that = (Column) obj;
		return ObjectUtils.equals(name, that.name);
	}

	@Override public String toString() {
		return name;
	}

}
