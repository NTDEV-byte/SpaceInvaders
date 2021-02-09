package com.game.level;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.game.Game;
import com.game.entity.Crab;
import com.game.entity.Entity;
import com.game.entity.Octopus;
import com.game.entity.Player;
import com.game.entity.Squid;
import com.game.entity.fires.Fire;

public class Level {
		
		private List<Entity> levelObjects;
		
			public Level() { 
				levelObjects = new ArrayList<Entity>();
				levelObjects.add(new Crab(new Rectangle(15,15,40,40)));
				levelObjects.add(new Squid(new Rectangle(100,15,40,40)));
				levelObjects.add(new Octopus(new Rectangle(200,15,40,40)));
				levelObjects.add(new Player(new Rectangle((Game.WIDTH - 60) / 2, (Game.HEIGHT - 60) , 60,60)));
				levelObjects.add(new Fire("laserR" , new Rectangle(150,150,30,30)));
			}
		
		
		public void update() { 
			for(Entity e : levelObjects) { 
				e.update();
			}
		}
		
		public void render(Graphics g) { 
			for(Entity e : levelObjects) { 
				  e.render(g);
			}
		}

}
