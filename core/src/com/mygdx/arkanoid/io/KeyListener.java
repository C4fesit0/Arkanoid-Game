package com.mygdx.arkanoid.io;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.arkanoid.redes.HiloCliente;

public class KeyListener implements InputProcessor{
	

	private boolean right = false, left = false;
	private boolean right1 = false, left1 = false;
	private HiloCliente hiloCliente;

	public KeyListener(HiloCliente hiloCliente)
	{
		this.hiloCliente= hiloCliente;
		
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		if(keycode==Keys.A) {
			left = true;
			
		}
		
		if(keycode==Keys.D) {
			right = true;
			
		}
		
		if(keycode==Keys.LEFT) {
			left1 = true;
		}
		
		if(keycode==Keys.RIGHT) {
			right1 = true;
		}
		
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode==Keys.A) {
			left = false;
			hiloCliente.enviarMensaje("SolteIz");
			System.out.println("Se envio SolteIzquierda");
		}
		
		if(keycode==Keys.D) {
			right = false;
			hiloCliente.enviarMensaje("SolteDe");
			System.out.println("Se envio SolteDerecha");
		}
		
		if(keycode==Keys.LEFT) {
			left1 = false;
			hiloCliente.enviarMensaje("SolteIz");
			System.out.println("Se envio SolteIzquierda");
		}
		
		if(keycode==Keys.RIGHT) {
			right1 = false;
			hiloCliente.enviarMensaje("SolteDe");
			System.out.println("Se envio SolteDerecha");
		}
		
	
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isLeft() {
		return left;
		
	}
	
	public boolean isRight() {
		return right;
		
	}
	
	public boolean isf1() {
		return left1;
	}
	
	public boolean isf2() {
		return right1;
	}
	

}
