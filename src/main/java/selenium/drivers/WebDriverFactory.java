package selenium.drivers;

import configuration.models.WebBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WebDriverFactory {

    public static WebDriver initialize(WebBrowser browser) {

        // TODO: Implement selenium grid here

        switch (browser.getType()) {
            case Chrome:
                return ChromeWebDriver.getNewInstance().getDriver();
            case Firefox:
                return FirefoxWebDriver.getNewInstance().getDriver();
            case Safari:
                return SafariWebDriver.getNewInstance().getDriver();

            default: {
                Assert.fail("Unknown web browser");
                return null;
            }
        }
    }
}
