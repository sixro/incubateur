package com.sixro.game.armytrainer.core;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sixro.game.armytrainer.core.util.*;

public class LogsScreen extends AbstractScreen {

	private Label lblLogs;
	
	public LogsScreen(Viewport viewport, Skin skin, BaseSettings settings, AssetManager assetManager) {
		super(viewport, skin, settings, assetManager);
	}

	@Override
	public void show() {
		super.show();
		
		lblLogs = addLabel("Logs", new Rectangle(250, 200, 220, 48));
	}

	private Label addLabel(String text, Rectangle rect) {
		Label label = new Label(text, getSkin());
		label.setBounds(rect.x, rect.y, rect.width, rect.height);
		getStage().addActor(label);
		return label;
	}

}
