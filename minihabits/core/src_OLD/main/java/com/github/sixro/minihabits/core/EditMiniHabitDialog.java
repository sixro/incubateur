package com.github.sixro.minihabits.core;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.github.sixro.minihabits.core.util.libgdx.ui.ObservableDialog;

public class EditMiniHabitDialog extends ObservableDialog {

	private TextField tfHabitName;

	public EditMiniHabitDialog(String title, Skin skin, String windowStyleName) {
		super(title, skin, windowStyleName);
		createUI();
	}

	public EditMiniHabitDialog(String title, Skin skin) {
		super(title, skin);
		createUI();
	}

	public EditMiniHabitDialog(String title, WindowStyle windowStyle) {
		super(title, windowStyle);
		createUI();
	}

	private void createUI() {
		setMovable(true);
		
		text("Insert the Mini-Habit name:")
			.button("OK", true)
			.key(Keys.ENTER, true)
			.button("Cancel", false)
			.key(Keys.ESCAPE, false);

		tfHabitName = new TextField("", getSkin());
		tfHabitName.setMessageText("name");

		Table contentTable = getContentTable();
		contentTable.row();
		contentTable.add(tfHabitName).width(135);
	}

	public String getHabitName() {
		return tfHabitName.getText();
	}

}
