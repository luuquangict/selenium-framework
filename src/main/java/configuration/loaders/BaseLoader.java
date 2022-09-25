package configuration.loaders;

import com.google.gson.Gson;
import common.AppConstants;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

public abstract class BaseLoader<T> {

    private Class<T> typeOfT;

    public BaseLoader(Class<T> typeOfT) {
        this.typeOfT = typeOfT;
    }

    public T load() {
        try {
            URL fileName = getFileNameUrl();
            Gson gson = new Gson();
            File file = new File(fileName.toURI());
            Reader reader = Files.newBufferedReader(file.toPath());
            return gson.fromJson(reader, typeOfT);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        Assert.fail("Could not load account settings");
        return null;
    }

    protected abstract String getFileName();

    private URL getFileNameUrl() {
        String fileName = String.format(getFileName(), getEnvironmentName());
        return getResourceFileName(fileName);
    }

    private String getEnvironmentName() {
        String name = System.getenv(AppConstants.ENVIRONMENT_VARIABLE_NAME);
        if (name == null)
            return "dev";

        return name;
    }

    private URL getResourceFileName(String filename) {
        ClassLoader classLoader = BaseLoader.class.getClassLoader();
        return classLoader.getResource(filename);
    }
}
