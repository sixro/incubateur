package net.sixro.android;

import java.util.*;

import android.hardware.Sensor;

/**
 * Represents a set of utilities useful to work with Android sensors.
 */
public class SensorUtils {

	// NOTE: commented types are not available in current Android APIs
	@SuppressWarnings("serial")
	private static final Map<Integer, String> SENSOR_TEXTUAL_TYPES = new HashMap<Integer, String>() {{
		put(Sensor.TYPE_ACCELEROMETER, "TYPE_ACCELEROMETER");
		put(Sensor.TYPE_ALL, "TYPE_ALL");
//		put(Sensor.TYPE_AMBIENT_TEMPERATURE, "");
//		put(Sensor.TYPE_GAME_ROTATION_VECTOR, "");
//		put(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR, "");
		put(Sensor.TYPE_GRAVITY, "TYPE_GRAVITY");
		put(Sensor.TYPE_GYROSCOPE, "TYPE_GYROSCOPE");
//		put(Sensor.TYPE_GYROSCOPE_UNCALIBRATED, "");
//		put(Sensor.TYPE_HEART_RATE, "");
		put(Sensor.TYPE_LIGHT, "TYPE_LIGHT");
		put(Sensor.TYPE_LINEAR_ACCELERATION, "TYPE_LINEAR_ACCELERATION");
		put(Sensor.TYPE_MAGNETIC_FIELD, "TYPE_MAGNETIC_FIELD");
//		put(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED, "");
		put(Sensor.TYPE_ORIENTATION, "TYPE_ORIENTATION");
		put(Sensor.TYPE_PRESSURE, "TYPE_PRESSURE");
		put(Sensor.TYPE_PROXIMITY, "TYPE_PROXIMITY");
//		put(Sensor.TYPE_RELATIVE_HUMIDITY, "");
		put(Sensor.TYPE_ROTATION_VECTOR, "TYPE_ROTATION_VECTOR");
//		put(Sensor.TYPE_SIGNIFICANT_MOTION, "");
//		put(Sensor.TYPE_STEP_COUNTER, "");
//		put(Sensor.TYPE_STEP_DETECTOR, "");
		put(Sensor.TYPE_TEMPERATURE, "TYPE_TEMPERATURE");
	}};

	private SensorUtils() { }

	/**
	 * Returns a textual representation of specified sensor type.
	 * 
	 * @param sensor a {@link Sensor}
	 * @return a text
	 */
	public static String typeToString(Sensor sensor) {
		String text = SENSOR_TEXTUAL_TYPES.get(sensor.getType());
		if (text == null)
			text = "<unknown>";
		return text;
	}
	
}
