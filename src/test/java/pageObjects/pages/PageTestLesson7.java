package pageObjects.pages;

import configuration.models.WebBrowser;
import pageObjects.base.PageObjectBase;
import library.system.Sleep;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.constants.locators.PageTestLesson7Locator;
import pageObjects.constants.texts.ButtonName;

public class PageTestLesson7 extends PageObjectBase {
    public PageTestLesson7(WebDriver webDriver, WebBrowser currentBrowser) {
        super(webDriver, currentBrowser);
    }

    public PageTestLesson7(WebDriver webDriver, WebBrowser currentBrowser, PageCommon pageCommon) {
        super(webDriver, currentBrowser, pageCommon);
    }

    public void clickOnButton1() {
        Sleep.refreshTime();
        pageCommon.ClickButtonByName(ButtonName.BUTTON1);
        Sleep.longTime();
    }

    public void verifyTextAfterClickButton1() {
        Sleep.refreshTime();
        String value = getText(PageTestLesson7Locator.lbStatusButton);
        Assert.assertEquals(value, "Click on Button 1");
    }
}
