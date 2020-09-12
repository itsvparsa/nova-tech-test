package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AddComputerPage;
import pages.EditComputerPage;
import pages.LandingPage;
import pages.SearchResultsPage;
import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.*;

public class MyStepdefs {

    private static WebDriver driver;
    private LandingPage landingPage;
    private static final String userPath = System.getProperty("user.dir");
    private int totalComputers;
    private AddComputerPage addComputerPage;
    private SearchResultsPage searchResultsPage;
    private EditComputerPage editComputerPage;
    private String computerNameFromEditPage;

    public MyStepdefs() {
        landingPage = new LandingPage(driver);
        addComputerPage = new AddComputerPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        editComputerPage = new EditComputerPage(driver);
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                userPath + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        waitForPageToLoad();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^the navigated to the site$")
    public void theNavigatedToTheSite() {
        driver.navigate().to("https://computer-database.gatling.io/computers");
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        driver.getTitle();
    }

    @Then("^the user verifies the name of the site is \"([^\"]*)\"$")
    public void theUserVerifiesTheNameOfTheSiteIs(String siteName) throws Throwable {
        String expectedSiteName = landingPage.getSiteTitle();
        System.out.println("Name of the site is --------------->" + expectedSiteName);
        assertEquals(expectedSiteName, siteName);
        int number = landingPage.getTotalNumberOfComputers();
        System.out.println("Number of computers in the database ---------> " + number);
    }

    @And("^the user clicks on add a new computer link$")
    public void theUserClicksOnAddANewComputerLink() {
        waitForPageToLoad();
        landingPage.clickOnAddComputerLink();
    }

    @When("^the user adds a new computer$")
    public void theUserAddsANewComputer() {
        addComputerPage = PageFactory.initElements(driver, AddComputerPage.class);
        addComputerPage.enterComputerDetails();
    }

    @Then("^the computer is successfully added to the database$")
    public void theComputerIsSuccessfullyAddedToTheDatabase() throws InterruptedException {
        waitForPageToLoad();
        String expAfterCreationMsg = landingPage.getCreationMessageText();
        String enteredText = addComputerPage.getEnteredValue();
        String actAfterCreationMsg = "Done ! Computer " + enteredText + " has been created";
        System.out.println("Computer added message is ----------> " + actAfterCreationMsg);
        assertEquals(expAfterCreationMsg, actAfterCreationMsg);
    }

    @And("^the user like to search for \"([^\"]*)\" computer$")
    public void theUserLikeToSearchForComputer(String searchText) {
        landingPage.searchForComputer(searchText);
    }

    @When("^the user clicks on filter by name button$")
    public void theUserClicksOnFilterByNameButton() {
        landingPage.clickOnSearchButton();
    }

    public void waitForPageToLoad() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^the successfully able to get the \"([^\"]*)\" computer in the list$")
    public void theSuccessfullyAbleToGetTheComputerInTheList(String searchedText) throws Throwable {
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        String expectedText = searchResultsPage.getSearchResults(searchedText);
        assertEquals(expectedText, searchedText);
    }

    @And("^the user clicks on \"([^\"]*)\" computer link from list$")
    public void theUserClicksOnComputerLinkFromList(String text) throws Throwable {
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        searchResultsPage.clickOnTheSearchedLink(text);
    }

    @When("^the user delete the entry$")
    public void theUserDeleteTheEntry() throws InterruptedException {
        editComputerPage = PageFactory.initElements(driver, EditComputerPage.class);
        computerNameFromEditPage = editComputerPage.getEnteredValue();
        editComputerPage.clickOnDeleteButton();
    }

    @Then("^the computer successfully deleted from database$")
    public void theComputerSuccessfullyDeletedFromDatabase() throws InterruptedException {
        Thread.sleep(1000);
        String expAfterCreationMsg = landingPage.getCreationMessageText();
        String actAfterCreationMsg = "Done ! Computer " + computerNameFromEditPage + " has been deleted";
        System.out.println("Computer deletion message is " + actAfterCreationMsg);
        assertEquals(expAfterCreationMsg, actAfterCreationMsg);
    }
}
