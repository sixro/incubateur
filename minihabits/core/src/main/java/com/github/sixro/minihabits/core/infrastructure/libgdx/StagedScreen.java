package com.github.sixro.minihabits.core.infrastructure.libgdx;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class StagedScreen extends ScreenAdapter {

	protected final Skin skin;
	protected final Stage stage;
	
	public StagedScreen(Skin skin, Stage stage) {
		super();
		this.skin = skin;
		this.stage = stage;
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true /* centerCamera */);
	}
	
}
