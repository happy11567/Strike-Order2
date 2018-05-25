package com.game.src.main.patterns;

import com.game.src.main.Controller;
import com.game.src.main.Player;
import com.game.src.main.bullets.BulletSR;
import com.game.src.main.bullets.MedeaBallGreen;
import com.game.src.main.classes.EntityB;
import com.game.src.main.graphics.Textures;

public class BulletPattern {
	
	public void aim1SR(EntityB b, Textures tex, Player p, Controller c) {
		if(b.getCounter()%60==0) {
			c.addEntityC(new BulletSR(b.getX(),b.getY(),tex, p,c, 0));
		}	
		if(b.getCounter()%110==0) {
			c.addEntityC(new BulletSR(b.getX(),b.getY(),tex, p,c, 5));
		}	
	}
	public void spread1(EntityB b, Textures tex, Player p, Controller c) {
		if(b.getCounter()%180==0) {
			c.addEntityC(new MedeaBallGreen(b.getX(),b.getY(),tex, p,c,2));
			c.addEntityC(new MedeaBallGreen(b.getX(),b.getY(),tex, p,c,7));
			c.addEntityC(new MedeaBallGreen(b.getX(),b.getY(),tex, p,c,12));
			c.addEntityC(new MedeaBallGreen(b.getX(),b.getY(),tex, p,c,17));
		}	
	}

}
