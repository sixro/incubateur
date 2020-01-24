package com.github.sixro.minihabits.core.ui;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.*;
import com.github.sixro.minihabits.core.application.MainController;
import com.github.sixro.minihabits.core.domain.*;
import com.github.sixro.minihabits.core.infrastructure.libgdx.*;
import com.github.sixro.minihabits.core.infrastructure.libgdx.ObservableDialog.ResultListener;
import com.github.sixro.minihabits.core.ui.mainview.*;

public class MainView extends StagedScreen implements ObservableDialog.ResultListener {

	private final MainController controller;
	
	private transient MiniHabitsView miniHabitsView;

	public MainView(Skin skin, MainController controller) {
		this(skin, newStage(), controller);

		createUI();
	}

	public MainView(Skin skin, Stage stage, MainController controller) {
		super(skin, stage);
		this.controller = controller;
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
				EditMiniHabitView dlg = new EditMiniHabitView("Add Mini-Habit", MainView.this.skin);
				dlg.addResultListener(MainView.this);
				dlg.show(MainView.this.stage);
			}
		});
		
		miniHabitsView = new MiniHabitsView(skin, controller);
		screenContainer.addActor(miniHabitsView);
		screenContainer.addActor(btnAdd);
	}

	@Override
	public void show() {
		super.show();
		
		onShow();
	}

	private void onShow() {
		try {
			DateAtMidnight nextFeedbackDate = controller.nextFeedbackDate(DateAtMidnight.today());
			if (nextFeedbackDate != null)
				askForProgress(nextFeedbackDate);
		} catch (LastFeedbackDateUnavailableException e) {
			// TODO gestire...
		}
	}

	protected void askForProgress(final DateAtMidnight date) {
		final AskForProgressView subview = new AskForProgressView(skin, stage, date, controller.allHabits());
		subview.addResultListener(new ResultListener() {
			@Override
			public void onDialogResult(ObservableDialog dialog, Object resultObject) {
				if (! resultObject.equals(true))
					return;
				
				controller.updateHabitsProgress(subview.flaggedMiniHabits(), date);
				miniHabitsView.refreshUI();
				
				onShow();
			}
		});
		subview.show(MainView.this.stage);
	}

	@Override
	public void onDialogResult(ObservableDialog dialog, Object resultObject) {
		boolean confirmed = (Boolean) resultObject;
		if (confirmed) {
			String habitName = ((EditMiniHabitView) dialog).getHabitName();
			controller.addHabit(new MiniHabit(habitName));
			miniHabitsView.refreshUI();
		}
	}

}
