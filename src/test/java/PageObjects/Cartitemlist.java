package PageObjects;

import PageObjects.Abstractcomponent.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class Cartitemlist extends abstractComponent {
    WebDriver driver;


    @FindBy(css = ".cartSection h3")
    List<WebElement> items;

    @FindBy(css = ".totalRow button")
    WebElement check;


    public Cartitemlist(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean VerifyProductCart(String productName) {
        waitForElementToAppear(By.cssSelector(".cartSection"));
        return items.stream()
                .anyMatch(t -> t.getText().trim().equalsIgnoreCase(productName));
    }

    public ChekOut checkout() {

        // Step 1: wait for loader to disappear
        waitForLoaderToDisappear();

        waitForElementToAppear(By.cssSelector(".totalRow"));

        // Step 2: wait until clickable
        waitForWebElementToBeClickable(check);

        // Step 3: scroll into view
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", check);

        // Step 4: wait again after scroll
        waitForWebElementToBeClickable(check);

        // Step 5: safe click
        try {
            check.click();
        } catch (Exception e) {
            // fallback if intercepted
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", check);
        }

        return new ChekOut(driver);
    }
}




