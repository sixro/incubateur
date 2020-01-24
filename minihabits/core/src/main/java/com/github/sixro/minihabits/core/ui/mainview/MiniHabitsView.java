package com.github.sixro.minihabits.core.ui.mainview;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.github.sixro.minihabits.core.application.MainController;
import com.github.sixro.minihabits.core.domain.*;

public class MiniHabitsView extends VerticalGroup {

	private static final String TAG = MiniHabitsView.class.getSimpleName();
	
	private final Skin skin;
	private final MainController controller;

	public MiniHabitsView(Skin skin, MainController controller) {
		super();
		this.skin = skin;
		this.controller = controller;
		
		refreshUI();
	}

	public void refreshUI() {
		Gdx.app.log(TAG, "Creating UI...");
		setDebug(true);

		clearChildren();
		for (MiniHabit each: controller.allHabits()) {
			String habitName = each.label();
			Gdx.app.log(TAG, "... adding habit " + habitName + "...");
			Label label = new Label(each.daysInProgress() + " " + habitName, skin);
			label.setAlignment(Align.left);
			addActor(label);
			Gdx.app.log(TAG, this.toString());
		}
	}

}
