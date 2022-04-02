package core.configurations;

import com.google.gson.Gson;
import core.configurations.models.WebBrowser;
import core.configurations.models.WebBrowserSettings;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

public class WebBrowserLoader extends BaseLoader {

    public WebBrowserSettings load() {
        try {
            URL fileName = getWebBrowserFileName();
            Gson gson = new Gson();
            File file = new File(fileName.toURI());
            Reader reader = Files.newBufferedReader(file.toPath());
            return gson.fromJson(reader, WebBrowserSettings.class);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        Assert.fail("Could not load browser setting");
        return null;
    }

    private URL getWebBrowserFileName() {
        String fileName = String.format("configurations/browsers-%s.json", getEnvironmentName());
        return getResourceFileName(fileName);
    }
}
