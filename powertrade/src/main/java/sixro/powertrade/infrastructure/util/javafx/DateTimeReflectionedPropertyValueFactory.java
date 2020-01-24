package sixro.powertrade.infrastructure.util.javafx;

import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

import org.apache.commons.beanutils.PropertyUtils;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;

public class DateTimeReflectionedPropertyValueFactory<S, T extends Temporal> extends PropertyValueFactory<S, String> {

	private final DateTimeFormatter formatter;

	public DateTimeReflectionedPropertyValueFactory(String property, DateTimeFormatter formatter) {
		super(property);
		this.formatter = formatter;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ObservableValue<String> call(CellDataFeatures<S, String> param) {
		String property = getProperty();
		try {
			T value = (T) PropertyUtils.getProperty(param.getValue(), property);
			String formatted = formatter.format(value);
			return new ReadOnlyObjectWrapper<String>(formatted);
		} catch (Exception e) {
			throw new RuntimeException("Unable to read property '" + property + "' of object " + param.getValue() + " due to a " + e.getClass().getName() + " with message '" + e.getMessage() + "'", e);
		}
	}

}
