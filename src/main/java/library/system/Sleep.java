package library.system;

import core.configurations.models.AppSettings;

public class Sleep {

    public static void defaultTime() {
        sleep(AppSettings.getInstance().getTimeSleep().defaultTime);
    }

    public static void refreshTime() {
        sleep(AppSettings.getInstance().getTimeSleep().refreshTime);
    }

    public static void longTime() {
        sleep(AppSettings.getInstance().getTimeSleep().longTime);
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
