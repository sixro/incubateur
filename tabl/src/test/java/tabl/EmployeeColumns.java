package tabl;

class EmployeeColumns extends Columns {

	public static final Column SERIAL_NUMBER = new Column("serial_number", Column.Type.TEXT);
	public static final Column DATE_OF_EMPLOYMENT = new Column("date_of_employment", Column.Type.DATETIME);
	public static final Column LEVEL = new Column("level", Column.Type.NUMBER);
	public static final Column PROJECT_MANAGER = new Column("project_manager", Column.Type.BOOLEAN);
	
	public static final EmployeeColumns DEFINITION = new EmployeeColumns();
	
	private EmployeeColumns() {
		super(SERIAL_NUMBER, DATE_OF_EMPLOYMENT, LEVEL, PROJECT_MANAGER);
	}

}
