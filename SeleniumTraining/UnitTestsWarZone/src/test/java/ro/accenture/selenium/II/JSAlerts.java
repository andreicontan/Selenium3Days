package ro.accenture.selenium.II;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by andreicontan on 19/01/2017.
 */
public class JSAlerts {

    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/javascript_alerts";
    List<WebElement> alertButtons;
    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(url);
        alertButtons = driver.findElements(By.cssSelector("button"));

    }

    @Test
    public void acceptJSAlert() {
        alertButtons.get(1).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You clicked: Ok");

    }

    @Test
    public void cancelJSAlert(){
        alertButtons.get(1).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You clicked: Cancel");
    }

    @Test
    public void sendKeysInJSAlert(){
        alertButtons.get(2).click();
        Alert alert = driver.switchTo().alert();
        String message = "Hello World";
        alert.sendKeys(message);
        alert.accept();
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: " + message,result);
    }

    @After
    public void closeBrowsers(){
        driver.close();
        driver.quit();
    }
}
