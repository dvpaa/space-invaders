package org.newdawn.spaceinvaders;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    private static GameTimer instance; // 인스턴스 변수
    private Timer timer;
    private LocalTime startTime;
    private JLabel timerLabel;
    private long hours;
    private long minutes;
    private long seconds;
    private float scoreTimer;
    private float score;
    private float totalTimeInSec;

    private GameTimer() {
        timer = new Timer();
        timerLabel = new JLabel();
    }

    public static GameTimer getInstance() {
        if (instance == null) {
            instance = new GameTimer();
        }
        return instance;
    }

    public void startTimer() {
        startTime = LocalTime.now();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalTime now = LocalTime.now();
                Duration duration = Duration.between(startTime, now);
                timerLabel.setText(
                    String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutes() % 60,
                        duration.getSeconds() % 60)
                );
                hours = duration.toHours();
                minutes = duration.toMinutes() % 60;
                seconds = duration.getSeconds() % 60;
            }
        }, 0, 1000);
    }

    public void stopTimer() {
        timer.cancel();
        timer = new Timer();
    }

    public JLabel getTimerLabel() {
        return timerLabel;
    }

    public String getEndTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public float getScore() {
        totalTimeInSec = 360 * hours + 60 * minutes + seconds;
        if (totalTimeInSec >= 300) {
            return 10;
        }
        return 300 - totalTimeInSec;
    }
}
