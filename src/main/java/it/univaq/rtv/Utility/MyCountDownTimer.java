package it.univaq.rtv.Utility;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.TimerTask;

public class MyCountDownTimer extends TimerTask{
    private Label clock;
    private static final Integer STARTTIME= 60;
    private Integer timeSeconds =STARTTIME;


    /**
     * @param clock
     */
    public MyCountDownTimer(Label clock) {
        this.clock = clock;
    }

    @Override
    public void run() {
        timeSeconds--;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println(timeSeconds.toString());
                 clock.setText("Time to End = " + timeSeconds.toString());
                 if (timeSeconds <= 0){
                     timeSeconds = STARTTIME;
                     cancel();
                 }
            }
        });
    }
}


