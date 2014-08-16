package net.sixro.stopeat;

import java.math.*;
import java.text.*;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import android.widget.*;
import android.view.*;
import android.view.View.*;
import android.view.inputmethod.*;
import android.content.*;

import net.sixro.stopeat.util.*;

public class StopEatActivity extends Activity {

	private EditText txtWeight;
	private EditText txtHeight;
	private Button   btnCalculate;
	private TextView txtBMI;

	/**
	 * Called when the activity is first created.
	 * @param savedInstanceState If the activity is being re-initialized after 
	 * previously being shut down then this Bundle contains the data it most 
	 * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtWeight = (EditText) findViewById(R.id.weight);
		txtHeight = (EditText) findViewById(R.id.height);
		btnCalculate = (Button) findViewById(R.id.calculateBmi);
		btnCalculate.setFocusable(true);
		txtBMI = (TextView) findViewById(R.id.bmi);

		btnCalculate.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);

				String weightAsText = txtWeight.getText().toString();
				String heightAsText = txtHeight.getText().toString();
				if (StringUtils.anyBlank(weightAsText, heightAsText))
					return;

				int weight = Integer.parseInt(weightAsText);
				int height = Integer.parseInt(heightAsText);
				double bmi = new BMI().calculate(weight, height);

				BigDecimal bmiAsBigDecimal = BigDecimal.valueOf(bmi);
				DecimalFormat formatter = new DecimalFormat("#.0");
				String bmiAsText = formatter.format(bmi);
				txtBMI.setText(bmiAsText);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(net.sixro.stopeat.R.menu.main, menu);
		return true;
	}

}
