package PageObjects;

import PageObjects.Abstractcomponent.BaseTest;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import java.io.IOException;


public class BaseClassV2 extends BaseTest {

   @Test (retryAnalyzer= Retry.class)
           public void submitOrderV2() throws IOException {

        String productName = "ADIDAS ORIGINAL";


       // Driver already initialized in @BeforeMethod
       landingPage land = new landingPage(driver);
        // Landing Page

        land.loginApplication("santoshshevale@gmail.in", "Pass@12345");
       Assert.assertEquals(land.getError(), "Incorrect email or password.");

      //div[@aria-label='Incorrect email or password.']
       //    div[aria-label='Incorrect email or password.']


    }

}
