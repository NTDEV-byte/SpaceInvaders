package com.game.gfx;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;


public class SpriteLoader {
	
	
		@SuppressWarnings("unused")
		private static SpriteLoader SPRITE = new SpriteLoader("./res/spaceINVD.png");
		public static BufferedImage spritesheet;
		public static String path;
		public static int pixels[];
		public static int width,height;
		public static Map<String,List<BufferedImage>> sprites;
		
		
			private SpriteLoader(String path) { 
					SpriteLoader.path = path;
					loadIMG(path);
					sprites = new HashMap<String,List<BufferedImage>>();
					crop("squid",0,0,1,2,18,10);
					crop("crab",1,0,1,2,18,10);
					crop("octopus",2,0,1,2,18,10);
					crop("explosion",4,0,1,1,14,14);
					crop("player",0,4,1,1,17,12);
			
			}
			
			
			private void loadIMG(String path) {
				try {
					spritesheet = ImageIO.read(new FileInputStream(path));
					width = spritesheet.getWidth();
					height = spritesheet.getHeight();
					pixels = new int[width * height];
					spritesheet.getRGB(0, 0, width, height, pixels, 0, width);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			private void crop(String name,int x,int y,int w,int h,int spriteW,int spriteH) { 
				  int spritePixels[] = new int[spriteW * spriteH];
				  List<BufferedImage> images = new ArrayList<BufferedImage>();
				  for(int y0=0;y0<h;y0++) {
					   for(int x0=0;x0<w;x0++) { 
						   for(int y1=0;y1<spriteH;y1++) {
							    for(int x1=0;x1<spriteW;x1++) { 
							    	int col = pixels[(x1 + ((x0 + x) * spriteW)) + (y1 + ((y0 + y) * spriteH)) *  SpriteLoader.width];
							    	if(col!=0xffff00ff)spritePixels[x1 + y1 * spriteW] = col;
							    }
						   }
						   BufferedImage img = new BufferedImage(spriteW,spriteH,BufferedImage.TYPE_INT_RGB);
						   img.setRGB(0, 0, spriteW, spriteH, spritePixels, 0, spriteW);
						   images.add(img);
					   }
				  }
				   sprites.put(name, images);
			}
			

}
