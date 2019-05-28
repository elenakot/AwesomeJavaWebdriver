import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.Set;

public class WindowHandlesTest {


    WebDriver driver;
    String linkText;
    WebElement linkElement;
    String windowHandle1;
    String windowHandle2;


    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.gecko.driver", "/Users/elenakot/IdeaProjects/AwesomeJavaWebdriver/src/test/resources/drivers/geckodriver 2");
        driver = new FirefoxDriver(); }

    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
        public void afterSuite(){
            driver.quit();
    }

    @Test
    public void test001(){

        openLink();
        findLinkToOpenNewWindow();
        openNewWindow();
        defineWindowsHandles();
        checkWindowTwoOpenedCorrectly();
        checkWindowOneOpenedCorrectly();

    }

    private void checkWindowOneOpenedCorrectly() {
        driver.switchTo().window(windowHandle1);

        String windowTitle = driver.getTitle();

        String titlePartialText = "Internet";

        boolean ifTitleContainsText = windowTitle.contains(titlePartialText);

        Assert.assertTrue(ifTitleContainsText);
    }

    private void checkWindowTwoOpenedCorrectly() {
        driver.switchTo().window(windowHandle2);

        String pageSource = driver.getPageSource();

        String textToCheck = "New Window";

        boolean isTextThere = pageSource.contains(textToCheck);

        Assert.assertTrue(isTextThere);
    }

    private void defineWindowsHandles() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> allWindowHandles = driver.getWindowHandles();

        boolean isTwoWindowOpened = allWindowHandles.size() == 2;

        Assert.assertTrue(isTwoWindowOpened);

        windowHandle1 = (String) allWindowHandles.toArray()[0];
        windowHandle2 = (String) allWindowHandles.toArray()[1];
    }

    private void openNewWindow() {
        linkElement.click();
    }

    private void findLinkToOpenNewWindow() {
        linkText = "Click Here";
        By linkByText = By.linkText("Click Here");
        linkElement = driver.findElement(linkByText);
    }

    private void openLink() {
        driver.get("https://the-internet.herokuapp.com/windows");
    }

}
