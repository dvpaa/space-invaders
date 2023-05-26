package org.newdawn.spaceinvaders.configuration;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class GameMusicPlayer {
    private Player Mp3Player;
    private final String filePath = "src/main/resources/bgm/";
    private String bgmName;

    public GameMusicPlayer(String bgmName) {
        this.bgmName = bgmName;
    }

    public void play() {
        new Thread(() -> {
            while (true) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(filePath + bgmName + ".mp3");
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                    Player mp3Player = new Player(bufferedInputStream);
                    mp3Player.play();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }

    public void stop() {
        if (Mp3Player != null) Mp3Player.close();
    }

    public void changeBgm(String bgmName) {
        stop();
        this.bgmName = bgmName;
        play();
    }

    public boolean isPlaying() {
        return Mp3Player != null;
    }
}