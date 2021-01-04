package utils;

import org.apache.commons.exec.OS;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver instance;

    public static WebDriver getChromeDriver() {
        if (instance == null) setupChromeDriver();
        return instance;
    }

    private static void setupChromeDriver() {
//        BasicConfigurator.configure();  //TODO debug and fix problems with guava methods in WebDriverManager
//        WebDriverManager.chromedriver().setup();
//        instance = new ChromeDriver(getChromeOptions());
        instance = new ChromeDriver();
        instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        instance.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // version for latest Selenium
        instance.manage().window().maximize();
    }

    private static ChromeOptions getChromeOptions() {
        OS operatingSystem = getOS();
        System.out.println("Operating system: "+ operatingSystem);

//        System.setProperty("webdriver.chrome.silentOutput", "true");
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
//        prefs.put("profile.default_content_settings.popups", 0);
//        prefs.put("download.prompt_for_download", "false");
//        prefs.put("behavior", "allow");
//        prefs.put("browser.setDownloadBehavior", "allow");
        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--start-maximized");
        return options;
    }

    private enum OS {
        WINDOWS, LINUX, MAC, SOLARIS
    }

    private static OS getOS() {
        OS os = null;
        String operSys = System.getProperty("os.name").toLowerCase();
        if (operSys.contains("win")) {
            os = OS.WINDOWS;
        } else if (operSys.contains("nix") || operSys.contains("nux")
                || operSys.contains("aix")) {
            os = OS.LINUX;
        } else if (operSys.contains("mac")) {
            os = OS.MAC;
        } else if (operSys.contains("sunos")) {
            os = OS.SOLARIS;
        }
        return os;
    }
}
