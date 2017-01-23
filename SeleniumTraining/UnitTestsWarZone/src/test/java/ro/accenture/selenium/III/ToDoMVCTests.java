package ro.accenture.selenium.III;

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
 * Created by andreicontan on 20/01/2017.
 */
public class ToDoMVCTests {


    WebDriver driver;
    String url = "http://todomvc.com/examples/backbone/#/";

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.findElement(By.className("new-todo")).sendKeys("Selenium ToDo \n");


    }

    @Test
    public void createToDo(){
        driver.findElement(By.className("new-todo")).sendKeys("Selenium ToDo \n");


        String count = driver.findElement(By.className("todo-count"))
                .getText().substring(0, 1);
        Assert.assertTrue(count.equals("1"));


    }

    @Test
    public void countForMoreTodos(){
        int count = Integer.parseInt(driver.findElement(By.className("todo-count"))
                .getText().substring(0, 1));
        driver.findElement(By.className("new-todo")).sendKeys("Selenium ToDo \n");

        int countAfterAdd = Integer.parseInt(driver.findElement(By.className("todo-count"))
                .getText().substring(0, 1));
        Assert.assertEquals(count+1, countAfterAdd);
    }


    @Test
    public void createToDoGetListToDos(){
        String todoName = "Selenium ToDo";
        driver.findElement(By.className("new-todo")).sendKeys(todoName + "\n");

        List<WebElement> todos = driver.findElements(By.cssSelector(".todo-list li"));
        Assert.assertTrue(todos
                    .get(todos.size() - 1)
                    .getText()
                    .equals(todoName));

    }


    @After
    public void close(){
        driver.close();
        driver.quit();
    }
}
