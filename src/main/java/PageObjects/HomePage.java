package PageObjects;

import Managers.FileReaderManager;
import Utilities.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    TestContext testContext;
    WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    @FindBy(xpath = "//*[contains(text(),'Accept All')]")
    private WebElement acceptAllCookies;

    @FindBy(id ="vrm")
    private WebElement registrationInputBox;

    @FindBy(xpath = "//*[@type='submit' and @class='sc-mqi3p7-0 iPGgoA']")
    private WebElement startValuationButton;


    public void clickAcceptAllCookies() {
        acceptAllCookies.isDisplayed();
        acceptAllCookies.click();
    }

    public void setValueRegistrationInputBox(String regNo) {
        registrationInputBox.sendKeys(regNo);
    }

    public void clickStartValuationButton() {
        startValuationButton.isEnabled();
        startValuationButton.click();
    }

    public void openUrl() {
        webDriver = testContext.getDriverManager().getDriver();
        webDriver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
    }
    public void clearRegNoBox() {
        registrationInputBox.clear();
    }
}
