package library.system;

import configuration.managers.AppSettingManager;

public class Sleep {

    public static void defaultTime() {
        sleep(AppSettingManager.getInstance().getTimeSleep().defaultTime);
    }

    public static void refreshTime() {
        sleep(AppSettingManager.getInstance().getTimeSleep().refreshTime);
    }

    public static void longTime() {
        sleep(AppSettingManager.getInstance().getTimeSleep().longTime);
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
