package library.system;

import configuration.models.AppSetting;

public class Sleep {

    public static void defaultTime() {
        sleep(AppSetting.getInstance().getTimeSleep().defaultTime);
    }

    public static void refreshTime() {
        sleep(AppSetting.getInstance().getTimeSleep().refreshTime);
    }

    public static void longTime() {
        sleep(AppSetting.getInstance().getTimeSleep().longTime);
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
