package suite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.WebDriverS;

public class BaseTest {

    public static final String baseUrl = "http://automationpractice.com/index.php";

    WebDriver driver;

    @BeforeTest
    void setupChromeDriver() {
        driver = WebDriverS.getChromeDriver();
    }

    @AfterTest
    void tearDown() {
        driver.close();
        driver.quit();
    }
}
