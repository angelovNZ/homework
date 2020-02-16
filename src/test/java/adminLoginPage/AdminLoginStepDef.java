package adminLoginPage;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class AdminLoginStepDef {
    private static final By USERNAME = By.id("input-username");
    private static final By PASSWORD = By.id("input-password");
    private static final By LOGIN_BUTT = By.cssSelector(".btn.btn-primary");
    private static final By LOGOUT_BUT = By.cssSelector(".fa.fa-sign-out + span");
    private static final By ALERT_MESSAGE = By.cssSelector(".alert");


    @Given("the user open chrome browser and {string} successfully")
    public void theUserOpenChromeBrowserAndSuccessfully(String page) {
        Browser.openPage(page);
    }

    @When("the user enter {string} and {string} on the required place")
    public void theUserEnterAndOnTheRequiredPlace(String username, String password) {
        Browser.driver.findElement(USERNAME).sendKeys(username);
        Browser.driver.findElement(PASSWORD).sendKeys(password);
    }

    @And("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        Browser.driver.findElement(LOGIN_BUTT).click();
    }

    @Then("the user should be log in successfully")
    public void theUserShouldBeLogInSuccessfully() {
        Assert.assertEquals(Browser.driver.getTitle(), "Dashboard");
    }

    @And("the user is successfully logout")
    public void theUserIsSuccessfullyLogout() {
        Browser.driver.findElement(LOGOUT_BUT).click();
        Assert.assertEquals(Browser.driver.getTitle(), "Administration");
    }

    @Then("the user should see the right alert message")
    public void theUserShouldSeeTheRightAlertMessage() {
        Assert.assertEquals(Browser.driver.findElement(ALERT_MESSAGE).getText(),
                "No match for Username and/or Password.\n" +
                        "×");
    }

    @After()
    public void tearDown(){
        Browser.quitBrowser();
    }
}
