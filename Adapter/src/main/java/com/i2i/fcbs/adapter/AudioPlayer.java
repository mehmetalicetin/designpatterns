package com.i2i.fcbs.adapter;

public class AudioPlayer implements MediaPlayer {
	private MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Mp3 playing " + fileName);
		} else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
				mediaAdapter = MediaAdapter.create(audioType);
				mediaAdapter.play(audioType, fileName);
		} else{
			System.out.println("Unsupported audio type: " + audioType);
		}
	}
}
