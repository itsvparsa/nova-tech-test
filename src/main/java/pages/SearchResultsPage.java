package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {

    WebDriver driver;

    @FindBy(css = "table.computers > tbody > tr > td > a")
    List<WebElement> searchResults;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSearchResults(String text) throws InterruptedException {

        Thread.sleep(3000);
        System.out.println("Search results of the text size ----> " + searchResults.size());
        List<WebElement> allSearchedResults = searchResults;
        for (WebElement searchText : allSearchedResults) {
            System.out.println("Search results of the text -----> " + searchText.getText());
            if (searchText.getText().equals(text)) {
                break;
            }
        }
        return text;
    }

    public void clickOnTheSearchedLink(String text) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Search results of the text size ----> " + searchResults.size());
        List<WebElement> allSearchedResults = searchResults;
        for (WebElement searchText : allSearchedResults) {
            if (searchText.getText().equals(text)) {
                searchText.click();
                break;
            }
        }
    }
}