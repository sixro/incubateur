package com.github.sixro.minihabits.core;

import java.util.Collections;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.*;
import com.github.sixro.minihabits.core.domain.*;
import com.github.sixro.minihabits.core.util.libgdx.ui.*;

public class MainScreen extends StagedScreen implements ObservableDialog.ResultListener {

	private static final String TAG = MainScreen.class.getSimpleName();
	
	private final AllMiniHabits miniHabits;
	private final Calendar calendar;
	private final FeedbacksStorage feedbacksStorage;

	public MainScreen(Skin skin, AllMiniHabits miniHabits, Calendar calendar, FeedbacksStorage feedbacksStorage) {
		super(skin, newStage());
		this.miniHabits = miniHabits;
		this.calendar = calendar;
		this.feedbacksStorage = feedbacksStorage;
		
		createUI();
	}

	private static Stage newStage() {
		OrthographicCamera camera = new OrthographicCamera();
		Viewport viewport = new ScalingViewport(Scaling.fillY, 320, 533, camera);
		return new Stage(viewport);
	}

	private void createUI() {
		VerticalGroup screenContainer = new VerticalGroup();
		screenContainer.setDebug(true);
		screenContainer.setFillParent(true);
		stage.addActor(screenContainer);
		
		TextButton btnAdd = new TextButton("Add...", skin);
		btnAdd.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				EditMiniHabitDialog dlg = new EditMiniHabitDialog("Add Mini-Habit", MainScreen.this.skin);
				dlg.addResultListener(MainScreen.this);
				dlg.show(MainScreen.this.stage);
			}
			
		});
		
		screenContainer.addActor(new HabitsProgressListUI(skin, miniHabits));
		screenContainer.addActor(btnAdd);
	}

	@Override
	public void show() {
		super.show();
		
		if (feedbacksStorage.existsFeedbackInDate(calendar.yesterday()))
			return;
		
		Gdx.app.log(TAG, "Collecting feedbacks...");

		ObservableDialog dlg = new ObservableDialog("Feedbacks...", skin);
		dlg.addResultListener(new ObservableDialog.ResultListener() {
			
			@Override
			public void onDialogResult(ObservableDialog dialog, Object resultObject) {
				Gdx.app.log(TAG, "... retrieving user input...");

				// TODO leggere feedback da UI	
				MultiFeedback multiFeedback = new MultiFeedback(calendar.yesterday(), Collections.<MiniHabit, Boolean>emptyMap());
				feedbacksStorage.store(multiFeedback);
				updateUI();
			}
		});
		dlg.setMovable(true);
		
		dlg.text("Insert the Mini-Habit name:")
			.button("OK", true)
			.key(Keys.ENTER, true)
			.button("Cancel", false)
			.key(Keys.ESCAPE, false);
		
		dlg.pack();
		dlg.show(stage);
	}

	private void updateUI() {
		Gdx.app.log(TAG, "Updating UI...");
		// TODO impl
		
	}

	@Override
	public void onDialogResult(ObservableDialog dialog, Object resultObject) {
		boolean confirmed = (Boolean) resultObject;
		if (confirmed) {
			String habitName = ((EditMiniHabitDialog) dialog).getHabitName();
			miniHabits.add(new MiniHabit(habitName));
			
			Gdx.app.log(MainScreen.class.getName(), miniHabits.toString());
		}
	}

}
