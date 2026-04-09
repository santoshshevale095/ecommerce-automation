
package PageObjects.Abstractcomponent;

import PageObjects.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

    public class BaseTest {

        public static WebDriver driver;
        public static WebDriver browserLaunch() throws IOException {



            //properties class
            Properties prop = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/Resources/GlobalData.properties");
            prop.load(file);
            String browserName = System.getProperty("browser") != null
                    ? System.getProperty("browser")
                    : prop.getProperty("browser");

            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();



            }

            else  if (browserName.equalsIgnoreCase("edge"))
            {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();


            }


            else if (browserName.equalsIgnoreCase("firefox")){

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();


            }


            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();


            return driver;
        }

        @BeforeMethod
        public static landingPage launchApplication() throws IOException {

            driver = browserLaunch();
            driver.get("https://rahulshettyacademy.com/client/#/auth/login"); // move here
            return new landingPage(driver);

        }

        @AfterMethod
      public void teardown()
      {
        driver.quit();
       }

    }




