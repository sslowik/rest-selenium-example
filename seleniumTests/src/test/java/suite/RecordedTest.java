package suite;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RecordedTest {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @BeforeClass(alwaysRun = true)
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "https://www.google.com/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testUntitledTestCase() throws Exception {
            driver.get("https://us1a.app.anaplan.com/core3808/anaplan/framework.jsp?selectedWorkspaceId=8a81b09b56cdf8a10156e6723d173c9f&selectedModelId=28222ACA462E4F9CAF3374EAADA816B2");
            driver.findElement(By.xpath("//div[@id='anaplan_dashboard_dashboardWidgets__Gridlet_2']/div/div[2]")).click();
            driver.findElement(By.xpath("//div[@id='anaplan_dashboard_dashboardWidgets__Cell_3']/div")).click();
            driver.findElement(By.xpath("//div[@id='anaplan_dashboard_dashboardWidgets__Gridlet_2']/div/div[2]")).click();
            driver.findElement(By.xpath("//div[@id='anaplan_dashboard_dashboardWidgets__Gridlet_2']/div/div[2]")).click();
            driver.findElement(By.xpath("//div[@id='anaplan_dashboard_dashboardWidgets__Gridlet_2']/div/div[2]")).click();
            driver.findElement(By.xpath("//div[@id='anaplan_dashboard_dashboardWidgets__Gridlet_2']/div/div[2]")).click();
            driver.findElement(By.id("uniqName_30_8")).click();
            driver.findElement(By.xpath("//div[@id='anaplan_dashboard_dashboardWidgets__Gridlet_2']/div/div[2]")).click();
            driver.findElement(By.id("anaplan_widgets_GridSelection_4")).click();
            driver.findElement(By.id("anaplan_widgets_GridSelection_4")).click();
            driver.findElement(By.id("anaplan_widgets_GridSelection_4")).click();
            // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=anaplan_widgets_GridSelection_4 | ]]
            driver.findElement(By.id("dijit_form_TextBox_12")).clear();
            driver.findElement(By.id("dijit_form_TextBox_12")).sendKeys("100");
            driver.findElement(By.id("dijit_form_TextBox_12")).sendKeys(Keys.ENTER);
            driver.findElement(By.id("anaplan_widgets_GridSelection_4")).click();
            driver.findElement(By.id("anaplan_widgets_GridSelection_4")).click();
            // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=anaplan_widgets_GridSelection_4 | ]]
            driver.findElement(By.xpath("//div[@id='anaplan_dashboard_dashboardWidgets__Gridlet_2']/div/div[2]")).click();
            driver.findElement(By.id("anaplan_widgets_GridSelection_4")).click();
            // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=anaplan_widgets_GridSelection_4 | ]]
            driver.findElement(By.id("dijit_form_TextBox_12")).clear();
            driver.findElement(By.id("dijit_form_TextBox_12")).sendKeys("");
            driver.findElement(By.xpath("//header[@id='header']/div[3]/div/div/div[3]/div/a/span[5]")).click();
            driver.findElement(By.xpath("//div[@id='center_column']/p")).click();
            driver.findElement(By.xpath("//div[@id='center_column']/p")).click();
            driver.findElement(By.linkText("Sign in")).click();
            driver.findElement(By.linkText("Women")).click();
            driver.findElement(By.xpath("//div[@id='center_column']/ul/li/div/div[2]/div[2]/a/span")).click();
            driver.findElement(By.xpath("//div[@id='center_column']/ul/li[2]/div/div[2]/div[2]/a/span")).click();
            driver.findElement(By.xpath("//body[@id='category']/div[2]/div/div/a")).click();
            driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/span/span")).click();
            driver.findElement(By.xpath("//div[@id='center_column']/ul/li[2]/div/div[2]/div[2]/a/span")).click();
            driver.findElement(By.xpath("//body[@id='category']/div[2]/div/div/a")).click();
            driver.findElement(By.xpath("//div[@id='center_column']/ul/li[3]/div/div[2]/div[2]/a/span")).click();
            driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/span/span")).click();
            driver.findElement(By.xpath("//div[@id='center_column']/ul/li[4]/div/div[2]/div[2]/a/span")).click();
            driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/span/span")).click();
            driver.findElement(By.xpath("//header[@id='header']/div[3]/div/div/div[3]/div/a/b")).click();
            driver.findElement(By.id("total_price")).click();
            driver.findElement(By.xpath("//header[@id='header']/div[3]/div/div/div[3]/div/div/div/div/div/div[2]/span")).click();
            driver.findElement(By.xpath("//header[@id='header']/div[3]/div/div/div[3]/div/a")).click();
            driver.findElement(By.xpath("//img[@alt='My Store']")).click();
            driver.findElement(By.linkText("Best Sellers")).click();
            driver.findElement(By.xpath("//ul[@id='blockbestsellers']/li[2]/div/div[2]/div[2]/a/span")).click();
            driver.findElement(By.xpath("//div[@id='layer_cart']/div/div/span")).click();
            driver.findElement(By.linkText("Best Sellers")).click();
        }

        @AfterClass(alwaysRun = true)
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }
    }

