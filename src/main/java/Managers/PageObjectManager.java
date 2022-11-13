package Managers;

import PageObjects.AboutPage;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;


public class PageObjectManager {

    private final WebDriver webDriver;
    private HomePage homePage;
    private AboutPage aboutPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(webDriver) : homePage;
    }

    public AboutPage getAboutPage() {

        if (aboutPage == null) {
            aboutPage = new AboutPage(webDriver);
        }
        return aboutPage;
    }

}
