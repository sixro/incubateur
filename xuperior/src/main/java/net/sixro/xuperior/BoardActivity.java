package net.sixro.xuperior;

import net.sixro.android.*;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.*;
import android.view.View.OnTouchListener;

/**
 * Represents the activity controlling the <i>board</i> of <b>Xuperior</b>.
 */
public class BoardActivity extends Activity implements OnTouchListener, OnSizeChangeListener, Compass.Listener {

	private static final String TAG = LogUtils.toTag(Xuperior.TAG, BoardActivity.class.getSimpleName());
	
	public static final int MAX_TOUCHES = 5;
	
	private static final float MAX_VOLUME_TOUCH_SIZE = 0.17f;
	
	private static final float TONE_C5 = 523.25f;
	private static final float TONE_B4 = 493.88f;
	private static final float TONE_A4 = 440.00f;
	private static final float TONE_G4 = 392.00f;
	private static final float TONE_F4 = 349.23f;
	private static final float TONE_E4 = 329.63f;
	private static final float TONE_D4 = 293.66f;
	private static final float TONE_C4 = 261.63f;
	private static final float TONE_B3 = 246.94f;
	private static final float TONE_A3 = 220.00f;
	private static final float TONE_G3 = 196.00f;
	private static final float TONE_F3 = 174.61f;

	private ViewGroup boardContainer;
	private BoardView boardView;
	private int boardWidth;
	private int boardHeight;
	private int toneWidth;
	private int toneHeight;
	
	private Compass compass;
	private int compassCalibration;
	
	private Synthesizer synthesizer;

	
	// ==  OnSizeChangeListener  ==================================

	@Override
	public void onSizeChange(int width, int height) {
		boardWidth = width;
		boardHeight = height;
		
		// NOTE we have a grid of 3 x 6. Following is a textual representation containing tones
		//       in the calibrated position:
		//   [A4][B4][C5]
		//   [E4][F4][G4]
		//   [  ][  ][  ] <- this row does not have tones
		//   [  ][  ][D4] <- this row does not have tones for some grid cell
		//   [  ][B3][C4]
		//   [F3][G3][A3]
		toneWidth = boardWidth / 3;
		toneHeight = boardHeight / 6;
	}

	
	// ==  TouchListener  =========================================

	public boolean onTouch(View view, MotionEvent event) {
		if (view.getId() != R.id.board)
			return false;
		if (boardWidth == 0 || boardHeight == 0)
			return false;
		
		int touchAction = event.getActionMasked();
		
		boolean handled = false;
		switch (touchAction) {
			case MotionEvent.ACTION_DOWN:
			case MotionEvent.ACTION_POINTER_DOWN: {
					handlePointerDownOrMove(event, boardWidth, boardHeight);
				}
				handled = true;
				break;
			case MotionEvent.ACTION_MOVE: {
					for (int pointerIndex = 0; pointerIndex < event.getPointerCount(); pointerIndex++) {
						handlePointerDownOrMove(event, boardWidth, boardHeight, pointerIndex);
					}
				}
				handled = true;
				break;
			case MotionEvent.ACTION_UP:
			case MotionEvent.ACTION_POINTER_UP:
			case MotionEvent.ACTION_CANCEL: {
					int pointerIndex = event.getActionIndex();
					int pointerID = event.getPointerId(pointerIndex);

					boardView.clearPointer(pointerID);

					String fingerAsText = "#" + pointerID + " " + ((int) event.getX(pointerIndex)) + ":" + ((int) event.getY(pointerIndex) + ", size: " + event.getSize(pointerIndex));
					Log.d(TAG, "[Touch event <" + TouchUtils.actionMaskedToString(event) + ">] " + fingerAsText);

					synthesizer.tone(pointerID, 0);
					synthesizer.volume(pointerID, 0);

					if (LogUtils.isDebugEnabled(TAG))
						Log.d(TAG, "[" + pointerID + "] tone: " + synthesizer.tone(pointerID) + ", volume: " + synthesizer.volume(pointerID));
				}
				handled = true;
				break;
			default:
				// nothing to do
				break;
		}

		return handled;
	}

	private void handlePointerDownOrMove(MotionEvent event, int boardWidth, int boardHeight) {
		handlePointerDownOrMove(event, boardWidth, boardHeight, event.getActionIndex());
	}

