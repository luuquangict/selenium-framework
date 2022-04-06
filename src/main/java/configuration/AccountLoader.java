package configuration;

import com.google.gson.Gson;
import configuration.models.AccountSetting;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

public class AccountLoader extends BaseLoader {

    public AccountSetting load() {
        try {
            URL fileName = getAccountFileName();
            Gson gson = new Gson();
            File file = new File(fileName.toURI());
            Reader reader = Files.newBufferedReader(file.toPath());
            return gson.fromJson(reader, AccountSetting.class);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        Assert.fail("Could not load account settings");
        return null;
    }

    private URL getAccountFileName() {
        String fileName = String.format("configuration/accounts-%s.json", getEnvironmentName());
        return getResourceFileName(fileName);
    }
}
