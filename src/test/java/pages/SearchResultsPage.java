package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends Page {
    private static final String SEARCH_RESULTS_TITLES_SELECTOR = ".art-item__name a";

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public BookPage clickOnFirstResult() {
        waitForElementToBeClickable(By.cssSelector(SEARCH_RESULTS_TITLES_SELECTOR));
        driver.findElements(By.cssSelector(SEARCH_RESULTS_TITLES_SELECTOR)).get(0).click();
        return new BookPage(driver);
    }
}
