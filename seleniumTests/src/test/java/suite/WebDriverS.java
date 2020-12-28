package suite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverS {
    private static WebDriver instance;

    public static WebDriver getChromeDriver() {
        if (instance == null) setupChromeDriver();
        return instance;
    }

    private static void setupChromeDriver() {
        BasicConfigurator.configure();
        WebDriverManager.chromedriver().setup();
        instance = new ChromeDriver();
        instance.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
