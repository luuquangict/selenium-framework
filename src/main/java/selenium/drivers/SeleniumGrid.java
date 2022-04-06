package selenium.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {
    public static WebDriver start(String gridHubUrl, DesiredCapabilities capabilities) {
        try {
            WebDriver driver = new RemoteWebDriver(new URL(gridHubUrl), capabilities);
            return new Augmenter().augment(driver);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
