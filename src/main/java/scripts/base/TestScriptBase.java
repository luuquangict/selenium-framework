package scripts.base;

import core.configurations.models.WebBrowser;
import core.testng.TestRunner;
import org.openqa.selenium.WebDriver;
import pageObjects.pages.PageCommon;
import pageObjects.pages.PageTestLession7;

public abstract class TestScriptBase extends TestRunner {
    public TestScriptBase(String name, String version, String osPlatform) {
        super(name, version, osPlatform);
    }

    protected PageCommon pageCommon;
    protected PageTestLession7 pageTestLession7;

    @Override
    protected final void beforeSetup(WebDriver webDriver, WebBrowser currentBrowser) {
        // Only create instance for page common here
        pageCommon = new PageCommon(webDriver, currentBrowser);
    }
}
