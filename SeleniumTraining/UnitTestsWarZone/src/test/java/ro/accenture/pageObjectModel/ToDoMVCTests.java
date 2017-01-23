package ro.accenture.pageObjectModel;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by andreicontan on 15/12/16.
 */
public class ToDoMVCTests {

    WebDriver driver;
    ToDoMVC toDoMVC;
    String url = "http://todomvc.com/examples/backbone";

    @BeforeClass
    public static void initialize(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/andreicontan/Documents/Work/Trainings/Accenture/Training - Selenium3Days/worksets/chromedriver" );
    }

    @Before
    public void setup(){
        driver = new ChromeDriver();
        toDoMVC = new ToDoMVC(driver);
        toDoMVC.navigate(url);

    }

    @Test
    public void testCreateToDo(){

        int initListSize = toDoMVC.getToDoListSize();
        toDoMVC.createToDo("Made By Selenium \n");
        Assert.assertEquals(initListSize +1,
                toDoMVC.getToDoListSize());
    }


    @Test
    public void editToDo(){

        toDoMVC.createToDo("I need a change");
        Actions actions = new Actions(driver);
        WebElement change = toDoMVC.getToDosList().get(0);

        actions.doubleClick(change).perform();
        toDoMVC.renameToDo("edit", "The wind of change \n");
        Assert.assertEquals("The wind of change",
                change.getText());
    }

    @Test
    public void deleteToDo(){

        toDoMVC.createToDo("To Be Deleted \n");
        int initListSize = toDoMVC.getToDoListSize();
        toDoMVC.deleteTodoItem(0);
        Assert.assertEquals(initListSize-1,
                toDoMVC.getToDoListSize());
    }


    @Test
    public void toggleToDo(){
        toDoMVC.createToDo("Toggle ToDo \n");
        Assert.assertTrue(toDoMVC.toggleToDoItem(0));
    }

    @Test
    public void testDeleteAllToDos(){
        toDoMVC.createToDo("1 \n");
        toDoMVC.createToDo("2 \n");
        toDoMVC.createToDo("3 \n");
        toDoMVC.createToDo("11 \n");
        toDoMVC.createToDo("1 1\n");
        toDoMVC.deleteAllToDos();
        Assert.assertEquals(0, toDoMVC.getToDoListSize());
    }

    @After    public void shutDown(){
        driver.close();
        driver.quit();
    }
}
