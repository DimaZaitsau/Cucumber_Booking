package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BookingResultsPage;
import pages.BookingSearchPage;

import java.util.concurrent.TimeUnit;

public class SearchSteps {
    WebDriver driver;
    BookingSearchPage bookingSearchPage;
    BookingResultsPage bookingResultsPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        bookingSearchPage = new BookingSearchPage(driver);
        bookingResultsPage = new BookingResultsPage(driver);
    }

    @After
    public void tearDown()  {
        driver.quit();
    }

    @Given("I am at booking.com page")
    public void navigateToBookingWebsite()  {
        bookingSearchPage.open();
    }

    @When("I set {string} in the search bar")
    public void iClickHiltonHeadIsIslandInTheDropdownMenu(String value) {
        bookingSearchPage.searchForTheHotel(value);
    }

    @And("I click {string} in the dropdown menu")
    public void iClickHiltonHeadIslandInTheDropdownMenu(String value)   {
        bookingSearchPage.choiceDropdownOption(value);
    }

    @And("I click the search button")
    public void iClickTheSearchButton() {
        bookingSearchPage.clickSearchButton();
    }

    @Then("{string} should be present under index {int}")
    public void theWestinHiltonHeadIsIslandResortSpaShouldBePresent(String value, int index)   {
        String hotelName = bookingResultsPage.getHotelNameByIndex(index);
        Assert.assertTrue(hotelName.equals(value));
    }

    @Then("The hotel under index {int} should have score {string}")
    public void theHotelShouldHaveScore(int index, String score)   {
        String hotelScore = bookingResultsPage.getScoreOfTheHotelByIndex(index);
        Assert.assertTrue(hotelScore.equals(score));
    }
}
