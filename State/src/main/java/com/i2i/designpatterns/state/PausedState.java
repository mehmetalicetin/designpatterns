package com.i2i.designpatterns.state;

import com.i2i.designpatterns.state.context.MediaPlayer;

/*
"Play" tuşuna basılırsa, müzik zaten çaldığı için bir şey değişmez.
"Pause" tuşuna basılırsa, durum "Paused" olarak değişir.
"Stop" tuşuna basılırsa, durum "Stopped" olarak değişir.
* */
public class PausedState implements MediaPlayerState{
	@Override
	public void play(MediaPlayer context) {
		System.out.println("Müzik devam ediyor...");
		context.setCurrentState(new PlayingState()); // Durum değiştir
	}

	@Override
	public void pause(MediaPlayer context) {
		System.out.println("Müzik zaten duraklatılmış!");
	}

	@Override
	public void stop(MediaPlayer context) {
		System.out.println("Müzik durduruldu.");
		context.setCurrentState(new StoppedState()); // Durum değiştir
	}
}
