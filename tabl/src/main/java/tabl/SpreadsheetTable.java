package tabl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;

import tabl.Column.Type;

/**
 * Represents a {@link Table} found in a <i>spreadsheet</i>.
 * @author rsimoni
 *
 * @param <Cs>
 */
public class SpreadsheetTable<Cs extends Columns> extends Table<Cs> {

	protected SpreadsheetTable(Cs columns, Columns keys, Sheet sheet, AreaReference area) {
		super(columns, keys);
		if (sheet == null) throw new IllegalArgumentException("sheet is required");
		if (area == null) throw new IllegalArgumentException("area is required");
		if (area.isSingleCell()) throw new IllegalArgumentException("area cannot be a single cell");
		
		this.sheet = sheet;
		this.area = area;
		
		Workbook workbook = sheet.getWorkbook();
		int numberOfNames = workbook.getNumberOfNames();
		if (numberOfNames < columns.count())
			throw new IllegalArgumentException("sheet/workbook does not contain the expected number of columns defined in tables (found " + numberOfNames + ", expected " + columns.count() + ")");
		
		int headerRow = -1;
		this.columnsToCol = new LinkedHashMap<Column, Integer>();
		for (Column column : columns) {
			Name name = workbook.getName(column.name());
			if (name == null)
				throw new IllegalArgumentException("Unable to find a column named '" + column.name() + "' in specified sheet/workbook");

			AreaReference areaOfName = new AreaReference(name.getRefersToFormula());
			if (! areaOfName.isSingleCell()) throw new IllegalArgumentException("name '" + column.name() + "' is sheet/workbook has to be refer to a single cell");
			
			CellReference cellReference = areaOfName.getAllReferencedCells()[0];
			this.columnsToCol.put(column, (int) cellReference.getCol());

			if (headerRow == -1)
				headerRow = cellReference.getRow();
			else
				if (headerRow != cellReference.getRow())
					throw new IllegalArgumentException("names related to columns needs to be on the same row. Check column name '" + column.name() + "'");
		}
		int firstRowOfArea = area.getAllReferencedCells()[0].getRow();
		if (headerRow != firstRowOfArea)
			throw new IllegalArgumentException("row of column names does not seem to match with first row of the specified area (found " + headerRow + ", expected " + firstRowOfArea + ")");
		
		this.headerRow = headerRow;
	}

	public static <Cs extends Columns> SpreadsheetTable<Cs> of(Cs columns, Columns keys, Sheet sheet, AreaReference area) {
		return new SpreadsheetTable<Cs>(columns, keys, sheet, area);
	}

	public static <Cs extends Columns> SpreadsheetTable<Cs> of(Cs columns, Column key, Sheet sheet, AreaReference area) {
		return new SpreadsheetTable<Cs>(columns, new Columns(key), sheet, area);
	}

	@Override public void add(Row<Cs> row) {
		int emptyRowIndex = nextEmptyRowIndex();
		org.apache.poi.ss.usermodel.Row sheetRow = sheet.getRow(emptyRowIndex);
		updateSheetRow(sheetRow, row);
	}

	@Override public void update(Row<Cs> row) {
		if (! row.contains(keys)) throw new IllegalArgumentException("row has to contains keys " + keys);

		org.apache.poi.ss.usermodel.Row sheetRow = findMatchingRow(row.getAll(keys));
		if (sheetRow == null)
			throw new IllegalStateException("no row found with keys in " + row + " (keys: " + keys + ")");
			
		updateSheetRow(sheetRow, row);
	}

	@Override public void remove(Row<Cs> row) {
		if (! row.contains(keys)) throw new IllegalArgumentException("row has to contains keys " + keys);

		org.apache.poi.ss.usermodel.Row sheetRow = findMatchingRow(row.getAll(keys));
		if (sheetRow == null)
			throw new IllegalStateException("no row found with keys in " + row + " (keys: " + keys + ")");
		
		for (Column column : columns) {
			int col = columnsToCol.get(column);
			Cell cell = getCell(sheetRow, col);
			setCellValue(cell, column.type(), null);
		}
	}

