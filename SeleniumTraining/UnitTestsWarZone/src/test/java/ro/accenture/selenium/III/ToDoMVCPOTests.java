package ro.accenture.selenium.III;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ro.accenture.pageModels.TodoMVC;

/**
 * Created by andreicontan on 20/01/2017.
 */
public class ToDoMVCPOTests {

    WebDriver driver;
    TodoMVC todoMVC;
    String url = "http://todomvc.com/examples/backbone/#/";
    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/chromedriver");
        driver = new ChromeDriver();
        todoMVC = new TodoMVC(driver);
        todoMVC.navigateToURL(url);
    }

    @Test
    public void testCreateToDo(){
        todoMVC.createToDo("New PageObj ToDo");
        Assert.assertEquals(1, todoMVC.returnToDoCount());
    }

    @Test
    public void editLastInsertedTodo(){
        todoMVC.createToDo("I need a change");
        int listSize = todoMVC.getToDosList().size();
        String title = "I am reinvented";
       Assert.assertEquals(title, todoMVC.editToDo(listSize-1, title));

    }

    @Test
    public void create3ToDosDeleteLast(){
        todoMVC.createToDo("1");
        todoMVC.createToDo("1");
        todoMVC.createToDo("1");
        int count = todoMVC.getToDosList().size();
        todoMVC.deleteToDoByIterator(2);
        Assert.assertEquals(count-1, todoMVC.getToDosList().size());
    }

    @Test
    public void create3ToDosDeleteLastV2(){
        todoMVC.createToDo("1");
        todoMVC.createToDo("2");
        todoMVC.createToDo("3");

        int initialSize = todoMVC.getToDosList().size();
        int actualSize = todoMVC.deleteToDoByIteratorV2(2);

           Assert.assertEquals(initialSize-1, actualSize);
    }

    @Test
    public void toggleButton(){
        todoMVC.createToDo("to do to be toggled");
        boolean current = todoMVC.toggleStatus(0);
        todoMVC.toggleTodo(0);
        Assert.assertNotEquals(current, todoMVC.toggleStatus(0));



    }
    @After
    public void tearDown(){
//        driver.close();
//        driver.quit();

    }
}
