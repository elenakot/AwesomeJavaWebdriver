import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Xpath {

    WebDriver driver;


    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.gecko.driver", "/Users/elenakot/IdeaProjects/AwesomeJavaWebdriver/src/test/resources/drivers/geckodriver 2");
        driver = new FirefoxDriver(); }


    @Test
    public void test001() {
        String xpath1 = "";
        //WebElement element = driver.findElement(By.ByXPath(xpath1));

        String absXpath = "html/body/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div[1]/div/div/input[1]";

        String relativeXpath = "//form/div[1]/div/div[1]/div/div/input[1]";
        String xpath2 = "//input[@name='restaurant_id']";
        String xpath3 = "//input[@name='restaurant_id'][@type='text']";
        String xpath4 = "//input[@name='restaurant_id' and @type='text']";
        String xpath5 = "//input[@name='restaurant_id' or @type='text']";
        String xpath6 = "//input[contains(@name,'raunt')]";
        String xpath7 = "//input[starts-with(@name,'resta')]";
        String xpath8 = "//*[text()='Log In']";
        String xpath9 = "(//input[@type='text'])[last()-1]";
        String xpath10 = "(//input[@type='text'])[position()=2]";
        String xpath11 = "(//input[@type='text'])[2]";
        String xpath12 = "//*[@id='FirstName']/following::input[@type='text']";
        String xpath13 = "//*[@id='LastName']//preceding::input[@type='text']";





    }

}
