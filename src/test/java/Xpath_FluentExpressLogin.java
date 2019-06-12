import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Xpath_FluentExpressLogin {

    WebDriver driver;


    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.gecko.driver", "/Users/elenakot/IdeaProjects/AwesomeJavaWebdriver/src/test/resources/drivers/geckodriver 2");
        driver = new FirefoxDriver(); }



    @Test
    public void test001() {

        credentialsInput();
        //assertThatAuthenticated();

    }

    private void credentialsInput() {

        driver.get("http://fluentexpress-qa.northeurope.cloudapp.azure.com/login");

        String loginXpath = "//input[@name='email']";
        String passwordXpath = "//input[@name='password']";
        String logInButton = "//button[@data-test='login-btn']";

        WebElement login = driver.findElement(By.xpath(loginXpath));
        login.sendKeys("casusdr@gmail.com");
        WebElement password = driver.findElement(By.xpath(passwordXpath));
        password.sendKeys("Ro7I6kCW6enbwKm1zJUk");
        WebElement button = driver.findElement(By.xpath(logInButton));
        button.click();


    }

}