package Squad_Fitness.Java;

import javafx.application.Platform;
import javafx.scene.Scene;

import java.util.*;

public class CssChanger {

    static Timer morningTimer;
    static Timer afternoonTimer;

    static String morningCss = "Squad_Fitness/CSS/GUI.css";
    static String afternoonCss = "Squad_Fitness/CSS/nightTime.css";

    public static void setInitalStyleSheet(Scene scene) {
        Date currentTime = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(currentTime);
        cal.set(Calendar.HOUR_OF_DAY, 18);
        cal.set(Calendar.MINUTE, 30);

        if(cal.getTime().after(currentTime)) {
            cal.set(Calendar.HOUR_OF_DAY, 7);
            if(cal.getTime().after(currentTime)) {
                scene.getStylesheets().add(afternoonCss);
            } else {
                scene.getStylesheets().add(morningCss);
            }
        } else {
            scene.getStylesheets().add(afternoonCss);
        }
    }

    public static void morningTrigger(final Scene scene) {
        Date triggerTime = getTriggerTime(true);

        morningTimer = new Timer(true);
        morningTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        scene.getStylesheets().removeAll();
                        scene.getStylesheets().add(morningCss);
                    }
                });
            }
        }, triggerTime);
    }

    public static void afternoonTrigger(final Scene scene) {

        Date triggerTime = getTriggerTime(false);

        afternoonTimer = new Timer(true);
        afternoonTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        scene.getStylesheets().removeAll();
                        scene.getStylesheets().add(afternoonCss);
                    }
                });
            }
        }, triggerTime);
    }

    public static Date getTriggerTime(Boolean morning) {
        int hour;
        if(morning) {
            hour = 7;
        } else {
            hour = 13;
        }

        Date currentTime = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(currentTime);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, 0);

        if(cal.getTime().before(currentTime)) {
            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
        }

        return cal.getTime();
    }
}
