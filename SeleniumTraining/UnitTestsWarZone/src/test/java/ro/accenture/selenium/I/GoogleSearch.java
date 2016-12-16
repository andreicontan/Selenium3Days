package ro.accenture.selenium.I;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ro.accenture.internet.InternetPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreicontan on 14/12/16.
 */
public class GoogleSearch {

    WebDriver driver;

    @BeforeClass
    public static void setEnvironment(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/chromedriver" );

    }

    @Before
    public void initialize(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleSearch(){


        driver.navigate().to("http://www.bing.com");
        driver.findElement(By.id("sb_form_q"))
                .sendKeys("Accenture\n");

        Assert.assertEquals("Accenture - Bing",
                driver.getTitle());


    }

    @Test
    public void testNewDropDownList(){
        String url = "http://the-internet.herokuapp.com/dropdown";
        InternetPage internetPage = new InternetPage(driver);
        internetPage.navigate(url);
        List<WebElement> options = internetPage.returnDropDownList("dropdown", "option");
        Assert.assertTrue(options.size()==3);
    }

    @Test
    public void fluentTestDropDown(){
        String url = "http://the-internet.herokuapp.com/dropdown";
        InternetPage internetPage = new InternetPage(driver);
        List<WebElement> options =  internetPage.when()
                                    .navigate(url)
                                    .then()
                                    .returnDropDownList("dropdown", "options");
        Assert.assertTrue(options.size()==3);

    }

    @Test
    public void testDropDownList(){

        driver.navigate().to("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (WebElement option : options){
            Assert.assertTrue(option.getText().toLowerCase().contains("option"));
            Assert.assertTrue(options.size() == 3);
        }

    }

    @Test
    public void checkboxes(){
        driver = new ChromeDriver();
        String url = "http://the-internet.herokuapp.com/checkboxes";
        driver.navigate().to(url);



        List<WebElement> checkboxes = driver.findElements
                (By.cssSelector("input[type=\"checkbox\"]"));
        for (WebElement checkbox : checkboxes){
            String actual = checkbox.getAttribute("checked");
            checkbox.click();
            String expect = checkbox.getAttribute("checked");
            Assert.assertNotEquals(expect, actual);
        }



    }


    @Test
    public void Hover(){
        WebElement avatar = driver.findElement(By.className("figure"));
        Actions action = new Actions(driver);
        action.moveToElement(avatar).perform();
        WebElement profile = driver.findElement(By.className("figcaption"));
        Assert.assertTrue(profile.isDisplayed());


    }


    @Test
    public void alertJS(){
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }


    @Test
    public void frames(){
        driver.switchTo().frame("frame-middle");
        WebElement middleFrameText =  driver.findElement(By.id("content"));

        Assert.assertEquals(middleFrameText.getText(), "MIDDLE");

    }


    @Test
    public void testSortedTables(){

        InternetPage page = new InternetPage(driver);
        page.navigate("http://the-internet.herokuapp.com/tables");
       List<String> actualList =  page.returnSortedListOfDueValues("#table2 tbody tr td:nth-of-type(1)");
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("Bach");
        expectedList.add("Conway");
        expectedList.add("Doe");
        expectedList.add("Smith");
        Assert.assertEquals(expectedList,actualList);
    }


    @Test
    public void lazyPage(){
        driver.navigate().to("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement finish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        Assert.assertEquals("Hello World!",finish.getText());
    }

    @After
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
