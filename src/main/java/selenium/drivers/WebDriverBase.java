package selenium.drivers;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverBase {
    public WebDriver webDriver;

    public WebDriver getDriver() {
        return webDriver;
    }
}
