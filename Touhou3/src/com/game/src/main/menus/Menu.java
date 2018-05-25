package com.game.src.main.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.game.src.main.Game;

public class Menu {
	
	public Rectangle playButton = new Rectangle(Game.WIDTH/2 + 120, 200,200,50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH/2 + 120, 300,200,50);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("Ariel", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.blue);
		g.drawString("Touhou", Game.WIDTH/2, 150);
		g.setColor(Color.green);
		
		Font fnt1 = new Font("Ariel", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x+70, playButton.y+30);

		g2d.draw(playButton);
		g.drawString("Quit", quitButton.x+70, quitButton.y+30);
		g2d.draw(quitButton);
	}
}
