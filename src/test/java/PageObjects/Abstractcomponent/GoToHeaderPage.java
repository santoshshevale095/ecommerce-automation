package PageObjects.Abstractcomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoToHeaderPage extends abstractComponent {


    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement order;

    @FindBy(css = "tr td:nth-of-type(2)")
    private List<WebElement> orderItems;

    public GoToHeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);



    }




    public boolean verifyDisplayedOrder(String productName) {


        for (WebElement item : orderItems) {
            System.out.println("Order Item: " + item.getText());
        }
        return orderItems.stream()
                .anyMatch(item -> item.getText().equalsIgnoreCase(productName));
    }
}







