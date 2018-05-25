package com.game.src.main.patterns;

import com.game.src.main.bullets.BulletSR;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;

public class MovementPattern extends BulletPattern{

	//1
	public void down1(EntityB a) {
		a.setXVel(0);
		a.setYVel(1);
	}
	//2
	public void down2(EntityB a) {
		a.setXVel(0);
		a.setYVel(2);
	}
	//3
	public void down3(EntityB a) {
		a.setXVel(0);
		a.setYVel(3);
	}
	//4
	public void down4(EntityB a) {
		a.setXVel(0);
		a.setYVel(4);
	}
	//5
	public void down5(EntityB a) {
		a.setXVel(0);
		a.setYVel(5);
	}
	//6
	public void up1(BulletSR bulletSR) {
		bulletSR.setXVel(0);
		bulletSR.setYVel(-1);
	}
	//7
	public void up2(EntityB a) {
		a.setXVel(0);
		a.setYVel(-2);
	}
	//8
	public void up3(EntityB a) {
		a.setXVel(0);
		a.setYVel(-3);
	}
	//9
	public void up4(EntityB a) {
		a.setXVel(0);
		a.setYVel(-4);
	}
	//10
	public void up5(EntityB a) {
		a.setXVel(0);
		a.setYVel(-5);
	}
	//11
	public void left1(EntityB a) {
		a.setXVel(-1);
		a.setYVel(0);
	}
	//12
	public void left2(EntityB a) {
		a.setXVel(-2);
		a.setYVel(0);
	}
	//13
	public void left3(EntityB a) {
		a.setXVel(-3);
		a.setYVel(0);
	}
	//14
	public void left4(EntityB a) {
		a.setXVel(-4);
		a.setYVel(0);
	}
	//15
	public void left5(EntityB a) {
		a.setXVel(-5);
		a.setYVel(0);
	}
	//16
	public void right1(EntityB a) {
		a.setXVel(1);
		a.setYVel(0);
	}
	//17
	public void right2(EntityB a) {
		a.setXVel(2);
		a.setYVel(0);
	}
	//18
	public void right3(EntityB a) {
		a.setXVel(3);
		a.setYVel(0);
	}
	//19
	public void right4(EntityB a) {
		a.setXVel(4);
		a.setYVel(0);
	}
	//20
	public void right5(EntityB a) {
		a.setXVel(5);
		a.setYVel(0);
	}
	//21
	public void zigzag1 (EntityB a) {
		if((a.getCounter()/60)%2==0) {
			a.setXVel(1/Math.pow(2, 0.5));
			a.setYVel(1/Math.pow(2, 0.5));
		}
		if((a.getCounter()/60)%2==1){
			a.setXVel(-1/Math.pow(2, 0.5));
			a.setYVel(1/Math.pow(2, 0.5));
		}
	}
	//22
	public void zigzag2 (EntityB a) {
		if((a.getCounter()/120)%2==0) {
			a.setXVel(1/Math.pow(2, 0.5));
			a.setYVel(1/Math.pow(2, 0.5));
		}
		if((a.getCounter()/120)%2==1){
			a.setXVel(-1/Math.pow(2, 0.5));
			a.setYVel(1/Math.pow(2, 0.5));
		}
	}
	//23
	public void zigzag3 (EntityB a) {
		if((a.getCounter()/180)%2==0) {
			a.setXVel(1/Math.pow(2, 0.5));
			a.setYVel(1/Math.pow(2, 0.5));
		}
		if((a.getCounter()/180)%2==1){
			a.setXVel(-1/Math.pow(2, 0.5));
			a.setYVel(1/Math.pow(2, 0.5));
		}
	}
	
	
	
	//Entity C
	//1
	public void down1(EntityC a) {
		a.setXVel(0);
		a.setYVel(1);
	}
	//2
	public void down2(EntityC a) {
		a.setXVel(0);
		a.setYVel(2);
	}
	//3
	public void down3(EntityC a) {
		a.setXVel(0);
		a.setYVel(3);
	}
	//4
	public void down4(EntityC a) {
		a.setXVel(0);
		a.setYVel(4);
	}
	//5
	public void down5(EntityC a) {
		a.setXVel(0);
		a.setYVel(5);
	}
	//6
	public void up1(EntityC a) {
		a.setXVel(0);
		a.setYVel(-1);
	}
	//7
	public void up2(EntityC a) {
		a.setXVel(0);
		a.setYVel(-2);
	}
	//8
	public void up3(EntityC a) {
		a.setXVel(0);
		a.setYVel(-3);
	}
	//9
	public void up4(EntityC a) {
		a.setXVel(0);
		a.setYVel(-4);
	}
	//10
	public void up5(EntityC a) {
		a.setXVel(0);
		a.setYVel(-5);
	}
	//11
	public void left1(EntityC a) {
		a.setXVel(-1);
		a.setYVel(0);
	}
	//12
	public void left2(EntityC a) {
		a.setXVel(-2);
		a.setYVel(0);
	}
	//13
	public void left3(EntityC a) {
		a.setXVel(-3);
		a.setYVel(0);
	}
	//14
	public void left4(EntityC a) {
		a.setXVel(-4);
		a.setYVel(0);
	}
	//15
	public void left5(EntityC a) {
		a.setXVel(-5);
		a.setYVel(0);
	}
	//16
	public void right1(EntityC a) {
		a.setXVel(1);
		a.setYVel(0);
	}
	//17
	public void right2(EntityC a) {
		a.setXVel(2);
		a.setYVel(0);
	}
	//18
	public void right3(EntityC a) {
		a.setXVel(3);
		a.setYVel(0);
	}
	//19
	public void right4(EntityC a) {
		a.setXVel(4);
		a.setYVel(0);
	}
	//20
	public void right5(EntityC a) {
		a.setXVel(5);
		a.setYVel(0);
	}
	//21
	public void zigzag1 (EntityC a) {
		if((a.getCounter()/60)%2==0) {
			a.setXVel(1/Math.pow(2, 0.5));
			a.setYVel(1/Math.pow(2, 0.5));
		}
		if((a.getCounter()/60)%2==1){
			a.setXVel(-1/Math.pow(2, 0.5));
			a.setYVel(1/Math.pow(2, 0.5));
		}
	}
	//22
	public void zigzag2 (EntityC a) {
		if((a.getCounter()/120)%2==0) {
			a.setXVel(1/Math.pow(2, 0.5));
			a.setYVel(1/Math.pow(2, 0.5));
		}
		if((a.getCounter()/120)%2==1){
			a.setXVel(-1/Math.pow(2, 0.5));
			a.setYVel(1/Math.pow(2, 0.5));
		}
	}
	//23
	public void zigzag3 (EntityC a) {
		if((a.getCounter()/180)%2==0) {
			a.setXVel(1/Math.pow(2, 0.5));
			a.setYVel(1/Math.pow(2, 0.5));
		}
		if((a.getCounter()/180)%2==1){
			a.setXVel(-1/Math.pow(2, 0.5));
			a.setYVel(1/Math.pow(2, 0.5));
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
