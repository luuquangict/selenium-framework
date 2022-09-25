package testng;

import configuration.managers.AccountManager;
import configuration.managers.AppSettingManager;
import configuration.managers.WebBrowserManager;
import configuration.models.WebBrowser;
import selenium.drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;

public abstract class TestRunner {

    protected AccountManager accountManager;
    private final WebBrowser currentBrowser;
    private WebDriver webDriver;

    public TestRunner(String name, String version, String osPlatform) {
        System.out.println(String.format("Browser = {name=%s, version=%s, osPlatform=%s}", name, version, osPlatform));
        this.currentBrowser = new WebBrowser(name, version, osPlatform);
    }

    @BeforeMethod
    public void beforeRun() {
        System.out.println(this.currentBrowser);
        System.out.println("Initialize new browser");
        this.webDriver = WebDriverFactory.initialize(currentBrowser);

        // TODO: Get testcase information here

        // Goto home page URL
        if (AppSettingManager.getInstance().getWebUrl() == null) {
            Assert.fail("Home page url is invalid");
        }
        System.out.println("Goto URL: " + AppSettingManager.getInstance().getWebUrl());
        this.webDriver
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(AppSettingManager.getInstance().getTimeOut().pageLoaded));
        this.webDriver.get(AppSettingManager.getInstance().getWebUrl());
        this.webDriver
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(AppSettingManager.getInstance().getTimeOut().findElement));

        // Initialize page
        this.accountManager = AccountManager.getInstance();
        beforeSetup(this.webDriver, this.currentBrowser);
        setup(this.webDriver, this.currentBrowser);
    }

    @AfterMethod
    public void afterRun() {
        try {
            cleanUp();
            if (AppSettingManager.getInstance().getOptions().quitDriver) {
                webDriver.quit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void beforeSetup(WebDriver webDriver, WebBrowser currentBrowser) {
    }

    protected abstract void setup(WebDriver webDriver, WebBrowser currentBrowser);

    @Test
    protected abstract void run();

    protected abstract void cleanUp();

    @DataProvider
    protected static Iterator<Object[]> dataProvider() {
        // Load app settings
        AppSettingManager.getInstance();

        // Load browser settings
        return WebBrowserManager
                .getInstance()
                .getEnableWebBrowsers()
                .iterator();
    }
}
