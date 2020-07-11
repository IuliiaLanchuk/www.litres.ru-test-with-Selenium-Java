package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    private static final String URL = "https://www.litres.ru/";
    private static final String SEARCH_INPUT_SELECTOR = ".top_search_input";
    private static final String SEARCH_BUTTON_SELECTOR = "#go";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public void enterValueInSearchField(String value) {
        waitForElementVisibility(By.cssSelector(SEARCH_INPUT_SELECTOR));
        driver.findElement(By.cssSelector(SEARCH_INPUT_SELECTOR)).sendKeys(value);
    }

    public SearchResultsPage clickSearchButton() {
        waitForElementToBeClickable(By.cssSelector(SEARCH_BUTTON_SELECTOR));
        driver.findElement(By.cssSelector(SEARCH_BUTTON_SELECTOR)).click();
        return new SearchResultsPage(driver);
    }
}
