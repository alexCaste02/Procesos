package ejsdiapos.cronometro;

import javax.swing.*;
import java.util.Arrays;

public class ChronoTimer extends SwingWorker<String, Integer> {

    private int totalSeconds;
    private final JLabel timeLabel;
    private Timer t;

    public ChronoTimer(JLabel timeLabel) {
        this.timeLabel = timeLabel;
        t = new Timer(1000, e -> {
            this.totalSeconds++;
            timeLabel.setText(secondsToTime());
        });
    }



    @Override
    protected String doInBackground(){
        t = new Timer(1000, e -> {
            totalSeconds++;
            timeLabel.setText(secondsToTime());
        });
        return "Timer process started!";
    }

    public void startTimer() {
        totalSeconds = timeToSeconds();
        t.start();
    }

    private String secondsToTime(){
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private int timeToSeconds() {
        int seconds = 0;
        String[] timeUnits = timeLabel.getText().split(":");
        System.out.println(Arrays.toString(timeUnits));
        seconds += Integer.parseInt(timeUnits[0])*3600;
        seconds += Integer.parseInt(timeUnits[1])*60;
        seconds += Integer.parseInt(timeUnits[2]);
        return seconds;

    }

    public void stopTimer(){
        t.stop();
        timeLabel.setText("00:00:00");
    }

    public void pauseTimer(){
        t.stop();
    }


}
