import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GoogleSearch{

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.gecko.driver", "/Users/elenakot/IdeaProjects/AwesomeJavaWebdriver/src/test/resources/drivers/geckodriver 2");
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void afterSuite(){
        driver.close();
    }

    @Test
    public void test001(){

        String textValue = "portnov computer school";

        openMainPage();
        typeQuery(textValue);
        submitSearch();
        waitForResults();
        assertResultPage();

        }

    @Test
    public void test002(){

        String textValue = "000GGIHi889";

        openMainPage();
        typeQuery(textValue);
        submitSearch();
        waitForResults();
        assertResultPage();

    }

    private void waitForResults() {
        By resultsStatElement = By.id("resultStats");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(resultsStatElement));
    }

    private void assertResultPage() {
        WebElement resultStatsElememt = driver.findElement(By.id("resultStats"));
        boolean isElementDisplayed = resultStatsElememt.isDisplayed();
        boolean expectedResult = true;
        Assert.assertEquals(isElementDisplayed, expectedResult);
    }

    private void submitSearch() {
        WebElement searchInput = driver.findElement(By.cssSelector(".gLFyf"));
        searchInput.submit();
    }

    private void typeQuery(String queryText) {
        WebElement searchInput = driver.findElement(By.cssSelector(".gLFyf"));
        searchInput.sendKeys(queryText);
    }

    private void openMainPage() {
        String url = "https://google.com";
        driver.get(url);

    }


}

