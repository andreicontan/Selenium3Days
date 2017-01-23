package ro.accenture.selenium.II;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by andreicontan on 19/01/2017.
 */
public class DropDownTest {


    WebDriver driver ;
    String url = "http://the-internet.herokuapp.com/dropdown";
    List<WebElement> options;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(url);
        options = driver.findElements(By.tagName("option"));


    }


    @Test
    public void selectElementInDropDownList() {

       WebElement option =  options.get(1);
        option.click();

        Assert.assertTrue(option.isSelected());
    }

    @Test
    public void checkOptionTextAllElements(){
        
        for (WebElement option : options){
            Assert.assertTrue(option.getText().toLowerCase().contains("option"));

        }
    }
    @After
    public void close(){
        driver.close();
        driver.quit();
    }
}
