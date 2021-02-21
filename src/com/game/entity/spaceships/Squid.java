package com.game.entity.spaceships;

import java.awt.Rectangle;

import com.game.entity.fires.Hsm;

public class Squid extends SpaceShip{

	
	public static final int SHOOT_OFFSET_X = 15;
	public static final int SHOOT_OFFSET_Y = 10;
	
	
	public Squid(Rectangle bounds) {
		super("squid", bounds);
	}

	@Override
	protected void shoot() {
		level.addEntity(new Hsm(new Rectangle(bounds.x + SHOOT_OFFSET_X,bounds.y + SHOOT_OFFSET_Y,10,20),this));
	}

}
