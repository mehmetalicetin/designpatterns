package com.i2i.fcbs.adapter;

//Incompatible Type
public class VlcPlayer implements  AdvancedMediaPlayer{
	@Override
	public void playVlc(String fileName) {
		System.out.println("VlcPlayer playing File name:" + fileName);
	}

	@Override
	public void playMp4(String fileName) {
	}
}
