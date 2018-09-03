package xebia.bol;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import xebia.bol.BolPage;

import static org.junit.Assert.assertTrue;

public class ShippingCostsTests {

    WebDriver webDriver;
   BolPage bolPage;
   DesiredCapabilities desiredCapabilities;

    @BeforeClass
    public static void initialize() {
        System.setProperty("webdriver.chrome.driver",
                "/usr/local/bin/chromedriver");

    }

    @Before
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        webDriver = new ChromeDriver(desiredCapabilities);
        bolPage = new BolPage(webDriver);

    }


    @Test
    public void label_should_add_shipping_fee_lt_20() {
        String productURL = "https://www.bol.com/nl/p/tunturi-pullboy-zwemtrainer-pullboy-drijver-medium-blauw-wit/9200000028103042/";
        bolPage.go_to(productURL);
        String cost = bolPage.get_item_into_shopping_cart(productURL, bolPage.productLT20);
        Assert.assertFalse("check translation label", cost.equals("Free"));

    }

    @Test
    public void _label_should_ship_free_order_ge_20() {
        String productURL = "https://www.bol.com/nl/p/arena-kickboard-groen-kickboard-zwemplank/9200000042851954/?bltg=itm_event%3Dclick%26slt_owner%3DMCM%26itm_type%3Dproduct%26pg_nm%3Dmain%26slt_id%3D803%26slt_nm%3D1N-MCM-slot-opn1%26slt_pos%3DB3%26itm_lp%3D1%26slt_ttd%3D5%26mcm_ccd%3DVIOT%26mcm_refdate%3D20140507%26mmt_id%3DMMTUNKNOWN&promo=main_803_VIOT-1N-MCM-slot-opn1_B3_product_1_";
        bolPage.go_to(productURL);
        String cost = bolPage.get_item_into_shopping_cart(productURL, bolPage.productGT20);
        Assert.assertTrue("Check translation label", cost.equals("Gratis"));
    }

    @After
    public void cleanUp() {
        webDriver.close();
        webDriver.quit();
    }
}
