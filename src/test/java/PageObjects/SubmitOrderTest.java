package PageObjects;

import Data.DataReader;
import PageObjects.Abstractcomponent.BaseTest;
import PageObjects.Abstractcomponent.GoToHeaderPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class SubmitOrderTest extends BaseTest {



   @Test (dataProvider="getdata")

           public void submitOrder(HashMap<Object,Object> input) throws IOException {


       // Driver already initialized in @BeforeMethod
       landingPage land = new landingPage(driver);
        // Landing Page

        land.loginApplication((String) input.get("email"), (String) input.get("pwd"));

        // Product Catalog
        productCatalog catalog = new productCatalog(driver);
        catalog.addtoCart((String) input.get("productName"));
        catalog.ToCart();

        // Cart Page
       String productName = (String) input.get("productName");

       Cartitemlist basket = new Cartitemlist(driver);
        boolean match = basket.VerifyProductCart(productName);
       System.out.println(match);
        Assert.assertTrue(match);

       // Checkout Page
        ChekOut checkout = basket.checkout();
        checkout.SelectCountry("India");
        checkout.placeOrder();
        String confirmMsg = checkout.SubmitOrder();
        System.out.println(confirmMsg);

    }


    public String getScreenshot(String testCaseName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
      File source =  ts.getScreenshotAs(OutputType.FILE);

        File file = new File (System.getProperty("user.dir")+"/reports/" + testCaseName +".png");
        FileUtils.copyFile(source,file);
        return testCaseName;
    }




    @Test(dependsOnMethods={"submitOrder"})
    public void orderHistory(){


        String productName = "ADIDAS ORIGINAL";
        landingPage land = new landingPage(driver);
        land.loginApplication("santoshshevale@gmail.com", "Pass@1234");

        GoToHeaderPage Orderlist = land.goToOrdersPage(); // ✅ now works

       Assert.assertTrue(Orderlist.verifyDisplayedOrder(productName)); // ✅ enable this


    }

@DataProvider
    public Object[][] getdata() throws IOException {
    DataReader details = new DataReader();
   List<HashMap<String,String>>  data = details.getJsonDataMap(System.getProperty("user.dir") + "/src/test/java/Data/purchaseorder.json");



     return  new Object[] [] {{data.get(0)},{data.get(1)}};

}
}
