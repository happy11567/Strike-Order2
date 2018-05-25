package com.game.src.main.waves;

import com.game.src.main.Controller;
import com.game.src.main.Game;
import com.game.src.main.Player;
import com.game.src.main.enemies.BoneyBoi;
import com.game.src.main.enemies.CuChulainn;
import com.game.src.main.enemies.Gilgamesh;
import com.game.src.main.enemies.Humunculus;
import com.game.src.main.graphics.Textures;

public class Wave1 {

	public void spawnEnemy(Controller c, Textures tex, Game game, Player p) {
		if(c.getSeconds()%5==0 && c.getTicks()==0) {
			for(int x = 0; x<c.getSeconds()/2; x++) {
				c.addEntityB(new CuChulainn(Game.WIDTH*Game.SCALE*Math.random(),0, tex, game,p,c));
			}
		}
		if(c.getSeconds()==15 && c.getTicks()==0) {
			for(int x = 0; x<3; x++) {
				c.addEntityB(new BoneyBoi(Game.WIDTH*Game.SCALE*Math.random(),0, tex, game,p,c));
			}
		}
		if(c.getSeconds()==25 && c.getTicks()==0) {
			for(int x = 0; x<(Game.WIDTH*Game.SCALE); x+=64) {
				c.addEntityB(new Gilgamesh(x,0, tex, game,p,c));
			}
			for(int x = 0; x<(Game.WIDTH*Game.SCALE); x+=64) {
				c.addEntityB(new Humunculus(x,0, tex, game,p,c));
			}
		}

	}
	
	
	
	
	
	
}
