package com.game.gfx;

import java.awt.image.BufferedImage;
import java.util.List;

public class Animation {
		
		public static final int RATE_ANIMATION = 250;
	
		private List<BufferedImage> sprites;
		private BufferedImage frame;
		private int current;
		private int timer;
		
			
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

				public void animate() { 
					if(timer < 7500) {
						timer++;
					}else {
						timer = 0;
					}
					if(timer % RATE_ANIMATION == 0) { 
							if(current >= sprites.size()) { 
								current = 0;
							}
						frame = sprites.get(current);
						current++;  
							
					}
				}
				
				public BufferedImage getAnimation() { 
					return frame;
				}
				
}
