package tests;

import businessObjects.Book;
import pages.BasketPage;
import pages.BookPage;
import pages.HomePage;
import pages.SearchResultsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BookOverviewTest extends BaseTest {
    private static final Book HARRY_POTTER_BOOK = new Book("Гарри Поттер и философский камень", "Дж. К. Роулинг", "249 ₽");

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private BookPage bookPage;
    private BasketPage basketPage;


    @Test
    public void overviewBook() {
        homePage = new HomePage(driver);
        homePage.open();
        homePage.enterValueInSearchField(HARRY_POTTER_BOOK.getTitle());
        searchResultsPage = homePage.clickSearchButton();
        bookPage = searchResultsPage.clickOnFirstResult();

        Assert.assertEquals(bookPage.getTitle().replace("ТЕКСТ", ""), HARRY_POTTER_BOOK.getTitle());
        Assert.assertEquals(bookPage.getAuthor(), HARRY_POTTER_BOOK.getAuthor());
        Assert.assertEquals(bookPage.getPrice(), HARRY_POTTER_BOOK.getPrice());
        Assert.assertTrue(bookPage.isBuyButtonDisplayed());
    }

    @Test
    public void addBookToBasket() {
        homePage = new HomePage(driver);
        homePage.open();
        homePage.enterValueInSearchField(HARRY_POTTER_BOOK.getTitle());
        searchResultsPage = homePage.clickSearchButton();
        bookPage = searchResultsPage.clickOnFirstResult();
        bookPage.clickToPutInBasket();
        bookPage.clickDisplay();
        bookPage.clickToMyBooks();
        basketPage = bookPage.clickToBasketFromMyBooks();

        Assert.assertEquals(basketPage.getPrice(), HARRY_POTTER_BOOK.getPrice());
        Assert.assertTrue(basketPage.isBuyAndSafeButtonDisplayed());
        Assert.assertEquals(basketPage.getTitle().replace("\n", " "), HARRY_POTTER_BOOK.getTitle());
        Assert.assertEquals(basketPage.getAuthor(), HARRY_POTTER_BOOK.getAuthor());

    }
}
