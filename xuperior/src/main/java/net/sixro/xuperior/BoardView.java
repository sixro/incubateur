package net.sixro.xuperior;

import java.util.*;

import net.sixro.android.LogUtils;
import android.content.Context;
import android.graphics.*;
import android.util.Log;
import android.view.View;

public class BoardView extends View {

	private static final String TAG = LogUtils.toTag(Xuperior.TAG, BoardView.class.getSimpleName());

	private final List<OnSizeChangeListener> onSizeChangeListeners;
	
	private final Map<Integer, int[]> pointers;
	
	public BoardView(Context context) {
		super(context);
	
		this.onSizeChangeListeners = new LinkedList<OnSizeChangeListener>();
		this.pointers = new HashMap<Integer, int[]>();
	}

	public void addOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
		this.onSizeChangeListeners.add(onSizeChangeListener);
	}
	
	public void removeOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
		this.onSizeChangeListeners.remove(onSizeChangeListener);
	}
	
	public void drawPointer(int pointerID, int buttonX, int buttonY, int toneWidth, int toneHeight) {
		int[] data = new int[]{ buttonX, buttonY, toneWidth, toneHeight };
		pointers.put(pointerID, data);
		
		invalidate();
	}

	public void clearPointer(int pointerID) {
		pointers.remove(pointerID);
		
		invalidate();
	}


	// ==  View  ==================================================

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		Paint paint = new Paint();
		int color = getContext().getResources().getColor(R.color.main);
		paint.setColor(color);
		
		for (Map.Entry<Integer, int[]> entry : pointers.entrySet()) {
			int[] data = entry.getValue();
			int x = data[0];
			int y = data[1];
			int width = data[2];
			int height = data[3];
			canvas.drawRect(new Rect(x *width, y *height, (x+1) *width, (y+1) *height), paint);
		}
	}

	@Override
	protected void onSizeChanged(final int w, final int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		
		if (LogUtils.isDebugEnabled(TAG))
			Log.d(TAG, "[onSizeChanged] width: " + w + ", height: " + h);
		
		Runnable notifier = new Runnable() {
			@Override
			public void run() {
				for (OnSizeChangeListener listener : onSizeChangeListeners) {
					try { listener.onSizeChange(w, h); }
					catch (Throwable t) {
						Log.e(TAG, "Unable to notify size changes", t);
					}
				}
			}
		};
		Thread thread = new Thread(notifier, "OnSizeChange :: notifier");
		thread.start();
	}

}
