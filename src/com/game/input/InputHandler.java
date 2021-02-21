package com.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputHandler implements KeyListener ,MouseMotionListener,MouseListener{

	private int pressedKey;
	private int mouseB;
	private int mouseX,mouseY;



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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseB = e.getButton();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseB = -1;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	public int getMouseB() {
		return mouseB;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

}
