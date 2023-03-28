package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingSearchPage extends BasePage {

    private final static By SEARCH_LINE = By.cssSelector("[name=ss]");
    private final static By SEARCH_BUTTON = By.cssSelector("button[type=submit]");
    private final static String DROPDOWN_OPTION = "//div[text()='%s']//parent::div";

    public void open () {
        driver.get("https://www.booking.com/searchresults.en-gb.html");
    }

    public void searchForTheHotel(String value) {
        driver.findElement(SEARCH_LINE).sendKeys(value);
    }

    public void choiceDropdownOption(String value)  {
        driver.findElement(By.xpath(String.format(DROPDOWN_OPTION, value))).click();
    }

    public void clickSearchButton() {
        driver.findElement(SEARCH_BUTTON).click();
    }

    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }
}