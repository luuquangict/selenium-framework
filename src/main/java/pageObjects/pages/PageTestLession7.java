package pageObjects.pages;

import core.configurations.models.WebBrowser;
import core.selenium.PageObjectBase;
import library.system.Sleep;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.constants.locators.PageTestLession7Locator;
import pageObjects.constants.texts.ButtonNames;

public class PageTestLession7 extends PageObjectBase {
    public PageTestLession7(WebDriver webDriver, WebBrowser currentBrowser) {
        super(webDriver, currentBrowser);
    }

    public PageTestLession7(WebDriver webDriver, WebBrowser currentBrowser, PageCommon pageCommon) {
        super(webDriver, currentBrowser, pageCommon);
    }

    public void clickOnButton1() {
        Sleep.refreshTime();
        pageCommon.ClickButtonByName(ButtonNames.BUTTON1);
        Sleep.longTime();
    }

    public void verifyTextAfterClickButton1() {
        Sleep.refreshTime();
        String value = getTextValue(PageTestLession7Locator.lbStatusButton);
        Assert.assertEquals(value, "Bạn vừa click vào button 1 nè");
    }
}
