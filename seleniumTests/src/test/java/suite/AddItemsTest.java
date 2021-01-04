package suite;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AddItemsTest extends BaseTest {

    static Logger logger = Logger.getLogger(AddItemsTest.class);
    static final String baseUrl = "http://automationpractice.com/index.php";
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
        WebDriverWait waitMedium = new WebDriverWait(driver, 3);
        Reporter.log("Number of Best Selling products: " + bestSellerProducts.size());
        Reporter.log("Number of Popular products: " + popularProducts.size());

        String x_activeTab = "//ul[@id='home-page-tabs']/li[@class='active']/a";
        String x_bestSellers = "//ul[@id='home-page-tabs']/li[@class='active']/a[text()='Best Sellers']";
        WebElement activeTab = driver.findElement(By.xpath(x_activeTab));
        String active = activeTab.getText();
        System.out.println("active = " + active);
        logger.info("Active tab = " + active);
        WebElement tabPopularProducts = driver.findElement(By.className("homefeatured"));

        Actions a = new Actions(driver);
        a.moveToElement(tabPopularProducts);
        a.sendKeys(Keys.PAGE_DOWN).perform();

        Map<String, Double> productsWithPrices = new LinkedHashMap<>();
        int productsToAdd = 3;
        for (int i = 0; i < productsToAdd; i++) {
            //TODO extract class ProductContainer PopUp
            WebElement product = popularProducts.get(i);
            moveTo(product);
            String x_popularProductContainer = "//ul[@id='homefeatured']//div[@class='product-container']";
            String x_addButtonByProductId = x_popularProductContainer + "//div[@class='button-container']" + "/a[contains(@class, 'ajax_add_to_cart_button') and @data-id-product='%d']/span";
            String x_productPrice = "//body[@id='product']//button[@name='Submit']";
            String x_productName = "//body[@id='product']//button[@name='Submit']";

            WebElement addButton = waitMedium.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(x_addButtonByProductId, i + 1))));
            addButton.click();
            String x_continueBtn = "//div[@class='clearfix' and contains(., 'Product successfully added to your shopping cart')]//span[contains(@class, 'btn') and @title='Continue shopping']";
            WebElement continueButton = waitMedium.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(x_continueBtn)));
            continueButton.click();
            waitMedium.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(x_continueBtn)));
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
