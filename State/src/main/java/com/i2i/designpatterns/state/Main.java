package com.i2i.designpatterns.state;

import com.i2i.designpatterns.state.context.MediaPlayer;

public class Main {
	public static void main(String[] args) {
		MediaPlayer player = new MediaPlayer();

		player.play();  // Oynatma başladı...
		player.pause(); // Müzik duraklatıldı.
		player.play();  // Müzik devam ediyor...
		player.stop();  // Müzik durduruldu.
		player.pause(); // Müzik zaten durduruldu! Önce Play tuşuna basın.
	}
}
