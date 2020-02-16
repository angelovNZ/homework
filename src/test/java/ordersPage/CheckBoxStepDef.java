package ordersPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Browser;

import java.util.List;

import static org.testng.Assert.*;

public class CheckBoxStepDef {
    private static final By HEADER_CHECKBOX = By.xpath("//td[@style='width: 1px;']/input[@type='checkbox']");
    private static final By ALL_CHECKBOXES = By.xpath("//input[@type='checkbox']");

    @And("the admin can see the check box from head panel")
    public void theAdminCanSeeTheCheckBoxFromHeadPanel() {
        waitTo().until(ExpectedConditions.visibilityOf(checkboxElement()));

        assertTrue(checkboxElement().isDisplayed(),
                "----  The checkbox isn't displayed  -----");
    }

    @Then("the admin should click on the check box")
    public void theAdminShouldClickOnTheCheckBox() {
        waitTo().until(ExpectedConditions.elementToBeClickable(checkboxElement()));

        if (checkboxElement().isEnabled()) {
            checkboxElement().click();
            assertTrue(checkboxElement().isSelected());
            return;
        }
        fail("----- Checkbox is not enabled and it is not clickable! ----");
    }

    @And("all the check boxes below has to be checked")
    public void allTheCheckBoxesBelowHasToBeChecked() {
        List<WebElement> allCheckboxes = Browser.driver.findElements(ALL_CHECKBOXES);

        for (WebElement currCheckbox : allCheckboxes) {
            assertTrue(currCheckbox.isSelected(),
                    " ----- Not all the checkboxes are selected !  ----");
        }
    }

    private WebElement checkboxElement() {
        return Browser.driver.findElement(HEADER_CHECKBOX);
    }

    private WebDriverWait waitTo() {
        return new WebDriverWait(Browser.driver, 10);
    }
}
