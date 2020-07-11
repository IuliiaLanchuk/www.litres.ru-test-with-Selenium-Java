package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends Page {
    private static final String TITLE_SELECTOR = "div.art__name>a";
    private static final String AUTHOR_SELECTOR = "div.art__author>a";
    private static final String PRICE_SELECTOR = "div.buy-msg-amount__new";
    private static final String BUY_AND_SAFE_BUTTON_SELECTOR = "button.btn.btn_green.btn_buy";

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice() {
        waitForElementVisibility(By.cssSelector(PRICE_SELECTOR));
        return driver.findElement(By.cssSelector(PRICE_SELECTOR)).getText();
    }

    public Boolean isBuyAndSafeButtonDisplayed() {
        return driver.findElement(By.cssSelector(BUY_AND_SAFE_BUTTON_SELECTOR)).isDisplayed();
    }

    public String getTitle() {
        waitForElementVisibility(By.cssSelector(TITLE_SELECTOR));
        return driver.findElement(By.cssSelector(TITLE_SELECTOR)).getText();
    }

    public String getAuthor() {
        waitForElementVisibility(By.cssSelector(AUTHOR_SELECTOR));
        return driver.findElement(By.cssSelector(AUTHOR_SELECTOR)).getText();
    }
}
