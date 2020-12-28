package suite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

public class AddItemsTest extends BaseTest {

    public static final String baseUrl = "http://automationpractice.com/index.php";

    static final String X_POPULAR_TAB = "";
    static final String X_BEST_SELLERS_TAB = "";

    @FindBy(css = "#homefeatured.product_list li.ajax_block_product")
    private List<WebElement> popularProducts;

    @FindBy(css = "#blockbestsellers.product_list li.ajax_block_product")
    private List<WebElement> bestSellerProducts;

    /**
     * Dodać 3 dowolne rzeczy do koszyka oraz sprawdzić czy poprawnie jest liczona
     * łączna kwota
     */
    @Test(priority = 1)
    void openUrl() {
        driver.get(baseUrl);
        String expectedTitle = "My Store";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle);
        Reporter.log("Opened URL: " + baseUrl);
        PageFactory.initElements(driver, this);
    }

    @Test(priority = 2, dependsOnMethods = "openUrl")
    void addItemsToBasket() {
        Reporter.log("Number of Best Selling products: " + bestSellerProducts.size());
        Reporter.log("Number of Popular products: " + popularProducts.size());
    }
}
