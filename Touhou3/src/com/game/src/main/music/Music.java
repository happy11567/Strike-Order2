package com.game.src.main.music;

import java.applet.*;
import java.net.URL;

public class Music {
	AudioClip bgmClip, attackClip, artoriaDeadClip;
	
	
	
	
	public Music(){
	URL music = Music.class.getResource("/nig.wav");
	bgmClip = Applet.newAudioClip(music);
	
	music = Music.class.getResource("/SaberAttack1.wav");
	attackClip = Applet.newAudioClip(music);
	
	music = Music.class.getResource("/ArtoriaDefeat1.wav");
	artoriaDeadClip = Applet.newAudioClip(music);
	}
	
	public void playMusic() {
		bgmClip.play();
	}
	public void stopMusic() {
		bgmClip.stop();
	}
	public void playAttackMusic() {
		attackClip.play();
	}
	public void playSaberDeadMusic() {
		artoriaDeadClip.play();
	}
}