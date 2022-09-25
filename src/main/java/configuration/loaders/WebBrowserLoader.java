package configuration.loaders;

import configuration.models.WebBrowserSetting;

public class WebBrowserLoader extends BaseLoader<WebBrowserSetting> {

    public WebBrowserLoader(Class<WebBrowserSetting> typeOfT) {
        super(typeOfT);
    }

    @Override
    protected String getFileName() {
        return "configuration/browsers.%s.json";
    }
}
