package com.game.src.main;

import java.awt.Rectangle;

import com.game.src.main.patterns.MovementPattern;

public class GameObject extends MovementPattern {
	public double x,y ;
	public GameObject(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public Rectangle getBounds(int width, int height) {
		return new Rectangle((int)x,(int)y,width,height);
	}
}
