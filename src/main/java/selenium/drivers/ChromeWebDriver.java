package selenium.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriver extends WebDriverBase {
    private ChromeOptions options;

    public ChromeWebDriver() {
        options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        super.webDriver = new ChromeDriver(options);
    }

    public static ChromeWebDriver getNewInstance() {
        return new ChromeWebDriver();
    }
}
