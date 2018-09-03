package xebia.bol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BolPage {

    WebDriver driver;
    WebDriverWait wait;

    public BolPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(how = How.ID, using = "9200000028103042")
    public WebElement productLT20;

    @FindBy(how = How.ID, using = "9200000042851954")
    public WebElement productGT20;

    @FindBy(how = How.ID, using = "tst_shipping_costs")
    public WebElement shippingCostValue;

    static final String BASKET_URL = "https://www.bol.com/nl/order/basket.html";

    public String get_item_into_shopping_cart(String productURL, WebElement product) {
        driver.navigate().to(productURL);
        product.click();
        driver.navigate().to(BASKET_URL);
        String shipping_cost = shippingCostValue.getText();

        return shipping_cost;
    }

    public BolPage go_to(String url){
        driver.navigate().to(url);
        return this;
    }
}
