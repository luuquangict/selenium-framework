package selenium.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxWebDriver extends WebDriverBase {
    private FirefoxOptions options;

    public FirefoxWebDriver() {
        options = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        super.webDriver = new FirefoxDriver(options);
    }

    public static FirefoxWebDriver getNewInstance() {
        return new FirefoxWebDriver();
    }
}
