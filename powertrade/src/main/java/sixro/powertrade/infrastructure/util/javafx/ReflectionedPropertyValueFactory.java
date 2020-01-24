package sixro.powertrade.infrastructure.util.javafx;

import org.apache.commons.beanutils.PropertyUtils;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReflectionedPropertyValueFactory<S,T> extends PropertyValueFactory<S,T> {

	public ReflectionedPropertyValueFactory(String property) {
		super(property);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ObservableValue<T> call(CellDataFeatures<S, T> param) {
		String property = getProperty();
		try {
			T value = (T) PropertyUtils.getProperty(param.getValue(), property);
			return new ReadOnlyObjectWrapper<T>(value);
		} catch (Exception e) {
			throw new RuntimeException("Unable to read property '" + property + "' of object " + param.getValue() + " due to a " + e.getClass().getName() + " with message '" + e.getMessage() + "'", e);
		}
	}

}
