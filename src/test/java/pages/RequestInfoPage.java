package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;


public class RequestInfoPage extends BasePage {
    @FindBy(linkText = "Request Info")
    public WebElement requestInfo;

    @FindBy(xpath = "//h3[.='Admissions Information Request']")
    public WebElement requestInfoFormTitle;

    @FindBy(xpath = "//input[@id='tfa_546']")
    public WebElement requestInfoFirstName;

    @FindBy(xpath = "//input[@id='tfa_586']")
    public WebElement requestInfoLastName;

    @FindBy(xpath = "//input[@id='tfa_533']")
    public WebElement requestInfoEmail;

    @FindBy(xpath = "//input[@id='tfa_666']")
    public WebElement requestInfoRetypeEmail;

    @FindBy(xpath = "//input[@id='tfa_606']")
    public WebElement requestInfoMobilePhone;

    @FindBy(xpath = "//input[@id='tfa_587']")
    public WebElement requestInfoCity;

    @FindBy(xpath = "//input[@id='tfa_589']")
    public WebElement requestInfoState_Province;

    @FindBy(xpath = "//input[@id='tfa_591']")
    public WebElement requestInfoZip_PostalCode;

    @FindBy(xpath = "//input[@id='tfa_716']")
    public WebElement requestInfoCountry;

    @FindBy(id = "tfa_721[lookupField0")
    public WebElement requestInfoWhatSchool;

    @FindBy(xpath = "//select[@id='tfa_54']")
    public WebElement requestInfoStartYear;

    @FindBy(id = "tfa_50")
    public WebElement requestInfoStartTerm;

    @FindBy(xpath = "//input[@id='tfa_607']")
    public WebElement requestInfoProgram;

    @FindBy(id = "tfa_667")
    public WebElement requestInfoResidencyStatus;

    @FindBy(id = "tfa_263")
    public WebElement requestInfoCitizenship;

    @FindBy(xpath = "//input[@id='tfa_593']")
    public WebElement requestInfoTextMessageBox;

    @FindBy(id = "tfa_556")
    public WebElement requestInfoHowDidYouHear;

    @FindBy(xpath = "//input[@id='tfa_56']")
    public WebElement requestInfoAthlete;

    @FindBy(id = "tfa_596")
    public WebElement requestInfo_IamPlaying;

    @FindBy(xpath = "//input[@name='tfa_711']")
    public WebElement requestInfo_height;

    @FindBy(xpath = "//input[@name='tfa_711']")
    public WebElement requestInfo_weight;

    @FindBy(css = "  #submit_button")
    public WebElement requestInfoSubmitButton;

    @FindBy(css = ".recaptcha-checkbox-border")
    public WebElement requestInfoCaptcha;

    @FindBy(xpath = "//body/span[1]/div[1]/div[2]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/iframe[1]")
    public WebElement iframe;


    public void requestInfoFillOut() {
        requestInfoFirstName.sendKeys("John");
        requestInfoLastName.sendKeys("Smith");
        requestInfoEmail.sendKeys("jsmith@email.com");
        requestInfoRetypeEmail.sendKeys("jsmith@email.com");
        requestInfoMobilePhone.sendKeys("1234567890");
        requestInfoCity.sendKeys("Memphis");
        requestInfoState_Province.sendKeys("TN");
        requestInfoCountry.sendKeys("UNITED STATES OF AMERICA");
        Select select1 = new Select(requestInfoStartYear);
        select1.selectByVisibleText("2025");
        Select select2 = new Select(requestInfoStartTerm);
        select2.selectByVisibleText("Spring");
        requestInfoProgram.sendKeys("Computer Science - Software Engineering");
        Select select3 = new Select(requestInfoResidencyStatus);
        select3.selectByVisibleText("Citizen of US");
        Select select4 = new Select(requestInfoCitizenship);
        select4.selectByVisibleText("UNITED STATES OF AMERICA");
        requestInfoTextMessageBox.click();
        Select select5 = new Select(requestInfoHowDidYouHear);
        select5.selectByVisibleText("Alumni");
    }
}
