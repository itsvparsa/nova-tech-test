package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddComputerPage {

    WebDriver driver;
    String enteredValue;

    @FindBy(css = "#name")
    WebElement computerName;

    @FindBy(css = "#introduced")
    WebElement introduced;

    @FindBy(css = "#discontinued")
    WebElement discontinued;

    @FindBy(css = "#company")
    WebElement company;

    @FindBy(xpath = "//input[@class='btn primary']")
    WebElement createButton;

    public AddComputerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterComputerDetails() {
        computerName.sendKeys("IBM PRO");
        enteredValue = computerName.getAttribute("value");
        introduced.sendKeys("2020-01-01");
        discontinued.sendKeys("2020-05-01");
        selectFromDropDown(company, "IBM");
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].click();", createButton);
    }

    public void selectFromDropDown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public String getEnteredValue() {
        return enteredValue;
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
