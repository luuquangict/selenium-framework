package pageObjects.pages;

import core.configurations.models.WebBrowser;
import core.selenium.PageObjectBase;
import library.system.Sleep;
import org.openqa.selenium.WebDriver;
import pageObjects.constants.locators.PageCommonLocator;

public class PageCommon extends PageObjectBase {

    public PageCommon(WebDriver webDriver, WebBrowser currentBrowser) {
        super(webDriver, currentBrowser);
    }

    public PageCommon(WebDriver webDriver, WebBrowser currentBrowser, PageCommon pageCommon) {
        super(webDriver, currentBrowser, pageCommon);
    }

    public void ClickButtonByName(String name) {
        Sleep.refreshTime();
        clickElement(PageCommonLocator.buttonByLabel.addParams(name));
    }
}
