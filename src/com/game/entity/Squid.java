package com.game.entity;

import java.awt.Rectangle;

import com.game.entity.fires.Hsm;

public class Squid extends SpaceShip{

	public Squid(Rectangle bounds) {
		super("squid", bounds);
	}

	@Override
	protected void shoot() {
		level.addEntity(new Hsm(new Rectangle(bounds.x,bounds.y,40,40),this));
	}

}
