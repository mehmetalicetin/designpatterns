package com.i2i.designpatterns.state;

import com.i2i.designpatterns.state.context.MediaPlayer;

public class PlayingState implements MediaPlayerState{
	@Override
	public void play(MediaPlayer context) {
		System.out.println("Müzik zaten çalıyor!");
	}

	@Override
	public void pause(MediaPlayer context) {
		System.out.println("Müzik duraklatıldı.");
		context.setCurrentState(new PausedState()); // Durum değiştir
	}

	@Override
	public void stop(MediaPlayer context) {
		System.out.println("Müzik durduruldu.");
		context.setCurrentState(new StoppedState()); // Durum değiştir
	}
}
