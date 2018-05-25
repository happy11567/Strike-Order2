package com.game.src.main.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import com.game.src.main.Controller;
import com.game.src.main.Game;
import com.game.src.main.Game.STATE;
import com.game.src.main.Player;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;

public class MouseInput implements MouseListener{
	Game game;
	Controller c;
	
	public MouseInput(Game game,  Player p, LinkedList<EntityB> entb, LinkedList<EntityC> entc, Controller c) {
		this.game=game;
		this.c=c;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		int mx = arg0.getX();
		int my = arg0.getY();
		/*
		public Rectangle playButton = new Rectangle(Game.WIDTH/2 + 120, 200,200,50);
		public Rectangle quitButton = new Rectangle(Game.WIDTH/2 + 120, 300,200,50);
		*/
		if(mx >= Game.WIDTH/2+120 && mx <= Game.WIDTH/2 + 320 && game.getState()==STATE.MENU) {
			if(my >= 200 && my <=  300) {
				game.setState(STATE.GAME);
				System.out.println("nigger");
			}
		}
		if(mx >= Game.WIDTH/2+120 && mx <= Game.WIDTH/2 + 320 && game.getState()==STATE.DEATH) {
			if(my >= 200 && my <=  300) {
				game.init();
				game.setState(STATE.GAME);
			}
		}

	}
	
	

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
