import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BasicAuthTest {



    WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.gecko.driver", "/Users/elenakot/IdeaProjects/AwesomeJavaWebdriver/src/test/resources/drivers/geckodriver 2");
        driver = new FirefoxDriver();}


    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


    @Test
    public void test001() {
        String login = "admin";
        String password = "admin";

        openBasicAuthPage(login, password);
        assertThatAuthenticated();
    }

    @DataProvider (name = "dataForAuthTest")
    public Object[][] dataForTest() {
        return new Object[][] {
                {"admin", "admin"},
                {"admin1234", "admin1234"},
                {"12321", "123123"},
                {"2131", "admi12321#@#@@!@!n1233213"},
        };
    }

    @Test (dataProvider = "dataForAuthTest")
    public void test002(String paramValue1, String paramValue2){

        String login = paramValue1;
        String password = paramValue2;

        openBasicAuthPage(login, password);
        assertThatAuthenticated();

    }

    private void assertThatAuthenticated() {
        boolean ifContainsCongrats = driver.getPageSource().contains("Congrat");
        Assert.assertTrue(ifContainsCongrats);

    }

    private void openBasicAuthPage(String login, String password) {

        String url = "https://" + login + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(url);
    }


}
