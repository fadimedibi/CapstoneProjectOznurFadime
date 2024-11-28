package pages;


import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//li[@id='menu-item-103']//a[span[text()='Microsoft 365']]")
    public WebElement microsoft365Link;

    @FindBy (id = "i0116")
    public WebElement emailBox;

    @FindBy (id = "i0118")
    public WebElement passwordBox;

    @FindBy (id = "idSIButton9")
    public WebElement nextButton;

    @FindBy (css = "[value='Sign in']")
    public WebElement sign_inButton;

    @FindBy (id = "idBtn_Back")
    public WebElement NoButton;

    @FindBy(xpath = "//button[@id='O365_MainLink_Me']")
    public WebElement initialsButton;

    @FindBy(id = "mectrl_body_signOut")
    public WebElement signOut;

    @FindBy (id = "idA_PWD_ForgotPassword")
    public WebElement forgotPassword;


    public void switchToChildWindow(){
        Set<String> set = Driver.get().getWindowHandles();
        List<String> list = new ArrayList<>(set);
        Driver.get().getWindowHandle();
        String childWindow = list.get(1);
        Driver.get().switchTo().window(childWindow);
    }
}
