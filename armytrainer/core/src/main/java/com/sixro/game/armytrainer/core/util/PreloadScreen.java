package com.sixro.game.armytrainer.core.util;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import java.util.*;
import java.util.List;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PreloadScreen implements Screen {

	private final Viewport viewport;
	private final Skin skin;
	private final BaseSettings settings;

	private final List<PreloadScreen.Listener> listeners;
	private final Stage stage;
	private final Group content;

	private AssetManager assetManager;
	private Object mutex = new Object();

	private Texture bgTexture;
	private Label lblProgress;

	public PreloadScreen(Viewport viewport, Skin skin, BaseSettings settings) {
		super();
		this.viewport = viewport;
		this.skin = skin;
		this.settings = settings;

		this.listeners = new LinkedList<PreloadScreen.Listener>();
		
		this.stage = new Stage(viewport);
		this.content = new Group();
		this.stage.addActor(content);

		bgTexture = new Texture(Gdx.files.internal("splashscreen.png"));
		TextureParameter textureQuality = (TextureParameter) settings.textureQuality();
		bgTexture.setFilter(textureQuality.minFilter, textureQuality.magFilter);
		content.addActor(new Image(new TextureRegionDrawable(new TextureRegion(bgTexture))));
		
		//lblProgress = new Label("0", skin, "normal-em");
		lblProgress = new Label("0", skin, "paragraph-bold");
		lblProgress.setPosition(220, 500);
		lblProgress.setColor(Color.BLACK);
		content.addActor(lblProgress);
		
		stage.getRoot().addAction(
				sequence(
						fadeIn(.500f),
						delay(.500f),
						after(new Action() {
							@Override
							public boolean act(float delta) {
								for (PreloadScreen.Listener listener : listeners) {
									listener.onShown();
								}
								return true;
							}
						})
						)
				);
	}

	public void addListener(PreloadScreen.Listener listener) {
		this.listeners.add(listener);
	}
	
	public void load(AssetManager assetManager) {
		synchronized (mutex) {
			this.assetManager = assetManager;
		}
	}
	
	@Override
	public void show() {
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		synchronized (mutex) {
			if (assetManager != null) {
				if (assetManager.update()) {
					lblProgress.setText("100%");

					stage.getRoot().addAction(
							sequence(
									delay(.250f), 
									fadeOut(.500f), 
									after(new Action() {
										@Override
										public boolean act(float delta) {
											bgTexture.dispose();
											stage.dispose();
											
											Gdx.app.postRunnable(new Runnable() {
												public void run() {
													for (PreloadScreen.Listener listener : listeners) {
														listener.onAssetsLoaded();
													}
												}
											});
											return true;
										}
									})
							)
					);
				} else {
					lblProgress.setText((assetManager.getProgress() * 100) + "%");
				}
			}
		}
		
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) { }

	@Override
	public void hide() { }

	@Override
	public void pause() { }

	@Override
	public void resume() { }

	@Override
	public void dispose() { }

	public static interface Listener {
		
		void onShown();
		
		void onAssetsLoaded();
		
	}

}
