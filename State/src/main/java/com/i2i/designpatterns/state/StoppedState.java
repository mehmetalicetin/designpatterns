package com.i2i.designpatterns.state;

import com.i2i.designpatterns.state.context.MediaPlayer;

/*
"Play" tuşuna basılırsa, durum "Playing" olarak değişir.
"Pause" veya "Stop" tuşuna basılırsa, uygun hata mesajı verilir.
* */
public class StoppedState implements MediaPlayerState{
	@Override
	public void play(MediaPlayer context) {
		System.out.println("Oynatma basladi");
		context.setCurrentState(new PlayingState());
	}

	@Override
	public void pause(MediaPlayer context) {
		System.out.println("Müzik zaten durduruldu! Önce Play tuşuna basın.");
	}

	@Override
	public void stop(MediaPlayer context) {
		System.out.println("Müzik zaten durdurulmuş!");
	}
}
