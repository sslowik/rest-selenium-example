package suite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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
