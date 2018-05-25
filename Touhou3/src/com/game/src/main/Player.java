package com.game.src.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.Game.STATE;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;
import com.game.src.main.graphics.Textures;
import com.game.src.main.music.Music;

public class Player extends GameObject{



	private static double xVel = 0;
	private static double yVel = 0;
	
	private int hp;
	private Game game;
	private Controller c;
	private Textures tex;
	private double speedMod;
	private Music musicPlayer;
	private int aniFrame;
	private int speed = 10;
	public Player(double x, double y, Textures tex, Game game, Music musicPlayer) {

		super(x,y);
		this.tex = tex;
		this.game=game;
		hp=3;
		speedMod=1;
		this.musicPlayer=musicPlayer;
	}
	
	public void tick() throws InterruptedException {
		
		checkPlayerCollision();
		
		x+=xVel*speedMod;
		y+=yVel*speedMod;
		
		if(hp==0) {
			game.setState(STATE.DEATH);
			musicPlayer.stopMusic();
		}
		if (x<=0)
			x = 0;
		if (x>= 2*500-64)
			x = 2*500-64;
		if (y<=0)
			y = 0;
		if (y>= 2*375-64)
			y = 2*375-64;
		

	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,64,64);
	}
	
	
	public void render(Graphics g) {

	
		BufferedImage temp;
		temp=tex.playerAni[aniFrame/(60/speed)];
        Graphics2D g2d = (Graphics2D)(g);
        double temp2 = getAngle(); 
        g.drawImage(temp,(int)x, (int)y, null);
		g.drawString(Integer.toString(hp), (int)x, (int)y);
		if(aniFrame==tex.playerAni.length*(60/speed)-1)
			aniFrame=0;
		aniFrame++;
	
		
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x=x;
	}
	public void setY(double y) {
		this.y=y;
	}
	public double getVelX() {
		return xVel;
	}
	public double getVelY() {
		return yVel;
	}
	public void setVelX(double velX) {
		xVel=velX;
	}
	public void setVelY(double velY) {
		yVel=velY;
	}
	public void setHp(int hp) {
		this.hp=hp;
	}
	public int getHp() {
		return hp;
	}
	public void setSpeedMod() {
		speedMod=0.5;
	}
	public void reSetSpeedMod() {
		speedMod=1;
	}
	private void checkPlayerCollision() throws InterruptedException {
	
		for(int i=0; i<game.eb.size(); i++) {
			EntityB tempEnt = game.eb.get(i);
			if (Math.abs(tempEnt.getX()-x)<=5 && Math.abs(tempEnt.getY()-y)<=5) {
				musicPlayer.playSaberDeadMusic();
				hp--;
				c.removeAll();
				x=game.WIDTH;
				y=500;
			}
		}	
		for(int i=0; i<game.ec.size(); i++) {
			EntityC tempEnt = game.ec.get(i);
			if (Math.abs(tempEnt.getX()-x)<=5 && Math.abs(tempEnt.getY()-y)<=5) {
				musicPlayer.playSaberDeadMusic();
				hp--;
				c.removeAll();
				x=game.WIDTH;
				y=500;
		
			}
		}	
	}
	public void givePlayerController(Controller c) {
		this.c = c;
	}
	
	public double getAngle() {
        double n = +Math.atan(yVel/xVel);
        if (xVel < 0 && yVel > 0) n= -Math.PI + n;
        if (xVel < 0 && yVel < 0) n = Math.PI + n;
        if (xVel > 0 && yVel < 0) n = -2*Math.PI + n;
        return n-Math.PI/2;
    }
}
