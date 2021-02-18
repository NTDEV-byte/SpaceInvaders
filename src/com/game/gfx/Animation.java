package com.game.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

public class Animation {
		
		public static int RATE_ANIMATION = 250;
	//	public static Animation EXPLOSION0 = new Animation("explosion0",150);
		//public static Animation EXPLOSION1 = new Animation("explosion1");
	//	public static Animation EXPLOSIONS = Animation.Fusion(EXPLOSION0, EXPLOSION1);
		
		protected List<BufferedImage> sprites;
		protected BufferedImage frame;
		protected int current;
		protected int timer;
		protected boolean fullCircle;
		
		
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
					Animation.RATE_ANIMATION = rate;
				}


				public void animate() { 
					if(timer < 7500) {
						timer++;
					}else {
						timer = 0;
					}
					if(timer % RATE_ANIMATION == 0) { 
							if(current >= sprites.size()) { 
								current = 0;
								fullCircle = true;
							}
						frame = sprites.get(current);
						current++;  
					}
				}
				

				public void render(Graphics g,int x,int y,int w,int h) {
					 g.drawImage(frame, x, y, w, h, null);
				}
				
				public Animation fusionAnimation(Animation animation) { 
					  for(int i=0;i<animation.getSprites().size();i++) {
						   this.sprites.add(animation.getSprites().get(i));
					  }
					  return this;
				}
				
				public List<BufferedImage> getSprites() {
					return sprites;
				}

				public void setSprites(List<BufferedImage> sprites) {
					this.sprites = sprites;
				}

				
				public BufferedImage getAnimation() { 
					return frame;
				}

				public static Animation Fusion(Animation a1,Animation a2) {
					  return a1.fusionAnimation(a2);
				}
}
