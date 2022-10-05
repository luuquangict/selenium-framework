package pageObjects.pages;

import configuration.managers.AccountManager;
import configuration.models.Account;
import configuration.models.WebBrowser;
import library.system.Sleep;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.base.PageObjectBase;
import pageObjects.constants.locators.PageTestLesson7Locator;
import pageObjects.constants.texts.ButtonName;

public class PageLogin extends PageObjectBase {
    public PageLogin(WebDriver webDriver, WebBrowser currentBrowser) {
        super(webDriver, currentBrowser);
    }

    public PageLogin(WebDriver webDriver, WebBrowser currentBrowser, PageCommon pageCommon) {
        super(webDriver, currentBrowser, pageCommon);
    }


    public void enterUsername(String username) {

    }

    public void enterUsername(Account account) {

    }
}