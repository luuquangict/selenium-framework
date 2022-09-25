package configuration.loaders;

import configuration.models.AppSetting;

public final class AppSettingLoader extends BaseLoader<AppSetting> {

    public AppSettingLoader(Class<AppSetting> typeOfT) {
        super(typeOfT);
    }

    @Override
    protected String getFileName() {
        return "configuration/app-settings.%s.json";
    }
}
