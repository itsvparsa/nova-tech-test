package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

    WebDriver driver;

    @FindBy(css = "h1 > a")
    WebElement siteTitle;

    @FindBy(css = "#main > h1")
    WebElement totalNumberOfComputers;

    @FindBy(linkText = "Add a new computer")
    WebElement addComputerLink;

    @FindBy(css = "div.alert-message")
    WebElement creationMessage;

    @FindBy(css = "#searchbox")
    WebElement searchBox;

    @FindBy(css = "#searchsubmit")
    WebElement searchButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSiteTitle() {
        return siteTitle.getText();
    }

    public int getTotalNumberOfComputers() {
        return Integer.parseInt(extractInt(totalNumberOfComputers.getText()));

    }

    static String extractInt(String str) {
        str = str.replaceAll("[^\\d]", "");
        str = str.trim();
        if (str.equals(""))
            return "-1";
        return str;
    }

    public void clickOnAddComputerLink() {
        addComputerLink.click();
    }

    public String getCreationMessageText() throws InterruptedException {
        Thread.sleep(2000);
        return creationMessage.getText();
    }

    public void searchForComputer(String text) {
        searchBox.sendKeys(text);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

}



