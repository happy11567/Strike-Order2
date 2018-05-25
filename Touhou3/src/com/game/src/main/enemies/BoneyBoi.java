package com.game.src.main.enemies;



import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.Controller;
import com.game.src.main.Game;
import com.game.src.main.GameObject;
import com.game.src.main.Player;
import com.game.src.main.bullets.BulletSR;
import com.game.src.main.classes.EntityB;
import com.game.src.main.graphics.Textures;

public class BoneyBoi extends GameObject implements EntityB{

	private Textures tex;
	private Player p;
	private double xVel;
	private double yVel;
	private int counter;
	private Controller c;
	private Game game;
	
	public BoneyBoi(double x, double y, Textures tex, Game game,Player p, Controller c) {
		super(x,y);
		this.tex = tex;
		this.p =p;
		this.c = c;
		this.game = game;
		counter=0;
	} 
	
	
	public void tick() {
		bound();
		down5(this);
		move();
		counter++;
		if(counter==720) {
			counter=0;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(tex.boneyBoy, (int)x,(int)y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,20,20);
	}
	
	public double getY() {
		return y;
	}
	public double getX() {
		return x;
	}
	public int getCounter(){
		return counter;
	}
	public void setCounter(int counter){
		this.counter = counter;
	}


	@Override
	public void bound() {
		if(x<0 || y<0 || x>Game.WIDTH*2|| y>Game.HEIGHT*2)
			c.removeEntityB(this);
	}


	@Override
	public void setXVel(double d) {
		xVel=d;
		
	}


	@Override
	public void setYVel(double d) {
		yVel=d;
	}


	@Override
	public void move() {
		x+=xVel;
		y+=yVel;
		
	}
}