	@Override public Row<Cs> first() {
		org.apache.poi.ss.usermodel.Row sheetRow = sheet.getRow(headerRow +1);
		Row<Cs> row = Row.of(columns);
		for (Column column : columns) {
			Cell cell = getCell(sheetRow, columnsToCol.get(column));
			row.with(column, getCellValue(cell, column.type()));
		}
		return row;
	}

	@Override public int count() {
		int emptyRowIndex = nextEmptyRowIndex();
		return emptyRowIndex -1 -headerRow;
	}

	protected int nextEmptyRowIndex() {
		for (int i = headerRow +1; i <= maxRow(); i++) {
			org.apache.poi.ss.usermodel.Row sheetRow = sheet.getRow(i);
			
			boolean found = true;
			for (Column key : keys) {
				int col = columnsToCol.get(key);
				Cell cell = getCell(sheetRow, col);
				String value = cell.getStringCellValue();
				if (! StringUtils.isBlank(value)) {
					found = false;
					break;
				}
				
				if (found)
					return i;
			}
		}
		
		return -1;
	}
	
	protected org.apache.poi.ss.usermodel.Row findMatchingRow(Map<Column, Object> map) {
		int max = maxRow();
		for (int i = headerRow +1; i <= max; i++) {
			org.apache.poi.ss.usermodel.Row sheetRow = sheet.getRow(i);
			if (sheetRow == null)
				return null;
			
			boolean found = true;
			for (Column key : keys) {
				int col = columnsToCol.get(key);
				Cell cell = getCell(sheetRow, col);
				Object cellValue = getCellValue(cell, key.type());
				Object expectedValue = map.get(key);
				if (! cellValue.equals(expectedValue)) { 
					found = false;
					break;
				}
				
				if (found)
					return sheetRow;
			}
		}
		
		return null;
	}

	protected void updateSheetRow(org.apache.poi.ss.usermodel.Row sheetRow, Row<Cs> row) {
		Map<Column, Object> map = row.getAll(row.columns());
		for (Map.Entry<Column, Object> entry : map.entrySet()) {
			Column column = entry.getKey();
			int col = columnsToCol.get(column);
			Cell cell = getCell(sheetRow, col);
			setCellValue(cell, column.type(), entry.getValue());
		}
	}

	protected int maxRow() {
		CellReference[] cellReferences = area.getAllReferencedCells();
		return cellReferences[cellReferences.length -1].getRow();
	}

	protected Cell getCell(org.apache.poi.ss.usermodel.Row row, int column) {
		return row.getCell(column, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK);
	}
	
	protected Object getCellValue(Cell cell, Column.Type expectedType) {
		if (expectedType.equals(Column.Type.TEXT))
			return cell.getStringCellValue();
		if (expectedType.equals(Column.Type.NUMBER))
			return new BigDecimal(cell.getNumericCellValue());
		if (expectedType.equals(Column.Type.DATETIME))
			return cell.getDateCellValue();
		if (expectedType.equals(Column.Type.BOOLEAN))
			return cell.getBooleanCellValue();
		
		throw new IllegalArgumentException("Unknown column type: " + expectedType);
	}

	protected void setCellValue(Cell cell, Column.Type expectedType, Object  value) {
		if (value == null)
			cell.setCellValue((String) null);
		else if (expectedType.equals(Type.TEXT))
			cell.setCellValue((String) value);
		else if (expectedType.equals(Type.NUMBER))
			cell.setCellValue(((BigDecimal) value).doubleValue());
		else if (expectedType.equals(Type.DATETIME))
			cell.setCellValue((Date) value);
		else if (expectedType.equals(Type.BOOLEAN)) {
			cell.setCellValue((Boolean) value);
		} else throw new IllegalArgumentException("Unable to set values of type " + value.getClass().getName());
	}

	private final Sheet sheet;
	private final AreaReference area;
	private final int headerRow;
	private final Map<Column, Integer> columnsToCol;
	
}

