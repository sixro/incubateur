package com.github.sixro.minihabits.core.util.libgdx;

import java.util.*;

import com.badlogic.gdx.*;
import com.badlogic.gdx.utils.Json;

public class PreferencesBasedStorage<T> implements Storage<T> {

	private static final String TAG = PreferencesBasedStorage.class.getSimpleName();
	
	private final Preferences preferences;
	private final String name;
	private final Json json;
	private final Class<T> type;

	public PreferencesBasedStorage(Preferences preferences, String name, Json json, Class<T> type) {
		super();
		this.preferences = preferences;
		this.name = name;
		this.json = json;
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Gdx.app.log(TAG, "[findAll] finding all stored items of type '" + type + "' in pref '" + name + "'...");
		String textualRepresentation = preferences.getString(name);
		Gdx.app.debug(TAG, "[findAll] ... pref '" + name + "' valued as '" + textualRepresentation + "'...");
		
		List<T> list = json.fromJson(List.class, type, textualRepresentation);
		if (list == null)
			list = new ArrayList<T>();
		
		Gdx.app.log(TAG, "[findAll] ... returning " + list);
		return list;
	}

	
	@Override
	public void saveAll(List<T> items) {
		Gdx.app.log(TAG, "[saveAll] Saving all items " + items + "...");

		String textualRepresentation = json.toJson(items);
		preferences.putString(name, textualRepresentation);
		preferences.flush();
		
		Gdx.app.log(TAG, "[saveAll] ... all items saved");
	}

}
