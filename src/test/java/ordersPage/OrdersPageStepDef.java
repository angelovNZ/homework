package ordersPage;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Browser;

import static org.testng.Assert.*;

import java.util.List;

public class OrdersPageStepDef {
    private WebDriverWait wait;

    private static final By USERNAME = By.id("input-username");
    private static final By PASSWORD = By.id("input-password");
    private static final By LOGIN_BUTT = By.cssSelector(".btn.btn-primary");
    private static final By SALES_MENU = By.id("menu-sale");
    private static final By ORDERS_PAGE = By.xpath("//*[@id='collapse26']/li/a[contains(text(),'Orders')]");
    private static final By FILTER_PANEL = By.xpath("//*[@class='panel-heading']/h3[contains(text(),' Filter')]");
    private static final By ORDER_STATUS_DROPDOWN = By.id("input-order-status");


    @Given("the admin is on the Admin home page")
    public void theAdminIsOnTheAdminHomePage() {
        Browser.openPage("http://shop.pragmatic.bg/admin/");
        Browser.driver.findElement(USERNAME).sendKeys("admin");
        Browser.driver.findElement(PASSWORD).sendKeys("parola123!");
        Browser.driver.findElement(LOGIN_BUTT).click();
        assertEquals(Browser.driver.getTitle(), "Dashboard");
    }


    @When("the admin goes to Orders page")
    public void theAdminGoesToOrdersPage() {
        WebElement salesMenu = Browser.driver.findElement(SALES_MENU);
        WebElement ordersPage = Browser.driver.findElement(ORDERS_PAGE);

        waitTo().until(ExpectedConditions.visibilityOf(salesMenu));
        salesMenu.click();

        waitTo().until(ExpectedConditions.visibilityOf(ordersPage));
        ordersPage.click();

        assertEquals(Browser.driver.getTitle(), "Orders");
    }

    @And("the admin can see the filter panel")
    public void theAdminCanSeeTheFilterPanel() {
        WebElement filterPanel = Browser.driver.findElement(FILTER_PANEL);

        waitTo().until(ExpectedConditions.visibilityOf(filterPanel));

        assertTrue(filterPanel.isDisplayed());
    }

    @Then("the admin should find all the {string} which he want, select them")
    public void theAdminShouldFindAllTheWhichHeWantSelectThem(String status) {
        WebElement dropDownElement = Browser.driver.findElement(ORDER_STATUS_DROPDOWN);
        dropDownElement.click();

        Select dropDown = new Select(dropDownElement);

        List<WebElement> allOptions = dropDown.getOptions();

        for (WebElement currOption : allOptions) {
            System.out.println(currOption.getText());
            waitTo().until(ExpectedConditions.visibilityOf(currOption));
            if (currOption.getText().contains(status)) {
                dropDown.selectByVisibleText(status);
                return;
            }
        }
        fail("--- The status option [" + status + "] has not found! ---");
    }

    @And("the admin has too see his {string}")
    public void theAdminHasTooSeeHis(String selection) {
        WebElement dropdownElement = Browser.driver.findElement(ORDER_STATUS_DROPDOWN);

        Select dropDown = new Select(dropdownElement);

        for (WebElement currOpt : dropDown.getAllSelectedOptions()) {
            waitTo().until(ExpectedConditions.visibilityOf(currOpt));
            if (currOpt.getText().contains(selection)) {
                return;
            }
        }
        fail("--- The option [" + selection + "] is not selected! ---");
    }

    @After()
    public void tearDown() {
        Browser.quitBrowser();
    }

    private WebDriverWait waitTo() {
        return new WebDriverWait(Browser.driver, 10);
    }
}
