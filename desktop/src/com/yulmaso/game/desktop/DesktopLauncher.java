package com.yulmaso.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.yulmaso.game.Containers.Constants;
import com.yulmaso.game.Platformer;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = Constants.NAME;
		config.resizable = false;
		config.width = Math.round(Constants.WIDTH * Constants.SCALE);
		config.height = Math.round(Constants.HEIGHT * Constants.SCALE);

		new LwjglApplication(new Platformer(), config);
	}
}
