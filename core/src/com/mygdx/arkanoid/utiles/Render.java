package com.mygdx.arkanoid.utiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Render {

	public static SpriteBatch sb;
	public static ShapeRenderer sr;
	
	public static void limpiarPantalla() {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	public static void begin() {
		sb.begin();
	}
	
	public static void end() {
		sb.end();
	}
	
}
