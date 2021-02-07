package com.game.level;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.game.entity.Crab;
import com.game.entity.Entity;
import com.game.entity.Octopus;
import com.game.entity.Squid;

public class Level {
		
		private List<Entity> objects;
			
		
			public Level() { 
				objects = new ArrayList<Entity>();
				objects.add(new Crab(new Rectangle(15,15,40,40)));
				objects.add(new Squid(new Rectangle(100,15,40,40)));
				objects.add(new Octopus(new Rectangle(200,15,40,40)));
			}
		
		
		public void update() { 
			for(Entity e : objects) { 
				e.update();
			}
		}
		
		
		public void render(Graphics g) { 
			for(Entity e : objects) { 
				  e.render(g);
			}
		}

}
