package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForElementVisibility(By locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementToBeClickable(By locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(locator));
    }
}
