package net.sixro.android;

import android.app.Activity;
import android.content.Intent;
import android.view.*;

/**
 * Contains a set of <i>User Interface</i> utilities specific for Android applications.
 */
public class UIUtils {

	private UIUtils() { }
	
	/**
	 * Setup the specified activity as <i>fullscreen</i>.
	 * 
	 * @param activity the activity to setup as <i>fullscreen</i>
	 */
	public static void toFullscreen(Activity activity) {
		activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
		activity.getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN
		);
	}
	
	/**
	 * Disable <i>screen saver</i> on specified activity.
	 * 
	 * @param activity an {@link Activity}
	 */
	public static void disableScreenSaver(Activity activity) {
		activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}

	/**
	 * Enable <i>screen saver</i> on specified activity.
	 * 
	 * @param activity an {@link Activity}
	 */
	public static void enableScreenSaver(Activity activity) {
		activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	
	/**
	 * Start specified activity.
	 * 
	 * @param activityClass the {@link Class} of the activity you want to start
	 * @param currentActivity current activity
	 */
	public static <A extends Activity> void startActivity(Class<A> activityClass, Activity currentActivity) {
		Intent intent = new Intent(currentActivity, activityClass);
		currentActivity.startActivity(intent);
	}
	
}
