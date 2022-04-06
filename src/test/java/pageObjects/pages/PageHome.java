package pageObjects.pages;

import configuration.models.WebBrowser;
import pageObjects.base.PageObjectBase;
import org.openqa.selenium.WebDriver;

public class PageHome extends PageObjectBase {

    public PageHome(WebDriver webDriver, WebBrowser currentBrowser) {
        super(webDriver, currentBrowser);
    }

    public PageHome(WebDriver webDriver, WebBrowser currentBrowser, PageCommon pageCommon) {
        super(webDriver, currentBrowser, pageCommon);
    }
}