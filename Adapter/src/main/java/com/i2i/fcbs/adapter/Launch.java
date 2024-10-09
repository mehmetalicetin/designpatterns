package com.i2i.fcbs.adapter;

public class Launch {
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "Mp3FileName");
		audioPlayer.play("mp4", "Mp4FileName");
		audioPlayer.play("vlc", "VlcFileName");
		audioPlayer.play("x", "XFileName");
	}
}
