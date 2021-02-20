package com.game.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.Game;
import com.game.entity.fires.PlayerFire;
import com.game.input.InputHandler;
import com.game.sound.SoundPlayer;

public class Player extends SpaceShip{
	
	public PlayerFire getFire() {
		return fire;
	}

	public void setFire(PlayerFire fire) {
		this.fire = fire;
	}

	public static final int WIDTH = 60;
	public static final int HEIGHT = 60;
	
	private PlayerFire fire;
	private InputHandler input = Game.input;

	public Player(Rectangle bounds) {
		super("player", bounds);
	}
	
	public void update() {
		 if(input.right()) {
			  bounds.x+=speed;
		 }
		 if(input.left()) { 
			 bounds.x-=speed;
		 }
		 
		 shoot();
		
	}
	
	public void shoot() { 
		 if(input.space() && canShoot()) { 
			 fire = new PlayerFire(Color.yellow,new Rectangle(bounds.x + PlayerFire.FIX_X,bounds.y + PlayerFire.FIX_Y ,5,15));
				SoundPlayer.SP.play("shoot");
		 }	
		 if(fire!=null) {
			    fire.update();
			    if(fire.isRemoved()) { 
			    	SoundPlayer.SP.close();
					  fire = null;
				 }
		 }
	}
	
	public boolean canShoot() { 
		return  fire == null;
	}
	
	public boolean shooted() { 
		return fire != null;
	}
	
	public PlayerFire getShootedFire() { 
		 return (shooted()) ? fire : null;
	}
	
	public void render(Graphics g) { 
		g.drawImage(image, bounds.x, bounds.y, bounds.width, bounds.height,null);
		if(fire!=null) {
			 fire.render(g);
		}
	}

}
