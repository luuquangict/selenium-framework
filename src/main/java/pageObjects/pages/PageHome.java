package pageObjects.pages;

import core.configurations.models.WebBrowser;
import core.selenium.PageObjectBase;
import library.system.Sleep;
import org.openqa.selenium.WebDriver;

public class PageHome extends PageObjectBase {

    public PageHome(WebDriver webDriver, WebBrowser currentBrowser) {
        super(webDriver, currentBrowser);
    }

    public PageHome(WebDriver webDriver, WebBrowser currentBrowser, PageCommon pageCommon) {
        super(webDriver, currentBrowser, pageCommon);
    }
}