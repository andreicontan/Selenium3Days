package ro.accenture.selenium.II;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreicontan on 20/01/2017.
 */
public class WorkingWithTables {

    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/tables";
    List<WebElement> lnames;
    List<String> lnamesvalues = new ArrayList<String>();
    List<String> expected;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(url);

        expected = new ArrayList<String>();
        expected.add("Bach");
        expected.add("Conway");
        expected.add("Doe");
        expected.add("Smith");


    }

    @Test
    public void testSortedColumn() {
        WebElement lnameHeader = driver.findElement(By.cssSelector("#table1 thead tr th:nth-of-type(1)"));
        lnameHeader.click();
        lnames = driver.findElements(By.cssSelector("#table1 tbody tr td:nth-of-type(1)"));
        for (WebElement lname : lnames) {
            lnamesvalues.add(lname.getText());
        }
    for (int i=0; i<lnamesvalues.size();i++){
        Assert.assertEquals(lnamesvalues.get(i), expected.get(i));
    }
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }
}
