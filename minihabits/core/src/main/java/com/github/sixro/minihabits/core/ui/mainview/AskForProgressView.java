package com.github.sixro.minihabits.core.ui.mainview;

import java.text.SimpleDateFormat;
import java.util.*;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.github.sixro.minihabits.core.domain.*;
import com.github.sixro.minihabits.core.infrastructure.libgdx.ObservableDialog;

public class AskForProgressView extends ObservableDialog {

	private final Stage stage;
	private final DateAtMidnight date;
	private final Collection<MiniHabit> miniHabits;

	private Map<CheckBox, MiniHabit> miniHabitsByCheckbox;

	public AskForProgressView(Skin skin, Stage stage, DateAtMidnight date, Collection<MiniHabit> miniHabits) {
		super("Progress feedback", skin);
		this.stage = stage;
		this.date = date;
		this.miniHabits = miniHabits;
		this.miniHabitsByCheckbox = new HashMap<CheckBox, MiniHabit>();

		createUI();
	}

	private void createUI() {
		setMovable(true);
		setModal(true);
		
		String message = String.format("Have you done your habits\nin day %s?", SimpleDateFormat.getDateInstance().format(date));
		text(message)
			.button("OK", true)
			.key(Keys.ENTER, true)
			.button("Cancel", false)
			.key(Keys.ESCAPE, false);
		
		Table contentTable = getContentTable();
		contentTable.align(Align.left);
		
		for (MiniHabit each: miniHabits) {
			contentTable.row();
			CheckBox cb = new CheckBox(each.label(), getSkin());
			cb.align(Align.left);
			
			contentTable.add(cb).width(135);

			miniHabitsByCheckbox.put(cb,  each);
		}
		
		pack();
		show(stage);
	}
	
	public Set<MiniHabit> flaggedMiniHabits() {
		Set<MiniHabit> flagged = new LinkedHashSet<MiniHabit>();
		for (Map.Entry<CheckBox, MiniHabit> e: miniHabitsByCheckbox.entrySet()) {
			if (e.getKey().isChecked())
				flagged.add(e.getValue());
		}
		return flagged;
	}

}
