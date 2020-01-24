package com.github.sixro.minihabits.core.infrastructure.libgdx;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.*;

/**
 * Represents a {@link Dialog} where the result is observable.
 * 
 * @see ResultListener
 */
public class ObservableDialog extends Dialog {

	private final List<ResultListener> listeners;
	
	public ObservableDialog(String title, Skin skin) {
		super(title, skin);
		this.listeners = new LinkedList<ObservableDialog.ResultListener>();
	}

	public ObservableDialog(String title, Skin skin, String windowStyleName) {
		super(title, skin, windowStyleName);
		this.listeners = new LinkedList<ObservableDialog.ResultListener>();
	}

	public ObservableDialog(String title, WindowStyle windowStyle) {
		super(title, windowStyle);
		this.listeners = new LinkedList<ObservableDialog.ResultListener>();
	}

	public void addResultListener(ResultListener listener) {
		this.listeners.add(listener);
	}
	
	public void removeResultListener(ResultListener listener) {
		this.listeners.remove(listener);
	}
	
	@Override
	protected final void result(final Object object) {
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				for (ResultListener l: listeners)
					l.onDialogResult(ObservableDialog.this, object);
			}
		});
	}

	/**
	 * Represents a listener of results obtained in an {@link ObservableDialog}.
	 */
	public static interface ResultListener {

		void onDialogResult(ObservableDialog dialog, Object resultObject);
		
	}
	
}
