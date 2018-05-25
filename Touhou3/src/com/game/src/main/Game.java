package com.game.src.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;

import com.game.src.main.bullets.Bullet;
import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;
import com.game.src.main.enemies.Gilgamesh;
import com.game.src.main.graphics.ImageLoader;
import com.game.src.main.graphics.Textures;
import com.game.src.main.input.KeyInput;
import com.game.src.main.input.MouseInput;
import com.game.src.main.menus.Menu;
import com.game.src.main.music.Music;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = WIDTH /12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "Touhou";
	
	private boolean running = false;
	private Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage background = null;
	
	private int rof = 0;
	private Player p;
	private Controller c;
	private Textures tex;
	private Menu menu;
	private Music musicPlayer;
	public LinkedList<EntityA> ea;
	public LinkedList<EntityB> eb;
	public LinkedList<EntityC> ec;
	public enum STATE{
		MENU,
		GAME,
		DEATH
	};
	
	private STATE State = STATE.MENU;
	
	public void init() {
		
		ImageLoader loader = new ImageLoader();
		try {
			spriteSheet = loader.loadImage("/Sprite.png");
			background = loader.loadImage("/FuyukiCity.png");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		this.addKeyListener(new KeyInput(this));
		this.addMouseListener(new MouseInput(this,p,eb,ec,c));
		tex = new Textures(this);
		musicPlayer = new Music(); 
		p = new Player(WIDTH,500, tex, this, musicPlayer);
		c = new Controller(this, tex, p);
		p.givePlayerController(c);
		menu = new Menu();
		ea = c.getEntityA();
		eb = c.getEntityB();
		ec = c.getEntityC();
		
		musicPlayer.playMusic();
	}
	
	
	private synchronized void start() {
		if(running)
			return;
	
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
	
		running = false;
		try{
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	
	
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames =0;
		long timer = System.currentTimeMillis();
		
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				try {
					tick();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer >1000) {
				timer += 1000;
				System.out.println(updates + "Ticks, Fps" + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() throws InterruptedException {
		if(State==STATE.GAME) {
			
			p.tick();
			c.tick();
			rof++;
			if(rof==8) {
				c.addEntityA(new Bullet(p.getX()-3,p.getY()-45,tex,this,c));
				rof=0;
			}
		
		}
	
	}
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		///
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(background, 0,0, this);
		
		if(State==STATE.GAME) {
			p.render(g);
			c.render(g);
		} else if(State==STATE.MENU) {
			menu.render(g);
			
		} else if(State==STATE.DEATH) {
			p.render(g);
			c.render(g);
			menu.render(g);
			
		}
		///
		g.dispose();
		bs.show();
		
	}
	

	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(State==STATE.GAME) {
			if(key == KeyEvent.VK_D) {
				p.setVelX(5);
			}
			else if(key == KeyEvent.VK_A) {
				p.setVelX(-5);
			}
			else if(key == KeyEvent.VK_S) {
				p.setVelY(5);
			}
			else if(key == KeyEvent.VK_W) {
				p.setVelY(-5);
			}
			else if(key == KeyEvent.VK_SPACE) {
				c.addEntityB(new Gilgamesh(p.getX()-300,p.getY()-450,tex,this,p,c));
			}
			else if(key == KeyEvent.VK_Q) {
				c.removeAll();
				
			}
			else if(key == KeyEvent.VK_SHIFT) {
				p.setSpeedMod();
				musicPlayer.playAttackMusic();
			}
			else if(key == KeyEvent.VK_F) {
				p.reSetSpeedMod();
				musicPlayer.playAttackMusic();
				
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_D) {
			p.setVelX(0);
		}
		else if(key == KeyEvent.VK_A) {
			p.setVelX(0);
		}
		else if(key == KeyEvent.VK_S) {
			p.setVelY(0);
		}
		else if(key == KeyEvent.VK_W) {
			p.setVelY(0);
		}	

	}
	
	
	
	
	public static void main(String args[]) {
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		game.setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		game.setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		game.start();
	
	}

	
	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}
	public STATE getState() {
		return State;
	}
	public void setState(STATE State) {
		this.State=State;
	}
}
