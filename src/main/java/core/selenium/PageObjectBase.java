package core.selenium;

import core.configurations.models.WebBrowser;
import core.common.StringUtils;
import core.selenium.models.ILocator;
import core.selenium.models.Locator;
import library.system.Sleep;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.pages.PageCommon;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PageObjectBase {
    private final WebDriver webDriver;
    protected final WebBrowser currentBrowser;
    protected PageCommon pageCommon;

    public PageObjectBase(WebDriver webDriver, WebBrowser currentBrowser) {
        this.webDriver = webDriver;
        this.currentBrowser = currentBrowser;
    }

    public PageObjectBase(WebDriver webDriver, WebBrowser currentBrowser, PageCommon pageCommon) {
        this.webDriver = webDriver;
        this.currentBrowser = currentBrowser;
        this.pageCommon = pageCommon;
    }

    //===================================================
    // PRIVATE METHODS
    //===================================================

    private WebElement getWebElement(ILocator locator) {
        try {
            return webDriver.findElement(locator.getBy());
        } catch (Exception e) {
            return null;
        }
    }

    private List<WebElement> getWebElements(ILocator locator) {
        try {
            return webDriver.findElements(locator.getBy());
        } catch (NoSuchElementException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private boolean hasAttribute(WebElement element, String attr) {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        return (boolean) executor.executeScript("return arguments[0].hasAttribute('" + attr + "');",
                element);
    }

    private String getTextValueOfElement(WebElement element) {
        String value = element.getAttribute("value");
        if (StringUtils.isNullOrEmpty(value)) {
            value = element.getAttribute("textContent");
        }

        return value.trim();
    }

    private void sendKey(WebElement element, Keys key, int time) {
        for (int i = 0; i < time; i++) {
            element.sendKeys(key);
        }
    }

    //===================================================
    // PROTECTED METHODS
    //===================================================

    protected int countElement(ILocator locator) {
        return getWebElements(locator).size();
    }

    protected String getTextValue(ILocator locator) {
        WebElement element = getWebElement(locator);
        return getTextValueOfElement(element);
    }

    protected String getAttribute(ILocator locator, String attr) {
        WebElement element = this.getWebElement(locator);
        return element.getAttribute(attr);
    }

    //=========================================================
    // Check element
    //=========================================================

    protected boolean hasAttribute(ILocator locator, String attr) {
        WebElement element = this.getWebElement(locator);
        return hasAttribute(element, attr);
    }

    protected boolean hasClass(ILocator locator, String name) {
        String[] classes = getAttribute(locator, "class").split(" ", 10);
        return Arrays.stream(classes).anyMatch(x -> x.trim().equals(name.trim()));
    }

    protected boolean isElementExisted(ILocator locator) {
        try {
            return getWebElements(locator).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementDisplayed(ILocator locator) {
        try {
            WebElement element = getWebElement(locator);
            if (element == null) {
                return false;
            }

            return element.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    protected boolean isElementEnabled(ILocator locator) {

        try {
            WebElement element = getWebElement(locator);
            if (element == null) {
                return false;
            }

            return element.isEnabled();
        } catch (Exception ex) {
            return false;
        }
    }

    protected boolean isElementClickable(ILocator locator) {
        try {
            WebElement element = getWebElement(locator);
            if (element == null) {
                return false;
            }

            return element.isEnabled() && element.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    //=========================================================
    // ACTIONS
    //=========================================================

    protected void clickElement(ILocator locator) {
        WebElement element = this.getWebElement(locator);
        waitElementClickable(locator, 20);
        element.click();
    }

    protected void clickElementJs(ILocator locator) {
        WebElement element = getWebElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected void enterText(ILocator locator, String value) {
        // Clear text before send key
        Sleep.refreshTime();
        clearText(locator);
        Sleep.refreshTime();

        // Send key
        WebElement element = getWebElement(locator);
        element.sendKeys(value);
    }

    public void enterTextJs(ILocator locator, String text) {
        WebElement element = this.getWebElement(locator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].value=arguments[1]", element, text);
    }

    protected void clearText(ILocator locator) {
        WebElement element = getWebElement(locator);
        switch (currentBrowser.getOsPlatform()) {
            case Mac: {
                element.clear();
                element.sendKeys(Keys.NUMPAD1);
                String text = this.getTextValueOfElement(element);
                sendKey(element, Keys.BACK_SPACE, text.length());
            }

            default: {
                element.clear();
                // Clear if not exec
                if (!StringUtils.isNullOrEmpty(getTextValueOfElement(element))) {
                    element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    element.sendKeys(Keys.BACK_SPACE);
                }
            }
        }
    }

    protected void scrollToTop() {
        scrollToElement(Locator.byTagName("body"));
    }

    protected void scrollToTop2() {
        Sleep.refreshTime();
        scrollPage(-10000);
        Sleep.refreshTime();
    }

    // ===================================================================================
    // WAIT
    // ===================================================================================

    protected void waitPageLoaded(int seconds) {
        ExpectedCondition<Boolean> expectation =
                driver -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .toString()
                        .equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Loading page unsuccessful ");
        }
    }

    protected boolean waitElementDisplayed(ILocator locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    getWebElement(locator).isDisplayed();
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        };
        return wait.until(condition);
    }

    protected boolean waitElementNotDisplayed(ILocator locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    return false == getWebElement(locator).isDisplayed();
                } catch (Exception e) {
                    return true;
                }
            }
        };

        return wait.until(condition);
    }

    protected boolean waitElementClickable(ILocator locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator.getBy()));
        return element != null;
    }

    // ===================================================================================
    // EXECUTE JAVASCRIPT
    // ===================================================================================

    protected void execJs(String js) {
        ((JavascriptExecutor) webDriver).executeScript(js);
    }

    protected void execJs(ILocator locator, String js) {
        ((JavascriptExecutor) webDriver).executeScript(js, getWebElement(locator));
    }

    protected String execJsResult(String js) {
        return (String) ((JavascriptExecutor) webDriver).executeScript(js);
    }

    protected String execJsResult(ILocator locator, String js) {
        return (String) ((JavascriptExecutor) webDriver).executeScript(js, getWebElement(locator));
    }

    protected void scrollPage(int position) {
        execJs(String.format("window.scrollBy(0, %s)", position));
    }

    protected void scrollToElement(ILocator locator) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();",
                getWebElement(locator));
    }

    protected void scrollToCenterElement(ILocator locator) {
        ((JavascriptExecutor) webDriver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", getWebElement(locator));
    }
}