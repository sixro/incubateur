package net.sixro.platformer.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.sixro.platformer.GameMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = GameMain.TITLE;
		config.width = GameMain.V_WIDTH * GameMain.SCALE;
		config.height = GameMain.V_HEIGHT * GameMain.SCALE;
		new LwjglApplication(new GameMain(), config);
	}
}