	private void handlePointerDownOrMove(MotionEvent event, int boardWidth, int boardHeight, int pointerIndex) {
		float tone = toTone(event, boardWidth, boardHeight, pointerIndex);
		int volume = toVolume(event, pointerIndex);

		int pointerID = event.getPointerId(pointerIndex);
		String fingerAsText = "#" + pointerID + " " + ((int) event.getX(pointerIndex)) + ":" + ((int) event.getY(pointerIndex) + ", size: " + event.getSize(pointerIndex));
		Log.d(TAG, "[Touch event <" + TouchUtils.actionMaskedToString(event) + ">] " + fingerAsText);
		
		synthesizer.tone(pointerID, tone);
		synthesizer.volume(pointerID, volume);
		
		if (LogUtils.isDebugEnabled(TAG))
			Log.d(TAG, "[" + pointerID + "] tone: " + synthesizer.tone(pointerID) + ", volume: " + synthesizer.volume(pointerID));

		// NOTE: the tone is 0 when the pressed button does not match with a note...
		if (tone != 0f) {
			float x = event.getX(pointerIndex);
			float y = event.getY(pointerIndex);
			int buttonX = (int) (x / toneWidth);
			int buttonY = (int) (y / toneHeight);
			boardView.drawPointer(event.getPointerId(pointerIndex), buttonX, buttonY, toneWidth, toneHeight);
		}
	}

	private int toVolume(MotionEvent event, int pointerIndex) {
		float size = event.getSize(pointerIndex);
		int volume = (int) ((size  * 100) / MAX_VOLUME_TOUCH_SIZE);
		return volume;
	}

	private float toTone(MotionEvent event, int boardWidth, int boardHeight, int pointerIndex) {
		float x = event.getX(pointerIndex);
		float y = event.getY(pointerIndex);
		int buttonX = (int) (x / toneWidth);
		int buttonY = (int) (y / toneHeight);
		
		float tone = 0;
		switch (buttonY) {
			case 0:
				switch (buttonX) {
					case 0: 
						tone = TONE_A4;
						break;
					case 1:
						tone = TONE_B4;
						break;
					default:
						tone = TONE_C5;
						break;
				}
				break;
			case 1:
				switch (buttonX) {
					case 0: 
						tone = TONE_E4;
						break;
					case 1:
						tone = TONE_F4;
						break;
					default:
						tone = TONE_G4;
						break;
				}
				break;
			case 3:
				switch (buttonX) {
					case 0: 
					case 1:
						break;
					default:
						tone = TONE_D4;
						break;
				}
				break;
			case 4:
				switch (buttonX) {
					case 0: 
						break;
					case 1:
						tone = TONE_B3;
						break;
					default:
						tone = TONE_C4;
						break;
				}
				break;
			case 5:
				switch (buttonX) {
					case 0: 
						tone = TONE_F3;
						break;
					case 1:
						tone = TONE_G3;
						break;
					default:
						tone = TONE_A3;
						break;
				}
				break;
			default:
				break;
		}
		return tone;
	}


	// ==  Compass.Listener  ======================================

	@Override
	public void onAzimutChange(int azimut) {
		int playerRotaionInDegrees = playerRotation(azimut, compassCalibration);
		// NOTE this value is obtaining doing 440 Hz / 60 degrees, so in order
		//      to obtain a change in the octave, the player need to rotate of
		//      60 degrees
		float pitchRaiseInHz = playerRotaionInDegrees * 7.3333333f;

		if (LogUtils.isDebugEnabled(TAG))
			Log.d(TAG, "[onAzimutChange] player rotation: " + playerRotaionInDegrees + "° (azimut: " + azimut + ", compass calibration: " + compassCalibration + ") => pitch raise (in Hz): " + pitchRaiseInHz);
		
		synthesizer.raisePitch(pitchRaiseInHz);
		
//		int octave = (int) azimut / 40;
//		synthesizer.octave(octave);
	}


	static int playerRotation(int azimut, int compassCalibration) {
		int playerRotaionInDegrees = azimut - compassCalibration;
		if (playerRotaionInDegrees < -180)
			playerRotaionInDegrees = 360 + playerRotaionInDegrees;
		if (playerRotaionInDegrees > 180)
			playerRotaionInDegrees = 360 - playerRotaionInDegrees;
		return playerRotaionInDegrees;
	}

