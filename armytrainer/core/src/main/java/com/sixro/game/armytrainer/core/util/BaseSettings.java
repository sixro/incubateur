package com.sixro.game.armytrainer.core.util;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class BaseSettings {

	private float effectsVolume;
	private float musicVolume;
	private boolean imagesHighQuality;

	private TextureParameter textureQuality;
	
	public BaseSettings() {
		super();
		this.effectsVolume = 0.8f;
		this.musicVolume = 0.8f;
		
		this.textureQuality = new TextureParameter();
		setImagesHighQuality(true);
	}

	public float getEffectsVolume() {
		return effectsVolume;
	}

	public void setEffectsVolume(float effectsVolume) {
		this.effectsVolume = effectsVolume;
	}

	public float getMusicVolume() {
		return musicVolume;
	}

	public void setMusicVolume(float musicVolume) {
		this.musicVolume = musicVolume;
	}

	public boolean isImagesHighQuality() {
		return imagesHighQuality;
	}

	public synchronized void setImagesHighQuality(boolean imagesHighQuality) {
		this.imagesHighQuality = imagesHighQuality;
		
		TextureFilter filter = (imagesHighQuality) ? TextureFilter.Linear : TextureFilter.Nearest;
		this.textureQuality.minFilter = filter;
		this.textureQuality.magFilter = filter;
	}

	public synchronized AssetLoaderParameters<Texture> textureQuality() {
		return textureQuality;
	}
	
}
