package ro.accenture.selenium.II;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ro.accenture.selenium.II.utils.ScreenshotRule;

import java.util.List;

/**
 * Created by andreicontan on 19/01/2017.
 */
public class CheckBoxesTests {



   public  WebDriver driver ;

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(driver);

    String url = "http://the-internet.herokuapp.com/checkboxes";
    List<WebElement> checkboxes;


    @Test
    public void testCheckbox2SelectedByDefault(){

        System.setProperty("webdriver.chrome.driver",
                "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        checkboxes = driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));
        Assert.assertTrue(false);
    }

//    @Test
//
//    public void testCheckboxIsClickable(){
//        WebElement checkbox1 = checkboxes.get(0);
//        checkbox1.click();
//        Assert.assertTrue("checkbox 1",checkbox1.isSelected());
//
//        WebElement checkbox2 = checkboxes.get(1);
//        checkbox2.click();
//        Assert.assertFalse(checkbox2.isSelected());
//    }
//
//
//    @Test
//    public void testUncheckAllBoxes(){
//        //Arrange
//        for (WebElement checkbox : checkboxes){
//            if (checkbox.isSelected()){
//                checkbox.click();
//            }
//        }
//        for (WebElement checkbox : checkboxes){
//            Assert.assertFalse(checkbox.isSelected());
//        }
//    }
//
//    @Test
//    public void countCheckboxes(){
//        Assert.assertEquals(2,checkboxes.size());
//    }
//
//
//
//    @After
//    public void quit(){
//        driver.close();
//        driver.quit();
//    }

}
