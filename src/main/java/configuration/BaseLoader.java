package configuration;

import common.AppConstants;

import java.net.URL;

public abstract class BaseLoader {

    protected String getEnvironmentName() {
        String name = System.getenv(AppConstants.ENVIRONMENT_VARIABLE_NAME);
        if (name == null)
            return "dev";

        return name;
    }

    protected URL getResourceFileName(String filename) {
        ClassLoader classLoader = BaseLoader.class.getClassLoader();
        return classLoader.getResource(filename);
    }
}
