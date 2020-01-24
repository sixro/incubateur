package com.github.sixro.minihabits.core.ui.mainview;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.github.sixro.minihabits.core.infrastructure.libgdx.ObservableDialog;

public class EditMiniHabitView extends ObservableDialog {

	private TextField tfHabitName;

	public EditMiniHabitView(String title, Skin skin, String windowStyleName) {
		super(title, skin, windowStyleName);
		createUI();
	}

	public EditMiniHabitView(String title, Skin skin) {
		super(title, skin);
		createUI();
	}

	public EditMiniHabitView(String title, WindowStyle windowStyle) {
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
