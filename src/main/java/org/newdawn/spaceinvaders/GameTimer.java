package org.newdawn.spaceinvaders;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;


public class GameTimer {
    private Timer timer;
    private LocalTime startTime;
    private JLabel timerLabel;
    private long hours;
    private long minutes;
    private long seconds;

    public GameTimer(){
        timer = new Timer();
        timerLabel = new JLabel();
    }

    public void startTimer(){
        startTime = LocalTime.now();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalTime now = LocalTime.now();
                Duration duration = Duration.between(startTime, now);
                timerLabel.setText(
                        String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutes()%60, duration.getSeconds()%60)
                );
                hours = duration.toHours();
                minutes = duration.toMinutes()%60;
                seconds = duration.getSeconds()%60;
            }
        }, 0, 1000);
    }

    public void stopTimer(){
        timer.cancel();
        timer = new Timer();
    }

    public JLabel getTimerLabel(){
        return timerLabel;
    }

    public String getEndTime(){
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
