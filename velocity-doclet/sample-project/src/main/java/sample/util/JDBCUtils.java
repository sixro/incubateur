package sample.util;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class JDBCUtils {

    private JDBCUtils() { }

    public static void toFlatParameters(Map<String, Object> parameters, String key, Object object) {
        if (isComplexObject(object)) {
            try {
                Map<String, Object> fieldMap = (Map<String, Object>) PropertyUtils.describe(object);
                for (Map.Entry<String, Object> fieldEntry : fieldMap.entrySet())
                    toFlatParameters(parameters, key + "." + fieldEntry.getKey(), fieldEntry.getValue());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        } else {
            parameters.put(key, object);
        }
    }

    private static boolean isComplexObject(Object value) {
        // FIXME implementare
        return ! (value instanceof String);
    }

}
