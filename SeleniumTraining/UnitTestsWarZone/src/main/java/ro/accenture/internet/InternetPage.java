package ro.accenture.internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by andreicontan on 14/12/16.
 */
public class InternetPage {

    WebDriver driver;

    public InternetPage(WebDriver driver){
        this.driver = driver;
    }

    public InternetPage navigate(String url){
    driver.navigate().to(url);
        return this;
    }

    public InternetPage then(){
        return this;
    }

    public InternetPage when(){
        return this;
    }



    public List<WebElement> returnDropDownList(String dropDownID, String tagName){

        WebElement dropdownList = driver.findElement(By.id(dropDownID));
        List<WebElement> options = dropdownList.findElements(By.tagName(tagName));

        return options;

    }

    public List<String> returnSortedListOfDueValues(String dueHeader){

        String dueValues = "#table2 tbody tr td:nth-of-type(1)";
        driver.findElement(By.cssSelector(dueHeader)).click();

        List<WebElement> ordered_dues = driver.findElements(By.cssSelector(dueValues));
        List<String> values = new ArrayList<String>();
        for (WebElement element : ordered_dues){
            values.add(element.getText());
        }
        Collections.sort(values);
        return values;
    }
}


