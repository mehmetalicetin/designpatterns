package com.i2i.designpatterns.state.context;

import com.i2i.designpatterns.state.MediaPlayerState;
import com.i2i.designpatterns.state.StoppedState;

/*
Medya oynatıcı başlangıçta "Stopped" durumundadır.
Butonlara basıldığında o anki duruma göre işlem yapılır ve yeni bir duruma geçilir.
* */
public class MediaPlayer {
	private MediaPlayerState currentState;

	public MediaPlayer() {
		this.currentState = new StoppedState();
	}

	public void setCurrentState(MediaPlayerState currentState){
		this.currentState = currentState;
	}

	public void play(){
		this.currentState.play(this);
	}

	public void pause(){
		this.currentState.pause(this);
	}

	public void stop(){
		this.currentState.stop(this);
	}
}
