package com.i2i.fcbs.adapter;

//Incompatible Type
public class Mp4Player implements AdvancedMediaPlayer {
	@Override
	public void playVlc(String fileName) {
	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Mp4Player playing File name:" + fileName);
	}
}
