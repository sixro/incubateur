package net.sixro.android;

import java.util.*;

import android.app.Activity;
import android.content.Context;
import android.hardware.*;
import android.util.Log;

/**
 * Represents a compass.
 * 
 * <p>
 * Credits have to be done to <a href="http://www.codingforandroid.com/2011/01/using-orientation-sensors-simple.html" >this post</a>.
 * </p>
 */
public class Compass implements SensorEventListener {

	private static final String TAG = Compass.class.getSimpleName();

	/**
	 * time smoothing constant for low-pass filter
	 * 0 ≤ alpha ≤ 1 ; a smaller value basically means more smoothing
	 * See: http://en.wikipedia.org/wiki/Low-pass_filter#Discrete-time_realization
	 */
	private static final float LOWPASS_FILTER_ALPHA = 0.10f;

	@SuppressWarnings("unused")
	private final Activity activity;

	private final List<Compass.Listener> listeners;
	
	private final SensorManager sensorManager;
	private final Sensor accelerometerSensor;
	private final Sensor magnetometerSensor;
	
	private float[] gravity;
	private float[] geomagnetic;
	private int azimut;
	private int pitch;
	private int roll;

	public Compass(Activity activity) {
		super();
		this.activity = activity;
		this.listeners = new LinkedList<Compass.Listener>();
		
		sensorManager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
		if (LogUtils.isDebugEnabled(TAG)) {
			List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
			for (Sensor sensor : sensorList)
				Log.d(TAG, "[onCreate] ... found sensor type: " + SensorUtils.typeToString(sensor));
		}
	    accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	    magnetometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
	    
	    // NOTE this is a trick to let the compass do the first notification...
	    this.azimut = 999;
	    this.pitch  = 999;
	    this.roll   = 999;
	}

	public synchronized void addListener(Compass.Listener listener) {
		this.listeners.add(listener);

		// NOTE if the size of listeners is 1 it means that Compass is not registered
		//      to sensors (see removeListener) so we register it.
		//      If you add more listeners it won't register anymore because of the check "== 1"
		if (listeners.size() == 1) {
			sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_GAME);
			sensorManager.registerListener(this, magnetometerSensor, SensorManager.SENSOR_DELAY_GAME);
		}
	}
	
	public synchronized void removeListener(Compass.Listener listener) {
		this.listeners.remove(listener);

		// NOTE if we do not have listeners anymore, we can unregister sensors
		if (listeners.isEmpty())
			sensorManager.unregisterListener(this);
	}

	/**
	 * @see http://en.wikipedia.org/wiki/Low-pass_filter#Algorithmic_implementation
	 * @see http://developer.android.com/reference/android/hardware/SensorEvent.html#values
	 */
	protected float[] lowPass( float[] input, float[] output ) {
	    if ( output == null ) return input;
	     
	    for ( int i=0; i<input.length; i++ ) {
	        output[i] = output[i] + LOWPASS_FILTER_ALPHA * (input[i] - output[i]);
	    }
	    return output;
	}
	
	
	// ==  SensorListener  ========================================

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) { }

	@Override
	public void onSensorChanged(SensorEvent event) {
		synchronized (this) {
			switch (event.sensor.getType()) {
			case Sensor.TYPE_ACCELEROMETER:
				gravity = lowPass(event.values.clone(), gravity);
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				geomagnetic = lowPass(event.values.clone(), geomagnetic);
				break;
			default:
				// nothing to do
				break;
			}
			
			if (gravity == null || geomagnetic == null)
				return;
			
			float R[] = new float[9];
			if (SensorManager.getRotationMatrix(R, null, gravity, geomagnetic)) {
				float[] R_remap = new float[9];
				if (SensorManager.remapCoordinateSystem(R, SensorManager.AXIS_Y, SensorManager.AXIS_MINUS_X, R_remap)) {
					float orientation[] = new float[3];
					SensorManager.getOrientation(R_remap, orientation);
					
					// orientation contains: azimut, pitch and roll
					float[] orientationInDegrees = new float[orientation.length];
					for (int i = 0; i < orientation.length; i++)
						orientationInDegrees[i] = (float) Math.toDegrees(orientation[i]);
					
					final int newAzimut = (int) orientationInDegrees[0];
					final int newPitch  = (int) orientationInDegrees[1];
					final int newRoll   = (int) orientationInDegrees[2];
					
					if (LogUtils.isDebugEnabled(TAG))
						Log.d(TAG, "[onSensorChanged] azimut (new: " + newAzimut + ", current: " + azimut + ")");
					
					final boolean azimutChanged = newAzimut != azimut;
					final boolean pitchChanged  = newPitch != pitch;
					final boolean rollChanged   = newRoll != roll;
					for (Compass.Listener listener : listeners) {
						if (azimutChanged) {
							try { listener.onAzimutChange(newAzimut); }
							catch (Throwable t) {
								Log.e(TAG, "Unable to notify new azimut", t);
							}
						}
						if (pitchChanged) {
							try { listener.onPitchChange(newPitch); }
							catch (Throwable t) {
								Log.e(TAG, "Unable to notify new pitch", t);
							}
						}
						if (rollChanged) {
							try { listener.onRollChange(newRoll); }
							catch (Throwable t) {
								Log.e(TAG, "Unable to notify new roll", t);
							}
						}
					}
					
					if (azimutChanged)
						azimut = newAzimut;
					if (newPitch != pitch)
						pitch = newPitch;
					if (newRoll != roll)
						roll = newRoll;
				}
			}
		}
	}

	public static interface Listener {
		
		void onAzimutChange(int azimut);

		void onPitchChange(int pitch);

		void onRollChange(int roll);

	}
	
}
