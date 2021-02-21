package com.game.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

public class Animation {
		
		public static Animation EXPLOSION0 = new Animation("explosion0");
		public static Animation EXPLOSION1 = new Animation("explosion1");
		public static Animation EXPLOSIONS = Animation.Fusion(EXPLOSION0, EXPLOSION1);
	
	
		
		protected List<BufferedImage> sprites;
		protected BufferedImage frame;
		protected int current;
		protected int timer;
		protected boolean fullCircle,rendred;
		protected int x,y,w,h;
		protected int rate_animation = 250;
		
		
				protected Animation() {
				
				}
				
				public Animation(String name) { 
					sprites = SpriteLoader.sprites.get(name);
					this.frame = sprites.get(0);
					if(sprites == null) { 
						System.err.println("Erreur lors du chargement des sprites de: "+name);
					}
					if(sprites.size() < 2) { 
						 System.err.println("Warning Animation Size < 2 !");
					}
				}
				
				public Animation(String name,int rate) { 
					sprites = SpriteLoader.sprites.get(name);
					this.frame = sprites.get(0);
					if(sprites == null) { 
						System.err.println("Erreur lors du chargement des sprites de: "+name);
					}
					if(sprites.size() < 2) { 
						 System.err.println("Warning Animation Size < 2 !");
					}
					this.rate_animation = rate;
				}

				public void animate() { 
					if(timer < 7500) {
						timer++;
					}else {
						timer = 0;
					}
					if(timer % rate_animation == 0) { 
							if(current >= sprites.size()) { 
								current = 0;
								fullCircle = true;
							}
						frame = sprites.get(current);
						current++;  
					}
				}

			
				public void render(Graphics g) {
					g.drawImage(frame, x, y, w, h, null);
				}
				
				public boolean fullRotation() { 
					return fullCircle;
				}
				
				public boolean rendred() {
					return rendred;
				}
				
				public void setAnimationLocation(int x,int y,int w,int h) {
					 this.x = x;
					 this.y = y;
					 this.w = w;
					 this.h = h;
				}
				
				public Animation fusionAnimation(Animation animation) { 
					  for(int i=0;i<animation.getSprites().size();i++) {
						   this.sprites.add(animation.getSprites().get(i));
					  }
					  return this;
				}
				
				public int getRate_animation() {
					return rate_animation;
				}
				
				public void setRate_animation(int rate_animation) {
					this.rate_animation = rate_animation;
				}
				
				public List<BufferedImage> getSprites() {
					return sprites;
				}

				public void setSprites(List<BufferedImage> sprites) {
					this.sprites = sprites;
				}

				public boolean isRendred() {
					return rendred;
				}
				public void setRendred(boolean rendred) {
					this.rendred = rendred;
				}
				public BufferedImage getAnimation() { 
					return frame;
				}

				public static Animation Fusion(Animation a1,Animation a2) {
					  return a1.fusionAnimation(a2);
				}
}
