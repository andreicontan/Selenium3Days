package ro.accenture.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by andreicontan on 15/12/16.
 */
public class ToDoMVC {


    WebDriver driver;
    WebDriverWait wait;

    public ToDoMVC(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(how = How.CLASS_NAME, using="new-todo")
    private WebElement createToDoField;

    @FindBy(how = How.ID, using="toggle-all")
    private WebElement toggleAll;

    @FindBy(how = How.CSS, using=".filters li a")
    private WebElement allFilter;

    @FindBy(how = How.CSS, using=".todo-count strong")
    private WebElement activeTodoCount;

    @FindBy(how = How.CSS, using=".todo-list li:not(.hidden)")
    private List<WebElement> toDosList;

    @FindBy(how = How.CSS, using=".toggle")
    private List<WebElement> toggleToDo;

    @FindBy(how=How.CLASS_NAME, using="edit")
    private WebElement editField;

    @FindBy(how = How.CLASS_NAME, using="destroy")
    private List<WebElement> destroyButton;


    public ToDoMVC navigate(String url){
        driver.navigate().to(url);
        return this;
    }


    public ToDoMVC createToDo(String toDoName){
        createToDoField.sendKeys(toDoName);
        createToDoField.sendKeys(Keys.ENTER);
        return this;
    }

    public int getToDoListSize(){
        return toDosList.size();
    }

    public int getToDoCount(){
        return Integer.parseInt(activeTodoCount.getText());
    }

    public List<WebElement> getToDosList(){
        return toDosList;
    }

    public ToDoMVC renameToDo(String classname, String newValue)
    {
        By editField = By.className(classname);
        WebElement edit = driver.findElement(editField);

        edit.click();
        edit.clear();

        edit.sendKeys(newValue);
        return this;
    }



    public ToDoMVC deleteTodoItem(int todoIndex) {

        WebElement todoListItem = getToDosList().get(todoIndex);
        Actions actions = new Actions(driver);
        actions.moveToElement(todoListItem).perform();
        wait.until(ExpectedConditions.elementToBeClickable(todoListItem));

        By DESTROY_BUTTON = By.className("destroy");
        todoListItem.click(); // enable the destroy button

        WebElement destroyButton = todoListItem.findElement(DESTROY_BUTTON);
        wait.until(ExpectedConditions.elementToBeClickable(destroyButton));

        destroyButton.click();
        return this;
    }


    public ToDoMVC deleteAllToDos(){
        List<WebElement> allToDos = getToDosList();
        while (allToDos.size() > 0){
            deleteTodoItem(0);
        }
        return this;
    }

    public boolean toggleToDoItem(int index){
       toggleToDo.get(index).click();
        return toggleToDo.get(index).isSelected();
    }
}


