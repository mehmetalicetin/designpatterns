package com.i2i.designpatterns.state;

import com.i2i.designpatterns.state.context.MediaPlayer;

//Bu arayüz tüm durumların uygulaması gereken metodları tanımlar.
public interface MediaPlayerState {
	void play(MediaPlayer mediaPlayer);
	void pause(MediaPlayer mediaPlayer);
	void stop(MediaPlayer mediaPlayer);
}
