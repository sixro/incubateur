package com.sixro.game.armytrainer.core;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.sixro.game.armytrainer.core.util.*;

public class ArmyTrainerGame extends Game {

	private StretchViewport viewport;
	private Skin skin;
	private BaseSettings settings;
	private AssetManager assets;
	
	private PreloadScreen preloadScreen;
	private MenuScreen menuScreen;
	
	public ArmyTrainerGame() {
		super();
	}

	@Override
	public void create () {
		viewport = new StretchViewport(480, 800);
		skin = new Skin(Gdx.files.internal("skins/basic/skin.json"));
		assets = new AssetManager();
		settings = new BaseSettings();

		preloadScreen = new PreloadScreen(viewport, skin, settings);
		preloadScreen.addListener(new PreloadScreen.Listener() {
			@Override
			public void onShown() {
				assets.load("background.png", Texture.class, settings.textureQuality());
				assets.load("hud-main-top5.png", Texture.class, settings.textureQuality());
				assets.load("hud-options2.png", Texture.class, settings.textureQuality());
				
				assets.load("click.mp3", Sound.class);
				
				preloadScreen.load(assets);
			}
			
			@Override
			public void onAssetsLoaded() {
				menuScreen = new MenuScreen(viewport, skin, settings, assets, ArmyTrainerGame.this);
				setScreen(menuScreen);
			}
		});
		
		setScreen(preloadScreen);
	}

}
