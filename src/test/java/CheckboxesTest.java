import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxesTest {

    WebDriver driver;
    WebElement checkBox1;
    WebElement checkBox2;
    String attributeValue1;
    String attributeValue2;


    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.gecko.driver", "/Users/elenakot/IdeaProjects/AwesomeJavaWebdriver/src/test/resources/drivers/geckodriver 2");
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }

    @Test
    public void test001(){
        openCheckboxesPage();
        findCheckboxesByTagname();
        defineStatusOfCheckboxes();
        clickOnCheckbox1();
        defineStatusOfCheckbox1();
    }

    private void defineStatusOfCheckbox1() {
        attributeValue1 = checkBox1.getAttribute("checked");
        Assert.assertNotNull(attributeValue1);

        String expectedAttributeValue = "true";
        Assert.assertEquals(expectedAttributeValue, attributeValue1);
    }

    private void clickOnCheckbox1() {
        checkBox1.click();
    }

    private void defineStatusOfCheckboxes() {
        attributeValue1 = checkBox1.getAttribute("checked");
        attributeValue2 = checkBox2.getAttribute("checked");

        Assert.assertNull(attributeValue1);
        Assert.assertNotNull(attributeValue2);
    }

    private void findCheckboxesByTagname() {
        List<WebElement> listOfInputs = driver.findElements(By.tagName("Input"));

        int listSize = listOfInputs.size();

        checkBox1 = listOfInputs.get(0);
        checkBox2 = listOfInputs.get(1);
    }

    private void openCheckboxesPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
}
