package net.sixro.xuperior;

import java.util.Arrays;

import net.sixro.android.LogUtils;
import net.sixro.util.StringUtils;
import android.content.*;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.*;
import android.util.Log;

public class SettingsActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener {

	public static final String TAG = LogUtils.toTag(Xuperior.TAG, SettingsActivity.class.getSimpleName());

	public static final String KEY_AUDIO_USE_CUSTOM_BUFFER_SIZE = "pref_audio_use_custom_buffer_size";
	public static final String KEY_AUDIO_CUSTOM_BUFFER_SIZE = "pref_audio_custom_buffer_size";
	
	private void initAudioCustomBufferSizes() {
		ListPreference listPrefs = (ListPreference) findPreference("pref_audio_custom_buffer_size");
        if (listPrefs != null) {
    		int[] availableAudioBufferSizes = Synthesizer.availableAudioBufferSizes();
			String[] bufferSizesAsText = StringUtils.toStrings(availableAudioBufferSizes);
    		if (LogUtils.isDebugEnabled(TAG))
    			Log.d(TAG, "[initAvailableCustomBufferSizes] setting availables buffer sizes to: " + Arrays.toString(bufferSizesAsText));
    		
    		listPrefs.setEntries(bufferSizesAsText);
    		listPrefs.setEntryValues(bufferSizesAsText);

    		// force showing of selected value
			int defaultCustomBufferSize = availableAudioBufferSizes[availableAudioBufferSizes.length -1];
			SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
			String customBufferSize = preferences.getString(KEY_AUDIO_CUSTOM_BUFFER_SIZE, Integer.toString(defaultCustomBufferSize));
			listPrefs.setSummary(formatCustomBufferSizeValue(customBufferSize));
        }
	}

	
	// ==  Activity  ==============================================
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "[onCreate]");
		
		addPreferencesFromResource(R.xml.preferences);
		
		initAudioCustomBufferSizes();
	}

	@Override
	protected void onResume() {
	    super.onResume();
	    getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	protected void onPause() {
	    super.onPause();
	    getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
	}
	
	
	// ==  OnSharedPreferenceChangeListener  ======================
	
	@Override
	public void onSharedPreferenceChanged(SharedPreferences preferences, String key) {
		if (key.equals(KEY_AUDIO_CUSTOM_BUFFER_SIZE)) {
            Preference preferenceEntry = findPreference(key);
			preferenceEntry.setSummary(formatCustomBufferSizeValue(preferences.getString(key, "")));
        }
	}

	private static String formatCustomBufferSizeValue(String preferenceValue) {
		return preferenceValue + " bytes";
	}

}
