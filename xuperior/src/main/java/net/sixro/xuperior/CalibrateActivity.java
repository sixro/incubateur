package net.sixro.xuperior;

import net.sixro.android.*;
import android.app.Activity;
import android.content.*;
import android.content.SharedPreferences.*;
import android.os.Bundle;
import android.preference.*;
import android.util.Log;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class CalibrateActivity extends Activity implements Compass.Listener, OnSharedPreferenceChangeListener  {

	private static final int UNDEFINED = 999;

	private static final String TAG = LogUtils.toTag(Xuperior.TAG, MainActivity.class.getSimpleName());

	public static final String KEY_COMPASS_CALIBRATION = "pref_compass_calibration";
	
	private Compass compass;
	private int currentAzimut;

	private TextView txtCurrentCompassAzimut;
	private TextView txtSavedCompassAzimut;

	protected void onSaveButtonClick(View view) {
		//txtSavedCompassAzimut.setText(Integer.toString(currentAzimut));
		
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
		Editor editor = preferences.edit();
		editor.putInt(KEY_COMPASS_CALIBRATION, currentAzimut);
		editor.commit();
	}

	
	// ==  Compass.Listener  ======================================

	@Override
	public void onAzimutChange(int azimut) {
		currentAzimut = azimut;
		txtCurrentCompassAzimut.setText(Integer.toString(currentAzimut));
	}

	@Override
	public void onPitchChange(int pitch) { }

	@Override
	public void onRollChange(int roll) { }

	
	// ==  Activity  ==============================================

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "[onCreate]");
		
		compass = new Compass(this);
		
		setContentView(R.layout.calibrate);
		
		txtCurrentCompassAzimut = (TextView) findViewById(R.id.txtCurrentCompassAzimut);
		txtSavedCompassAzimut = (TextView) findViewById(R.id.txtSavedCompassAzimut);

		Button btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				onSaveButtonClick(view);
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "[onResume]");

		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
		preferences.registerOnSharedPreferenceChangeListener(this);

		compass.addListener(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "[onPause]");
		
		compass.removeListener(this);
		
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
		preferences.unregisterOnSharedPreferenceChangeListener(this);
	}

	
	// ==  OnSharedPreferenceChangeListener  ======================
	
	@Override
	public void onSharedPreferenceChanged(SharedPreferences preferences, String key) {
		if (key.equals(KEY_COMPASS_CALIBRATION)) {
			int savedCompassAzimut = preferences.getInt(key, UNDEFINED);
			
			if (LogUtils.isDebugEnabled(TAG))
				Log.d(TAG, "[onSharedPreferenceChanged] saved compass azimut is now " + savedCompassAzimut);
			
			if (savedCompassAzimut != UNDEFINED)
				txtSavedCompassAzimut.setText(Integer.toString(savedCompassAzimut));
        }
	}

}
