package fi.joonasil.minesweeper.gui.timer;

import fi.joonasil.minesweeper.other.MineFactory;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Timer {
    int sec;
    int min;
    int hour;
    Timeline timer;
    
    public Timer() {
        sec = 0;
        min = 0;
        hour = 0;
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                    increase();
                    MineFactory.getScreen().setTime(toString());
                }));
        timer.setCycleCount(Timeline.INDEFINITE);
    }
    
    public void increase() {
        sec ++;
        sec %= 60;
        if (sec == 0) {
            min++;
            min %= 60;
            if (min == 0) {
                hour++;
            }
        }   
    }
    
    public void play() {
        if (timer.getStatus() != Status.RUNNING) {
            timer.play();   
        }
    }
    
    public void pause() {
        timer.pause();
    }
    
    public void stop() {
        timer.stop();
    }
    
    public void reset() {
        timer.stop();
        sec = 0;
        min = 0;
        hour = 0;
    }
    
    public int getTime() {
        int time = (hour*60 + min)*60 + sec;
        return time;
    }
    
    @Override
    public String toString() {
        String s = "";
        if (hour < 10) {
            s += "0";
        }
        s += hour + ":";
        if (min < 10) {
            s += "0";
        }
        s += min + ":";
        if (sec < 10) {
            s += "0";
        }
        s += sec;
        return s;
    }
}
