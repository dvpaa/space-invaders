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
        startTime = LocalTime.now(); // 타이머 시작시 시간 설정
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalTime now = LocalTime.now(); // 현재 시간 설정
                Duration duration = Duration.between(startTime, now); // 현재 시간 - 시작 시간 = 경과 시간
                timerLabel.setText(
                        String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutes()%60, duration.getSeconds()%60)
                ); // 경과 시간을 레이블에 표시
                hours = duration.toHours();
                minutes = duration.toMinutes()%60;
                seconds = duration.getSeconds()%60; // 경과 시간을 변수에 저장
            }
        }, 0, 1000); // 1초마다 실행
    }

    public void stopTimer(){
        timer.cancel(); // 타이머 종료
        timer = new Timer(); // 타이머 초기화
    }

    public JLabel getTimerLabel(){
        return timerLabel;
    } // 타이머 레이블 반환

    public String getEndTime(){
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    } // 경과 시간 반환
}