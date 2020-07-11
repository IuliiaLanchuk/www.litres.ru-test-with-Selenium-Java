package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookPage extends Page {
    private static final String TITLE_SELECTOR = ".biblio_book_name";
    private static final String AUTHOR_SELECTOR = ".biblio_book_author__link";
    private static final String PRICE_SELECTOR = ".a_buyany > .simple-price";
    private static final String BUY_BUTTON_SELECTOR = ".a_buyany";
    private static final String BASKET_BUTTON_SELECTOR = "a.art-button.art-buttons__basket";
    private static final String BUTTON_MY_BOOKS_SELECTOR = "div.btn__content";
    private static final String BUTTON_BASKET_FROM_MY_BOOKS_SELECTOR = "li#my-books-list__basket";
    private static final String CLICK_DISPLAY_SELECTOR = "div#promo-books-popup.promo-books-popup>a";

    public BookPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        waitForElementVisibility(By.cssSelector(TITLE_SELECTOR));
        return driver.findElement(By.cssSelector(TITLE_SELECTOR)).getText();
    }

    public String getAuthor() {
        waitForElementVisibility(By.cssSelector(AUTHOR_SELECTOR));
        return driver.findElement(By.cssSelector(AUTHOR_SELECTOR)).getText();
    }

    public String getPrice() {
        waitForElementVisibility(By.cssSelector(PRICE_SELECTOR));
        return driver.findElement(By.cssSelector(PRICE_SELECTOR)).getText();
    }

    public void clickToPutInBasket() {
        waitForElementVisibility(By.cssSelector(BASKET_BUTTON_SELECTOR));
        driver.findElement(By.cssSelector(BASKET_BUTTON_SELECTOR)).click();
    }

    public void clickToMyBooks() {
        waitForElementVisibility(By.cssSelector(BUTTON_MY_BOOKS_SELECTOR));
        driver.findElement(By.cssSelector(BUTTON_MY_BOOKS_SELECTOR)).click();
    }

    public BasketPage clickToBasketFromMyBooks() {
        waitForElementVisibility(By.cssSelector(BUTTON_BASKET_FROM_MY_BOOKS_SELECTOR));
        driver.findElement(By.cssSelector(BUTTON_BASKET_FROM_MY_BOOKS_SELECTOR)).click();
        return new BasketPage(driver);
    }

    public void clickDisplay() {
        waitForElementVisibility(By.cssSelector(CLICK_DISPLAY_SELECTOR));
        driver.findElement(By.cssSelector(CLICK_DISPLAY_SELECTOR)).click();
    }

    public Boolean isBuyButtonDisplayed() {
        return driver.findElement(By.cssSelector(BUY_BUTTON_SELECTOR)).isDisplayed();
    }
}
