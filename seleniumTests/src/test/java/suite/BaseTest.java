package suite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.WebDriverSingleton;

public class BaseTest {

    public static final String baseUrl = "http://automationpractice.com/index.php";

    WebDriver driver;

    @BeforeTest
    void setupChromeDriver() {
        driver = WebDriverSingleton.getChromeDriver();
    }

    @AfterTest
    void tearDown() {
        driver.close();
        driver.quit();
    }
}
