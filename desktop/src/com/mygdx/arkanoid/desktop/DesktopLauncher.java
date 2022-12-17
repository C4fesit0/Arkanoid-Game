package com.mygdx.arkanoid.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.arkanoid.Arkanoid;
import com.mygdx.arkanoid.utiles.Config;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Config.ANCHO;
		config.height = Config.ALTO;
		config.title = Config.NOMBRE;
		config.resizable = true;
		new LwjglApplication(new Arkanoid(), config);
	}
}