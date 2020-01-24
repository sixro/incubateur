package com.sixro.game.armytrainer.core;

import com.badlogic.gdx.scenes.scene2d.ui.*;

public class BasicSkinUtils {

	private BasicSkinUtils() { }
	
	public static void customizeDialog(Dialog dialog) {
		dialog.pad(48f, 6f, 6f, 6f);
		dialog.setMovable(false);
		
		Table btnTable = dialog.getButtonTable();
		btnTable.padBottom(6f);
		
		Cell<?> btnDefaults = btnTable.defaults();
		btnDefaults.height(64);
		btnDefaults.width(150);
	}

}
