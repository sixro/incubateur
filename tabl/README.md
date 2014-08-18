tabl
=====

Represents abstraction of tables in Java.


Motivation
-----------------------
Why do we struggle so hard just in order to hide all data into objects called `*Repository`, `*DAO`, `*Base`, etc...
It seems like tabular representations are not accepted in object oriented world?
__tabl__ enable you to represent tabular data, with columns and provide than production representation of those tabular data through databases, spreadsheets, csv, etc...


Getting started
-----------------------

```java
	...
	// define columns you need in your tabular data
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
	...
	// ... and use in messages of your objects...
	...
	class Employees {
		...
		public static Employees from(Table<EmployeeColumns> table) {
			...
		}
		...
		public void increaseSalary(Table<SalaryPlanColumns> tableOfSalaryPlan) {
			...
		}
		...
		public static void increaseSalary(Table<EmployeeColumns> tableOfEmployees, Table<SalaryPlanColumns> tableOfSalaryPlan) {
			Employees all = Employees.from(tableOfEmployees);
			all.increaseSalary(tableOfSalaryPlan);
		}
		...
		public static void increaseSalary(DataSource dataSource, File salaryPlanXLS) {
			Connection conn = null;
			try {
				conn = dataSource.getConnection();
				Workbook workbook = new HSSFWorkbook(new FileInputStream(salaryPlanXLS));
				Sheet sheet = workbook.getSheet("salary_plan");
				
				Employees.increaseSalary(
					DBTable.of(EmployeeColumns.DEFINITION, EmployeeColumns.SERIAL_NUMBER, conn, "employees" /* a database table */),
					SpreadsheetTable.of(SalaryPlanColumns.DEFINITION, SalaryPlanColumns.ID, sheet, new AreaReference("C4:F29"))
				);
				
				conn.commit();
			} catch (Throwable t) {
				conn.rollback();
			} finally {
				if (conn != null) { try { conn.close(); } catch (SQLException ignore) { } }
			}
		}
		...
	}
	...
	class Employee {
		...
		public static Employee from(Row<EmployeeColumns> row) {
			...
		}
		...
		public void store(Table<EmployeeColumns> table) {
			...
		}
		...
	}
	...
	// ... a row can be defined in this way...
	Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
		.with(EmployeeColumns.SERIAL_NUMBER, "1234")
		.with(EmployeeColumns.LEVEL, BigDecimal.TEN);
	...
	// ... than you can create tables in memory to test quickly your objects...
	Table<EmployeeColumns> table = Table.of(EmployeeColumns.DEFINITION, EmployeeColumns.SERIAL_NUMBER);
	table.add(row);
	...
	// ... or with databases...
	Table<EmployeeColumns> table = DBTable.of(EmployeeColumns.DEFINITION, EmployeeColumns.SERIAL_NUMBER, aConnection(), "employees" /* a database table */);
	table.add(row);
	...
	// ... or with spreadsheets (needs apache-poi)...
	Workbook workbook = new HSSFWorkbook(new FileInputStream(spreadsheet));
	Sheet sheet = workbook.getSheet("xxx");
	table = SpreadsheetTable.of(EmployeeColumns.DEFINITION, EmployeeColumns.SERIAL_NUMBER, sheet, new AreaReference("C4:F29"));
	table.add(row);
	...
	// ... or CSV (to be done)...
	// ... etc...
```

Objects
-------------

* __Table__: is a simple table in memory and is the class to use in order to represent the concept
  * __add__(Row row)
			add a row to this table.
			Throws an error if another row matching key columns exists
  * __update__(Row row)
			update a row in table that match with key columns specified in row parameter.
	        Throws an error if not all key columns are specified or no row exists with same keys
  * __update__(Map&lt;Column, Object&gt; newValues, Map&lt;Column, Object&gt; match)
			update all rows in table that match with 'match' parameter
  * __remove__(Row row)
			remove specified row looking for key columns of specified row.
	        Throws an error if not all key columns are specified or no row exists with same keys
  * __remove__(Map&lt;Column, Object&gt; match)
			remove all rows in table matching 'match' parameter
  * __iterable__
			returns an iterator on all rows
  * __count__
			returns the number of rows
  * __first__
			returns first row
  * __last__
			returns last row
  * __contains__(Row row)
  			returns true if a row with the same keys can be found in the table
  			
* __DBTable__: is the implementation working with databases
  * __add__(Row row)
			add a row to this table.
			Throws an error if another row matching key columns exists
  * __update__(Row row)
			update a row in table that match with key columns specified in row parameter.
	        Throws an error if not all key columns are specified or no row exists with same keys
  * __update__(Map&lt;Column, Object&gt; newValues, Map&lt;Column, Object&gt; match)
			update all rows in table that match with 'match' parameter
  * __remove__(Row row)
			remove specified row looking for key columns of specified row.
	        Throws an error if not all key columns are specified or no row exists with same keys
  * __remove__(Map&lt;Column, Object&gt; match)
			remove all rows in table matching 'match' parameter
  * __iterable__
			returns an iterator on all rows
  * __count__
			returns the number of rows
  * __first__
			returns first row
  * __last__
			returns last row
  * __contains__(Row row)
  			returns true if a row with the same keys can be found in the table

* __SpreadsheetTable__: is the implementation working with spreadsheets
  * __add__(Row row)
			add a row to this table.
			Throws an error if another row matching key columns exists
  * __update__(Row row)
			update a row in table that match with key columns specified in row parameter.
	        Throws an error if not all key columns are specified or no row exists with same keys
  * update(Map&lt;Column, Object&gt; newValues, Map&lt;Column, Object&gt; match)
			update all rows in table that match with 'match' parameter
  * __remove__(Row row)
			remove specified row looking for key columns of specified row.
	        Throws an error if not all key columns are specified or no row exists with same keys
  * remove(Map&lt;Column, Object&gt; match)
			remove all rows in table matching 'match' parameter
  * iterable
			returns an iterator on all rows
  * __count__
			returns the number of rows
  * __first__
			returns first row
  * last
			returns last row
  * contains(Row row)
  			returns true if a row with the same keys can be found in the table


TODO
-------------

* __CSVTable__: is the implementation working with CSV
* __SwingJTableTable__: is the implementation working with Swing JTable

* add tests on DBTable working with Derby using a table where primary key is in needed columns
