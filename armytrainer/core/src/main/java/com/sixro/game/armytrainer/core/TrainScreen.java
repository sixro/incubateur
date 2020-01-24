package com.sixro.game.armytrainer.core;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sixro.game.armytrainer.core.util.*;

public class TrainScreen extends AbstractScreen {

	private TextButton btnPushups;
	private TextButton btnSitups;
	private TextButton btnRunning;
	
	public TrainScreen(Viewport viewport, Skin skin, BaseSettings settings, AssetManager assetManager) {
		super(viewport, skin, settings, assetManager);
	}

	@Override
	public void show() {
		super.show();
		
		btnPushups = addTextButton("Pushups", new Rectangle(250, 320, 220, 48));
		btnSitups  = addTextButton("Situps",  new Rectangle(250, 260, 220, 48));
		btnRunning = addTextButton("Running", new Rectangle(250, 200, 220, 48));
	}

	private TextButton addTextButton(String text, Rectangle rect) {
		TextButton btn = new TextButton(text, getSkin());
		btn.setBounds(rect.x, rect.y, rect.width, rect.height);
		getStage().addActor(btn);
		return btn;
	}

}
