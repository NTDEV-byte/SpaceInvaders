package com.game.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.game.Game;
import com.game.entity.spaceships.SpaceShip;
import com.game.level.Level;

public abstract class Entity {
	
		protected Rectangle bounds;
		protected BufferedImage image;
		protected boolean removed;
		protected Random random = new Random();
		protected int lives;
		protected int xDir,yDir;
		protected int speed = 1;
		protected int timer;
		protected Level level = Game.level;
		
		public abstract void update();
		public abstract void render(Graphics g);
		
		public boolean collision(Entity e) { 
			return bounds.intersects(e.getBounds());
		}
		
		public boolean collisionWithWorldH() { 
			return bounds.x <= 0 || bounds.x + SpaceShip.WIDTH >= Game.WIDTH;
		}
		
		public boolean collisionWithWorldV() {
			return bounds.y  <= 0 || bounds.y + SpaceShip.HEIGHT >= Game.HEIGHT;
		}
		
		protected void showBounds(Graphics g) { 
			g.setColor(Color.yellow);
			g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
		public Rectangle getBounds() {
			return bounds;
		}
		public void setBounds(Rectangle bounds) {
			this.bounds = bounds;
		}
		public int getLives() {
			return lives;
		}
		public void setLives(int lives) {
			this.lives = lives;
		}
		public void setRemoved(boolean removed) {
			this.removed = removed;
		}
		public void remove() {
			this.removed = true;
		}
		
		public boolean isRemoved() {
			return removed;
		}
		
		
		
		
		
		
}
