package ro.accenture.pageModels;

import org.openqa.selenium.By;
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
 * Created by andreicontan on 20/01/2017.
 */
public class TodoMVC {

    @FindBy(how= How.CLASS_NAME, using="new-todo")
    private WebElement toDoField;

    @FindBy(how = How.CLASS_NAME, using="todo-count")
    private WebElement toDoCounter;

    @FindBy(how= How.CSS, using = ".todo-list li")
    private List<WebElement> toDosList;

//    WebElement edit_field = driver.findElement(By.cssSelector("input.edit"));
    @FindBy(how = How.CSS, using="input.edit")
    private WebElement edit_field;

    @FindBy(how = How.CSS, using="button.destroy")
    private List<WebElement> destroyButton;

    @FindBy(how = How.CLASS_NAME, using="toggle")
    private List<WebElement> toggleButtons;

    private WebDriver driver;

    public TodoMVC(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createToDo(String toDoTitle){
        toDoField.sendKeys(toDoTitle + "\n");

    }
    
    public int returnToDoCount(){

        return Integer.parseInt(toDoCounter
                .getText().substring(0, 1));
    }

    public TodoMVC navigateToURL(String url){
        driver.navigate().to(url);
        return this;
    }

    public boolean toggleTodo(int it){
        toggleButtons.get(it).click();
        return toggleButtons.get(it).isSelected();

    }
    public String editToDo(int iterator, String newTitle){
        WebElement toDo = toDosList.get(iterator);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(toDo));

        new Actions(driver).doubleClick(toDo).perform();
//        wait.until(ExpectedConditions.elementToBeClickable(edit_field));
//        edit_field.click();
        edit_field.clear();
        edit_field.sendKeys(newTitle + "\n");
        return toDo.getText();
    }

    public TodoMVC and(){
        return this;
    }

    public TodoMVC when(){
        return this;
    }

    public TodoMVC then(){
        return this;
    }


    public List<WebElement> getToDosList() {
        return toDosList;
    }

    public boolean toggleStatus(int i){
        return toggleButtons.get(i).isSelected();
    }

    public int deleteToDoByIterator(int it){
        WebElement todo = getToDosList().get(it);
        Actions actions = new Actions(driver);
        actions.moveToElement(todo).perform();
        By DESTROY_BUTTON = By.className("destroy");
        todo.click(); // enable the destroy button
        WebElement destroyButton = todo.findElement(DESTROY_BUTTON);
        destroyButton.click();
        return getToDosList().size();
    }

    public int deleteToDoByIteratorV2(int it){
//        @FindBy(how = How.CSS, using="button.destroy")
//        private List<WebElement> destroyButton;
        Actions actions = new Actions(driver);
        actions.moveToElement(getToDosList().get(it)).perform();
        actions.moveToElement(destroyButton.get(it)).perform();
        actions.click().perform();

        return getToDosList().size();
    }
}
