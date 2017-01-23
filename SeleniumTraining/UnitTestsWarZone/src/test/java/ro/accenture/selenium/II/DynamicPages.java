package ro.accenture.selenium.II;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by andreicontan on 20/01/2017.
 */
public class DynamicPages {

    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/dynamic_loading/2";

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(url);

    }

    @Test
    public void testDynamicElement(){
        driver.findElement(By.cssSelector("#start button")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement finish = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("finish")));
        Assert.assertEquals(finish.getText(), "Hello World!");
    }

}
