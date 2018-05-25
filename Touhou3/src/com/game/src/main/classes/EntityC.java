package com.game.src.main.classes;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface EntityC {
	public void tick();
	public void render(Graphics g);
	public Rectangle getBounds();
	public double getX();
	public double getY();
	public void bound();
	public void setXVel(double d);
	public void setYVel(double d);
	public int getCounter();
	public void aim();
	public void move();
}
