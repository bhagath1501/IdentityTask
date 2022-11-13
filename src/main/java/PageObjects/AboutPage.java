package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {

    public AboutPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[@class='sc-bYMpWt gWpvVJ']/p[2]")
    private WebElement checkMakeAndModelDetail;

    @FindBy(xpath = "//*[contains(text(),'Sorry')]")
    private WebElement checkErrorMessage;

    public WebElement isMakeModelDisplayed() {
        return checkMakeAndModelDetail;
    }

    public String getMakeAndModelDetail() {
        return checkMakeAndModelDetail.getText();
    }

    public String getCheckErrorMessage() {
        checkErrorMessage.isDisplayed();
        return checkErrorMessage.getText();
    }


}
