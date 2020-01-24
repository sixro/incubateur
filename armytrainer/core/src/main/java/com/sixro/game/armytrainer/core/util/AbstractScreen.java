package com.sixro.game.armytrainer.core.util;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Represents an abstract screen able to access to viewport, skin, settings and assets.
 * 
 * FIXME gestire anche l'input da stage e anche quello di BACK, ESC
 */
public abstract class AbstractScreen implements Screen {

	private final Viewport viewport;
	private final Skin skin;
	private final BaseSettings settings;
	private final AssetManager assetManager;
	private final Stage stage;

	private InputMultiplexer inputHandler;

	
	protected AbstractScreen(Viewport viewport, Skin skin, BaseSettings settings, AssetManager assetManager) {
		super();
		this.viewport = viewport;
		this.skin = skin;
		this.settings = settings;
		this.assetManager = assetManager;
		
		this.stage = new Stage(viewport);
		this.inputHandler = new InputMultiplexer(stage);
	}

	public Viewport getViewport() {
		return viewport;
	}

	public Skin getSkin() {
		return skin;
	}

	public BaseSettings getSettings() {
		return settings;
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}

	public Stage getStage() {
		return stage;
	}

	/**
	 * Set what to do when a cancel is request (e.g. a BACK or a ESC is pressed).
	 * 
	 * <p>
	 * You can fire the action programmatically calling the {@code cancel} operation.
	 * </p>
	 * 
	 * @param r a {@link Runnable}
	 */
	public void onCancel(Runnable r) {
		inputHandler.addProcessor(new CancelInputProcessor(r));
	}
	
	@Override
	public void show() {
		Gdx.input.setCatchMenuKey(true);
		Gdx.input.setCatchBackKey(true);
		Gdx.input.setInputProcessor(inputHandler);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	@Override
	public void pause() { }

	@Override
	public void resume() { }

	@Override
	public void hide() { }

	@Override
	public void dispose() {
		stage.dispose();
	}

}
