import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;


    public class Checkboxes2 {

        WebDriver driver;
        WebElement checkBox1;
        WebElement checkBox2;


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
            Assert.assertEquals(checkBox1.isSelected(), true);
        }

        private void clickOnCheckbox1() {
            checkBox1.click();
        }

        private void defineStatusOfCheckboxes() {

            Assert.assertEquals(checkBox1.isSelected(), false);
            Assert.assertEquals(checkBox2.isSelected(), true);
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


