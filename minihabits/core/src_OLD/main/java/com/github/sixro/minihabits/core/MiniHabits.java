package com.github.sixro.minihabits.core;

import java.util.Date;

import com.badlogic.gdx.*;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.utils.Json.Serializer;
import com.github.sixro.minihabits.core.domain.*;
import com.github.sixro.minihabits.core.infrastructure.domain.*;
import com.github.sixro.minihabits.core.ui.MainView;
import com.github.sixro.minihabits.core.util.libgdx.PreferencesBasedStorage;
import com.github.sixro.minihabits.core.util.libgdx.text.DateTimeFormatter;

public class MiniHabits extends Game {

	private static final String TAG = MiniHabits.class.getSimpleName();
	
	private final DateTimeFormatter dateTimeFormatter;
	private AllMiniHabits miniHabits;
	private Skin skin;
	
	public MiniHabits(DateTimeFormatter dateTimeFormatter) {
		super();
		this.dateTimeFormatter = dateTimeFormatter;
	}

	@Override
	public void create () {
		Preferences preferences = Gdx.app.getPreferences(MiniHabits.class.getSimpleName());
		
		final PreferencesBasedStorage<MiniHabit> storage = new PreferencesBasedStorage<MiniHabit>(preferences, "minihabits", newJsonForPersistence(), MiniHabit.class);
		miniHabits = new AllMiniHabits(storage.findAll());
		miniHabits.addListener(new AllMiniHabits.Listener() {
			
			@Override
			public void onAdd(AllMiniHabits all) {
				storage.saveAll(all.all());
			}
		});
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		
		Calendar calendar = new JavaBasedCalendar();
		MainScreen mainScreen = new MainScreen(
			skin, 
			miniHabits, 
			calendar, 
			new PreferencesBasedFeedbacksStorage(
				preferences, 
				calendar
			)
		);
		setScreen(mainScreen);
	}

	private Json newJsonForPersistence() {
		Json json = new Json();
		json.setSerializer(MiniHabit.class, new MiniHabitSerializer(dateTimeFormatter));
		return json;
	}

	public static class MiniHabitSerializer implements Serializer<MiniHabit> {

		private static final String ISO8601_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";
		
		private final DateTimeFormatter dateTimeFormatter;
		
		public MiniHabitSerializer(DateTimeFormatter dateTimeFormatter) {
			super();
			this.dateTimeFormatter = dateTimeFormatter;
		}

		@SuppressWarnings("rawtypes")
		@Override
		public void write(Json json, MiniHabit o, Class knownType) {
			json.writeObjectStart();
			json.writeValue("label", o.label());
			json.writeValue("start-date", dateTimeFormatter.format(o.startDate(), ISO8601_PATTERN));
			json.writeObjectEnd();
		}

		@SuppressWarnings("rawtypes")
		@Override
		public MiniHabit read(Json json, JsonValue jsonData, Class type) {
			Gdx.app.log(TAG, "jsonData:" + jsonData.toString());
			
			String label = jsonData.getString("label");
			String startDateAsText = jsonData.getString("start-date");
			Date startDate = dateTimeFormatter.parse(startDateAsText, ISO8601_PATTERN);
			return new MiniHabit(label, startDate);
		}

	}

}
