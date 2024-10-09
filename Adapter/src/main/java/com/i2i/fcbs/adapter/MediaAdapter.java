package com.i2i.fcbs.adapter;

//Bu adapter sınıfı, AdvancedMediaPlayer türündeki sınıfların (örneğin VlcPlayer ve Mp4Player) MediaPlayer arayüzü olarak kullanılmasına olanak sağlar.
public class MediaAdapter implements MediaPlayer{
	private AdvancedMediaPlayer advancedMediaPlayer;

	private MediaAdapter(){}

	public static MediaAdapter create(String audioType) {
		MediaAdapter adapter = new MediaAdapter();
		if(audioType.equals("mp4")){
			adapter.advancedMediaPlayer = new Mp4Player();
		} else if(audioType.equals("vlc")){
			adapter.advancedMediaPlayer = new VlcPlayer();
		}
		return adapter;
	}

	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("vlc")) {
			advancedMediaPlayer.playVlc(fileName);
		} else if(audioType.equalsIgnoreCase("mp4")) {
			advancedMediaPlayer.playMp4(fileName);
		}
	}
}
