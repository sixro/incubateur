package net.sixro.xuperior;

import net.sixro.android.*;
import android.app.Activity;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private static final String TAG = LogUtils.toTag(Xuperior.TAG, MainActivity.class.getSimpleName());

	private void onStartButtonClick(View view) {
		if (LogUtils.isDebugEnabled(TAG))
			Log.d(TAG, "[onStartButtonClick] starting " + BoardActivity.class.getSimpleName() + " activity...");

		UIUtils.startActivity(BoardActivity.class, this);
	}

	public void onCalibrateButtonClick(View view) {
		if (LogUtils.isDebugEnabled(TAG))
			Log.d(TAG, "[onCalibrateButtonClick] starting " + CalibrateActivity.class.getSimpleName() + " activity...");

		UIUtils.startActivity(CalibrateActivity.class, this);
	}

	public void onSettingsButtonClick(View view) {
		if (LogUtils.isDebugEnabled(TAG))
			Log.d(TAG, "[onSettingsButtonClick] starting " + SettingsActivity.class.getSimpleName() + " activity...");

		UIUtils.startActivity(SettingsActivity.class, this);
	}

	
	// ==  Activity  ==============================================
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "[onCreate]");

		setContentView(R.layout.main);

		if (LogUtils.isDebugEnabled(TAG))
			Log.d(TAG, "[onCreate] setting onClick action to 'START' button...");
		Button btnStart = (Button) findViewById(R.id.btnStart);
		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				onStartButtonClick(view);
			}
		});
		btnStart.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);

		if (LogUtils.isDebugEnabled(TAG))
			Log.d(TAG, "[onCreate] setting onClick action to 'Calibrate' button...");
		Button btnCalibrate = (Button) findViewById(R.id.btnCalibrate);
		btnCalibrate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				onCalibrateButtonClick(view);
			}
		});

		if (LogUtils.isDebugEnabled(TAG))
			Log.d(TAG, "[onCreate] setting onClick action to 'Settings' button...");
		Button btnSettings = (Button) findViewById(R.id.btnSettings);
		btnSettings.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				onSettingsButtonClick(view);
			}
		});
	}
	
}
