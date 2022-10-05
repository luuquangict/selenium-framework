package scripts.base;

import configuration.models.WebBrowser;
import pageObjects.pages.PageLogin;
import testng.TestRunner;
import org.openqa.selenium.WebDriver;
import pageObjects.pages.PageCommon;
import pageObjects.pages.PageTestLesson7;

public abstract class TestScriptBase extends TestRunner {
    public TestScriptBase(String name, String version, String osPlatform) {
        super(name, version, osPlatform);
    }

    protected PageCommon pageCommon;
    protected PageTestLesson7 pageTestLesson7;
    protected PageLogin pageLogin;

    @Override
    protected final void beforeSetup(WebDriver webDriver, WebBrowser currentBrowser) {
        // Only create instance for page common here
        pageCommon = new PageCommon(webDriver, currentBrowser);
    }
}
