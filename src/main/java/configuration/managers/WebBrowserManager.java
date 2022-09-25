package configuration.managers;

import configuration.loaders.WebBrowserLoader;
import configuration.models.WebBrowserSetting;

public class WebBrowserManager {
    private static WebBrowserSetting instance;

    public static WebBrowserSetting getInstance() {
        if (instance == null) {
            WebBrowserLoader loader = new WebBrowserLoader(WebBrowserSetting.class);
            instance = loader.load();
        }

        return instance;
    }
}
