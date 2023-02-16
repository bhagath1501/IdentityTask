package StepDefinitions;

import Managers.FileReaderManager;
import PageObjects.AboutPage;
import PageObjects.HomePage;
import Utilities.TestContext;
import Utilities.Wait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//sample 1 code

public class VehicleValuationSteps {

    TestContext testContext;
    HomePage homePage;
    AboutPage aboutPage;
    WebDriver webDriver;
    List<String> getRegNo = new ArrayList<>();

    public VehicleValuationSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
        aboutPage = testContext.getPageObjectManager().getAboutPage();
        webDriver = testContext.getDriverManager().getDriver();

    }

    @Given("Read data from input text file")
    public void Read_data_from_input_text_file() throws IOException {
        getRegNo = FileReaderManager.getInstance().getDataFile().readInputFile();
    }

    @When("Read output text file and validate vehicle details")
    public void Read_output_text_file_and_validate_vehicle_details() throws IOException {
        homePage.clickAcceptAllCookies();
        for (String s : getRegNo) {
            homePage.setValueRegistrationInputBox(s);
            homePage.clickStartValuationButton();
            String expectedValue = FileReaderManager.getInstance().getDataFile().readOutputFile(s);
            boolean checkElement = Wait.isElementPresent(webDriver, aboutPage.isMakeModelDisplayed());
            if (checkElement) {
                String actualValue = aboutPage.getMakeAndModelDetail();
                actualValue = actualValue.replaceAll("Make/model: ", "");
                System.out.println(actualValue);
                expectedValue = expectedValue.replaceAll(",", " ");
                System.out.println(expectedValue);
                if (expectedValue.equalsIgnoreCase(actualValue)) {
                    System.out.println(s + " Expected and Actual values are matched");
                } else {
                    System.err.println(s + " Expected and Actual values are not matched");
                }
            } else {
                String actualValue = aboutPage.getCheckErrorMessage();
                System.err.println(actualValue);
            }
            webDriver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
            homePage.clearRegNoBox();
        }
    }

    @When("Read Data from Notepad Output text file and compare Expected Value")
    public void read_data_from_notepad_output_text_file_and_compare_expected_value() {

    }

}
