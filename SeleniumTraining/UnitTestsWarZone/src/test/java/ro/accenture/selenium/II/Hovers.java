package ro.accenture.selenium.II;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by andreicontan on 19/01/2017.
 */
public class Hovers {

    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/hovers";
    List<WebElement> avatars;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);

    }


    @Test
    public void testHoverOverElements(){
        Actions action = new Actions(driver);
        List<WebElement> pictures = driver.findElements(By.className("figure"));
        List<WebElement> details = driver.findElements(By.className("figcaption"));

       for (int i=0 ;i < pictures.size(); i++){
           action.moveToElement(pictures.get(i)).perform();
           Assert.assertTrue(details.get(i).isDisplayed());
       }
    }
}
