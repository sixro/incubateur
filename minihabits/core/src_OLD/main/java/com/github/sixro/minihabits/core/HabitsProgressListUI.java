package com.github.sixro.minihabits.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.github.sixro.minihabits.core.domain.*;

public class HabitsProgressListUI extends VerticalGroup implements AllMiniHabits.Listener {

	private static final String TAG = HabitsProgressListUI.class.getSimpleName();
	
	private final Skin skin;
	private final AllMiniHabits allMiniHabits;

	public HabitsProgressListUI(Skin skin, AllMiniHabits allMiniHabits) {
		super();
		this.skin = skin;
		this.allMiniHabits = allMiniHabits;
		this.allMiniHabits.addListener(this);
		
		createUI();
	}

	@Override
	public void onAdd(AllMiniHabits all) {
		createUI();
	}

	private void createUI() {
		Gdx.app.log(TAG, "Creating UI...");
		setDebug(true);

		clearChildren();
		for (MiniHabit each: allMiniHabits) {
			String habitName = each.label();
			Gdx.app.log(TAG, "... adding habit " + habitName + "...");
			Label button = new Label(each.daysInProgress() + " " + habitName, skin);
			addActor(button);
			Gdx.app.log(TAG, this.toString());
		}
	}
	
}
