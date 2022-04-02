package core.configurations;

import com.google.gson.Gson;
import core.configurations.models.AppSettings;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

public final class AppSettingLoader extends BaseLoader {

    public AppSettings load() {
        try {
            URL fileName = getAppSettingFileName();
            Gson gson = new Gson();
            File file = new File(fileName.toURI());
            Reader reader = Files.newBufferedReader(file.toPath());
            return gson.fromJson(reader, AppSettings.class);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        Assert.fail("Could not load app settings");
        return null;
    }

    private URL getAppSettingFileName() {
        String fileName = String.format("configurations/appsettings-%s.json", getEnvironmentName());
        return getResourceFileName(fileName);
    }
}
