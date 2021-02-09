package com.game.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Entity {
	
		protected Rectangle bounds;
		protected BufferedImage image;
		protected boolean removed;
		protected int lives;
		protected int speed = 1;
		
		public abstract void update();
		public abstract void render(Graphics g);
		
		
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
