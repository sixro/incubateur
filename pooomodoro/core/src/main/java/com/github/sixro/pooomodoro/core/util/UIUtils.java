package com.github.sixro.pooomodoro.core.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class UIUtils {

	private UIUtils() { }

	public static ImageButton.ImageButtonStyle newImageButtonStyle(Skin skin, Texture imageUp) {
		ImageButton.ImageButtonStyle style = skin.get("default", ImageButton.ImageButtonStyle.class);
		ImageButton.ImageButtonStyle newStyle = new ImageButton.ImageButtonStyle(style);
		newStyle.imageUp = new TextureRegionDrawable(new TextureRegion(imageUp));
		return newStyle;
	}
	
}
