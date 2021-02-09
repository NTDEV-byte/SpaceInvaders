package com.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{

	private int pressedKey;
	

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) { 
		case KeyEvent.VK_UP:
			pressedKey = KeyEvent.VK_UP;
			break;
		case KeyEvent.VK_RIGHT:
			pressedKey = KeyEvent.VK_RIGHT;
			break;
			
		case KeyEvent.VK_DOWN:
			pressedKey = KeyEvent.VK_DOWN;
			break;
	
		case KeyEvent.VK_LEFT:
			pressedKey = KeyEvent.VK_LEFT;
			break;
			
		case KeyEvent.VK_SPACE:
			pressedKey = KeyEvent.VK_SPACE;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		pressedKey  = -1;
	}
	
	public boolean up() { 
		return pressedKey == KeyEvent.VK_UP;
	}
	
	public boolean right() {
		return pressedKey == KeyEvent.VK_RIGHT;
	}
	
	public boolean down() { 
		return pressedKey == KeyEvent.VK_DOWN;
	}
	
	public boolean left() { 
		return pressedKey == KeyEvent.VK_LEFT;
	}

	public boolean space() { 
		return pressedKey == KeyEvent.VK_SPACE;
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
