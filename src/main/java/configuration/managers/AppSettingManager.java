package configuration.managers;

import configuration.loaders.AppSettingLoader;
import configuration.models.AppSetting;

public class AppSettingManager {
    private static AppSetting instance;

    public static AppSetting getInstance() {
        if (instance == null) {
            AppSettingLoader loader = new AppSettingLoader(AppSetting.class);
            instance = loader.load();
        }
        return instance;
    }
}
