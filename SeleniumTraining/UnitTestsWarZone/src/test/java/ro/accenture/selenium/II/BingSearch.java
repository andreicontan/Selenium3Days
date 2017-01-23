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
public class BingSearch {

        WebDriver driver ;

        @Before
        public void setup(){
            System.setProperty("webdriver.chrome.driver",
                    "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/chromedriver");
                driver = new ChromeDriver();
        }

        @Test
        public void searchAccentureInBing(){
            driver.navigate().to("http://www.bing.com");
                driver.manage().window().maximize();

                WebElement searchBox = driver.findElement(By.id("sb_form_q"));
                searchBox.sendKeys("Accenture \n");
//                driver.findElement(By.id("sb_form_q"))
//                        .sendKeys("Accenture \n");

            String title = driver.getTitle();
                Assert.assertTrue(title.contains("Accenture"));
        }

        @Test
        public void testForURLRedirect(){
                driver.navigate().to("http://m.gsp.ro");
                String currentURL = driver.getCurrentUrl();
                Assert.assertEquals("www.gsp.ro", currentURL);
        }


        @Test
        public void dropDownList() {
                String url = "http://the-internet.herokuapp.com/dropdown";
                driver.navigate().to(url);

                List<WebElement> options = driver.findElements(By.tagName("option"));

                for (WebElement option : options){
                        Assert.assertTrue(option.getText().toLowerCase().contains("option"));

                }

                options.get(1).click();

                Assert.assertTrue(options.get(1).isSelected());
        }

        public void checkOptionTextAllElements(){
                String url = "http://the-internet.herokuapp.com/dropdown";
                driver.navigate().to(url);

                List<WebElement> options = driver.findElements(By.tagName("option"));

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
