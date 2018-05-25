package com.game.src.main.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage image;
	

	
	
	public SpriteSheet(BufferedImage image) {
		this.image=image;
	}
	
	public BufferedImage getImage(int col, int row, int width, int height) {
		
		BufferedImage img = image.getSubimage((col*64)-64, (row*64)-64, width, height);
		return img;
		
	}
	
	
}
