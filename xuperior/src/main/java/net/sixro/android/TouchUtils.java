package net.sixro.android;

import java.util.*;

import android.view.MotionEvent;

/**
 * Represents a set of utilities useful to work with <i>touch</i>.
 */
public class TouchUtils {

	@SuppressWarnings("serial")
	private static final Map<Integer, String> TOUCH_TEXTUAL_ACTIONS = new HashMap<Integer, String>() {{
		put(MotionEvent.ACTION_DOWN,         "DOWN");
		put(MotionEvent.ACTION_POINTER_DOWN, "POINTER_DOWN");
		put(MotionEvent.ACTION_UP,           "UP");
		put(MotionEvent.ACTION_POINTER_UP,   "POINTER_UP");
		put(MotionEvent.ACTION_MOVE,         "MOVE");
		put(MotionEvent.ACTION_CANCEL,       "CANCEL");
	}};

	/**
	 * Returns a textual representation of specified {@link MotionEvent#getActionMasked()}.
	 * 
	 * @param motionEvent a {@link MotionEvent}
	 * @return a text
	 */
	public static String actionMaskedToString(MotionEvent motionEvent) {
		String text = TOUCH_TEXTUAL_ACTIONS.get(motionEvent.getActionMasked());
		if (text == null)
			text = "<unknown>";
		return text;
	}

}
