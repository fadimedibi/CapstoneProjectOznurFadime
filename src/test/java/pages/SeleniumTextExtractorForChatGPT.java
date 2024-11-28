package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class SeleniumTextExtractorForChatGPT extends BasePage {

    @FindBy(linkText = "NAU Portal")
    public WebElement NAUPortal;


    public static List<String> getTabTexts(WebDriver driver ){
        List<String> tabs = new ArrayList<>();

        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='header-tabs']//a"));

        for (WebElement element : elements) {
            tabs.add(element.getText());
        }
        return tabs;
    }

    public static List<String> getQuickLinkTexts(WebDriver driver ){
        List<String> quickLinks = new ArrayList<>();

        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='foot']//a"));

        for (WebElement element : elements) {
            quickLinks.add(element.getText());
        }
        return quickLinks;
    }

}