package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditComputerPage {

    WebDriver driver;
    String enteredValue;

    @FindBy(css = "#name")
    WebElement computerName;

    @FindBy(css = "form.topRight > input")
    WebElement deleteButton;

    public EditComputerPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getEnteredValue() {
        enteredValue = computerName.getAttribute("value");
        return enteredValue;
    }

    public void clickOnDeleteButton() throws InterruptedException {
        Thread.sleep(2000);
        deleteButton.click();
    }
}
