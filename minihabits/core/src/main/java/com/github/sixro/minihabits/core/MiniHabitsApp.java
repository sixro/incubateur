package com.github.sixro.minihabits.core;

import com.badlogic.gdx.*;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.github.sixro.minihabits.core.application.MainController;
import com.github.sixro.minihabits.core.domain.Repository;
import com.github.sixro.minihabits.core.infrastructure.domain.*;
import com.github.sixro.minihabits.core.ui.MainView;

// FIXME provare lo skin https://github.com/czyzby/gdx-skins/tree/master/comic che hai gia' scaricato
public class MiniHabitsApp extends Game {

	private Skin skin;
	
	public MiniHabitsApp() {
		super();
	}

	@Override
	public void create () {
		//skin = new Skin(Gdx.files.internal("default/uiskin.json"));
		skin = new Skin(Gdx.files.internal("comic/comic-ui.json"));
		
		Preferences preferences = Gdx.app.getPreferences(MiniHabitsApp.class.getSimpleName());
		Repository repository = new PreferencesBasedRepository(preferences);//new InMemoryRepository();
		MainView mainView = new MainView(skin, new MainController(repository));
		setScreen(mainView);
	}

}
