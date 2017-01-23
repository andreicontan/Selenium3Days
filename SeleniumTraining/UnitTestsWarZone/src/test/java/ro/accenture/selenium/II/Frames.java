package ro.accenture.selenium.II;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by andreicontan on 19/01/2017.
 */
public class Frames {

    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/nested_frames";
    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(url);


    }


    @Test
    public void switchFrames(){
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        Assert.assertEquals(driver.findElement(By.id("content")).getText(),"MIDDLE");

    }
}
