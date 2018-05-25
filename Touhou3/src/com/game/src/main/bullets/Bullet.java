package com.game.src.main.bullets;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.Controller;
import com.game.src.main.Game;
import com.game.src.main.GameObject;
import com.game.src.main.Physics;
import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.graphics.Textures;

public class Bullet extends GameObject implements EntityA{

	
	private Textures tex;
	private Game game;
	private Controller c;
	BufferedImage image;
	
	public Bullet(double x, double y, Textures tex, Game game, Controller c) {
		super(x,y);
		this.tex = tex;
		this.game=game;
		this.c=c;
	}
	
	
	public void tick() {
			bound();
			checkEnemyCollision();
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,1,1);
	}
	
	public void render(Graphics g) {
		g.drawImage(tex.bullet, (int)x, (int)y, null);
	}
	public double getY() {
		return y;
	}
	public double getX() {
		return x;
	}

	@Override
	public void checkEnemyCollision() {
		for(int i =0; i<game.eb.size();i++) {
			EntityB tempEnt = game.eb.get(i);
			if(Physics.Collision(this, tempEnt )) {
				c.removeEntityA(this);
				c.removeEntityB(tempEnt);
			}
		}
	}


	@Override
	public void bound() {
		if(y<0)
			c.removeEntityA(this);
		y-=10;
	}
}
