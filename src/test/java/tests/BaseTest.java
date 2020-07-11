package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static WebDriver driver;
    private static final String CHROME_PATH = "src/test/resources/chromedriver.exe";

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        driver = null;
    }
}
