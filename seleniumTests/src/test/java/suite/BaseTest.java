package suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.WebDriverSingleton;

public abstract class BaseTest {

    public WebDriver driver;

    @BeforeTest
    void setupChromeDriver() {
        driver = WebDriverSingleton.getChromeDriver();
    }

    @AfterTest
    void tearDown() {
        driver.close();
        driver.quit();
    }

    public void moveTo(WebElement we) {
        Actions actions = new Actions(driver);
        actions.moveToElement(we);
        actions.perform();
    }

    public void moveTo(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        moveTo(element);
    }
}
