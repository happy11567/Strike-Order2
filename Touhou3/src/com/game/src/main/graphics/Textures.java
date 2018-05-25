package com.game.src.main.graphics;

import java.awt.image.BufferedImage;

import com.game.src.main.Game;

public class Textures {

	public BufferedImage player, bullet, gilgamesh, bulletSR, humunculus,cu,boneyBoy , medeaBallGreen,medea;
	public BufferedImage playerAni[] = new BufferedImage[3];
	
	private SpriteSheet ss;
	
	public Textures(Game game) {
		ss = new SpriteSheet(game.getSpriteSheet());
	
		getTextures(); 
	}
	
	public void getTextures() {
		player = ss.getImage(1, 1, 64, 64);
		bullet = ss.getImage(1, 2, 64, 64);
		gilgamesh = ss.getImage(2, 1, 64, 64);
		bulletSR = ss.getImage(8, 3, 64, 64);
		humunculus = ss.getImage(8,1,64,64);
		cu = ss.getImage(3, 1, 64, 64);
		boneyBoy = ss.getImage(9,1,64,64);
		medeaBallGreen = ss.getImage(7, 2, 64, 64);
		medea = ss.getImage(7, 1, 64, 64);
		for (int i=0; i<3; i++) {
		playerAni[i] = ss.getImage(i+1, 1, 64, 64);
		}
	}
	
	
	
	
	
	
	
	
	
}