	@Override
	public void onPitchChange(int pitch) {
//		if (LogUtils.isDebugEnabled(TAG))
//			Log.d(TAG, "[onPitchChange] " + pitch);
	}

	@Override
	public void onRollChange(int roll) {
//		if (LogUtils.isDebugEnabled(TAG))
//			Log.d(TAG, "[onRollChange] " + roll);
	}


	// ==  Activity  ==============================================
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "[onCreate]");

		UIUtils.toFullscreen(this);
		UIUtils.disableScreenSaver(this);
		
		setContentView(R.layout.board);

		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
		compassCalibration = preferences.getInt(CalibrateActivity.KEY_COMPASS_CALIBRATION, 0);

		compass = new Compass(this);
		
		// NOTE: need at least android-17 (4.2.2+)
//		AudioManager audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
//		String sr = audioManager .getProperty(AudioManager.PROPERTY_OUTPUT_SAMPLE_RATE);
//		String bs = audioManager .getProperty(AudioManager.PROPERTY_OUTPUT_FRAMES_PER_BUFFER);
//		Log.d(TAG, "Sample rate: " + sr + ", Buffer size: " + bs);

		boardContainer = (ViewGroup) findViewById(R.id.board);
		boardView = new BoardView(this);
		boardContainer.addView(boardView);
		//boardContainer.setBackgroundDrawable(new PaintDrawable(UI_BACKGROUND_COLOR));
		boardContainer.setOnTouchListener(this);
		
		int minAudioDeviceBufferSize = Synthesizer.minAudioDeviceBufferSize();
		Log.d(BoardActivity.TAG, "[onCreate] min audio device buffer size: " + minAudioDeviceBufferSize);
		// PAY ATTENTION: we can reduce the size of the buffer used to write audio data
		//                but we cannot create an AudioTrack (see above) with a number
		//                of bytes minor than the value obtained by AudioTrack.getMinBufferSize
		//                else the application crashes
		int audioBufferSize = preferredAudioBufferSize(minAudioDeviceBufferSize);

		synthesizer = new Synthesizer(audioBufferSize, MAX_TOUCHES);
		synthesizer.play();
	}

//	@Override
//	protected void onPostCreate(Bundle savedInstanceState) {
//		super.onPostCreate(savedInstanceState);
//		
//		if (LogUtils.isDebugEnabled(TAG))
//			Log.d(TAG, "[onPostCreate] width: " + boardView.getWidth() + ", height: " + boardView.getHeight());
//	}

	private int preferredAudioBufferSize(int minAudioDeviceBufferSize) {
		int audioBufferSize = 0;
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
		boolean useCustomBufferSize = preferences.getBoolean(SettingsActivity.KEY_AUDIO_USE_CUSTOM_BUFFER_SIZE, false);
		if (useCustomBufferSize) {
			String bufferSizeAsText = preferences.getString(SettingsActivity.KEY_AUDIO_CUSTOM_BUFFER_SIZE, Integer.toString(minAudioDeviceBufferSize));
			audioBufferSize = Integer.parseInt(bufferSizeAsText);
			Log.i(TAG, "[preferredAudioBufferSize] using custom buffer size: " + audioBufferSize);
		} else {
			Log.i(TAG, "[preferredAudioBufferSize] using min audio device buffer size: " + minAudioDeviceBufferSize);
			audioBufferSize = minAudioDeviceBufferSize;
		}
		return audioBufferSize;
	}

	@Override
	protected void onResume() {
		super.onResume();

		Log.i(TAG, "[onResume] registering compass listener(s)...");
		compass.addListener(this);
		
		boardView.addOnSizeChangeListener(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		Log.i(TAG, "[onPause] unregistering compass listener(s)...");
		compass.removeListener(this);
		
		boardView.removeOnSizeChangeListener(this);
	}
	
	@Override
	protected void onDestroy() {
		Log.i(TAG, "[onDestroy] stopping synthesizer...");
		
		synthesizer.stop();
		
		UIUtils.enableScreenSaver(this);
		
		super.onDestroy();
	}
	
}
