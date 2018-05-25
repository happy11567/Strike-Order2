package com.game.src.main.bullets;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.Controller;
import com.game.src.main.Game;
import com.game.src.main.GameObject;
import com.game.src.main.Player;
import com.game.src.main.classes.EntityC;
import com.game.src.main.graphics.Textures;

public class MedeaBallGreen extends GameObject implements EntityC{

	private Textures tex;

	private double xVel;
	private double yVel;
	private Controller c;
	private int counter;
	BufferedImage image;
	private Player p;
	int movePattern;
	public MedeaBallGreen(double x, double y, Textures tex, Player p, Controller c, int movePattern) {
		super(x,y);
		this.c=c;
		this.tex=tex;
		this.p=p;
		this.movePattern=movePattern;
	}


	public void tick() {
		
		bound();
		counter++;

		if(movePattern==1)
			down1(this);
		else if(movePattern==2)
			down2(this);
		else if(movePattern==3)
			down3(this);
		else if(movePattern==4)
			down4(this);
		else if(movePattern==5)
			down5(this);
		else if(movePattern==6)
			up1(this);
		else if(movePattern==7)
			up2(this);
		else if(movePattern==8)
			up3(this);
		else if(movePattern==9)
			up4(this);
		else if(movePattern==10)
			up5(this);
		else if(movePattern==11)
			left1(this);
		else if(movePattern==12)
			left2(this);
		else if(movePattern==13)
			left3(this);
		else if(movePattern==14)
			left4(this);
		else if(movePattern==15)
			left5(this);
		else if(movePattern==16)
			right1(this);
		else if(movePattern==17)	
			right2(this);
		else if(movePattern==18)	right3(this);		
		else if(movePattern==19)	right4(this);
		else if(movePattern==20)	right5(this);				
		else if(movePattern==21)	zigzag1(this);													
		else if(movePattern==22)	zigzag2(this);		
		else if(movePattern==23)	zigzag3(this);		
		else if(movePattern==24)	zigzag1(this);			
		else if(movePattern==25)	zigzag1(this);		
		else if(movePattern==26)	zigzag1(this);		
		else if(movePattern==27)	zigzag1(this);		
		else if(movePattern==28)	zigzag1(this);		
		else if(movePattern==29)	zigzag1(this);		
		move();
	}


	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,64,64);
	}
	
	public void render(Graphics g) {
		g.drawImage(tex.medeaBallGreen, (int)x, (int)y, null);
	}
	public double getY() {
		return y;
	}
	public double getX() {
		return x;
	}



	@Override
	public void bound() {
		if(x<50 || y<50 || x>Game.WIDTH*2-50|| y>Game.HEIGHT*2-50)
			c.removeEntityC(this);
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
	public int getCounter() {
		return counter;
	}
	
	public void aim() {
		xVel=(x-p.getX())*5/(Math.pow(Math.pow(x-p.getX(),2)+Math.pow(y-p.getY(),2),0.5));
		yVel=(y-p.getY())*(5/(Math.pow(Math.pow(x-p.getX(),2)+Math.pow(y-p.getY(),2),0.5)));
	}



	@Override
	public void move() {
		x+=xVel;
		y+=yVel;
		
	}

}
