package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SeleniumTextExtractor_OpenAI extends BasePage {
    @FindBy(linkText = "NAU Portal")
    public WebElement NAUPortal;

    public static List<String> getTextsByXpath(WebDriver driver, String xpath) {
        return driver.findElements(By.xpath(xpath))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public static List<String> getTabTexts(WebDriver driver) {
        return getTextsByXpath(driver, "//div[@id='header-tabs']//a");
    }

    public static List<String> getCustomContentPortlets(WebDriver driver) {
        return getTextsByXpath(driver, "//*[@id=\"pg1_CustomContentPortlet\"]/div[2]/div[1]/div/div/div/div");
    }

    public static List<String> getQuickLinkTexts(WebDriver driver) {
        return getTextsByXpath(driver, "//div[@id='foot']//a");
    }
}