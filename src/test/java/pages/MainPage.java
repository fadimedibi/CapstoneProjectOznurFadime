package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;
import utilities.ReusableMethods;

public class MainPage extends BasePage {
    @FindBy(className = "fusion-logo-link")
    public WebElement logo;

    @FindBy(xpath = "(//span[@class='menu-text'])[6]")
    public WebElement giftShop;

    @FindBy(xpath = "//div[@class='fusion-text fusion-text-8 footer-oswald']//a[@href='https://goo.gl/maps/5uuYV2VZQwrrCcX79']")
    public WebElement contactInf;

    @FindBy(xpath = "//input[@class='ubermenu-search-input']")
    public WebElement searchBox;

    @FindBy(xpath = "//h2[@class='entry-title fusion-post-title fusion-responsive-typography-calculated']//a[1]")
    public static WebElement searchResultsLink;

    @FindBy(xpath = "//h1[contains(text(),'Need a new search?')]")
    public WebElement searchResults;

    @FindBy(xpath = "//input[@class='ubermenu-search-submit']")
    public WebElement searchSubmit;

    @FindBy(xpath = "//h1[contains(text(),'Oops!')]")
    public WebElement warningMessage;

    public void searchBox(String string) {
        searchBox.sendKeys(string);
        ReusableMethods.wait(3);
        searchSubmit.click();
        ReusableMethods.wait(5);
    }

    public void checkTitleInNewWindow(String string) {
        searchResultsLink.click();
        // Get the title of the new window
        String newWindowTitle = Driver.get().getTitle().toLowerCase();
        System.out.println("New window title: " + newWindowTitle);

        // Assert the title contains the expected string
        if (!newWindowTitle.contains(string)) {
            throw new AssertionError("Title does not contain '" + string + "'");
        }
    }
}
