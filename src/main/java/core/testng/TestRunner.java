package core.testng;

import core.configurations.models.AccountSettings;
import core.configurations.models.AppSettings;
import core.configurations.models.WebBrowser;
import core.configurations.models.WebBrowserSettings;
import core.selenium.drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.pages.PageCommon;

import java.util.Iterator;

public abstract class TestRunner {

    protected final WebBrowser currentBrowser;
    protected WebDriver webDriver;
    protected PageCommon pageCommon;
    protected AccountSettings accounts;

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

        if (AppSettings.getInstance().getWebUrl() == null) {
            Assert.fail("Home page url is invalid");
        }

        System.out.println("Goto URL: " + AppSettings.getInstance().getWebUrl());
        this.webDriver.get(AppSettings.getInstance().getWebUrl());

        // Initialize page
        this.accounts = AccountSettings.getInstance();
        this.pageCommon = new PageCommon(this.webDriver, this.currentBrowser);
        setup();
    }

    @AfterMethod
    public void afterRun() {
        try {
            cleanUp();
            if (AppSettings.getInstance().getOptions().quitDriver) {
                webDriver.quit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected abstract void setup();

    @Test
    protected abstract void run();

    protected abstract void cleanUp();

    @DataProvider
    protected static Iterator<Object[]> dataProvider() {
        // Load app settings
        AppSettings.getInstance();

        // Load browser settings
        return WebBrowserSettings
                .getInstance()
                .getEnableWebBrowsers()
                .iterator();
    }
}
