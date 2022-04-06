package selenium.drivers;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariWebDriver extends WebDriverBase {
    private SafariOptions options;

    public SafariWebDriver() {
        options = new SafariOptions();
        super.webDriver = new SafariDriver(options);
    }

    public static SafariWebDriver getNewInstance() {
        return new SafariWebDriver();
    }
}
