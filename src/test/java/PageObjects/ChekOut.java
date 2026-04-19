package PageObjects;

import PageObjects.Abstractcomponent.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ChekOut extends abstractComponent {

    WebDriver driver;

    public ChekOut(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css ="[placeholder='Select Country']")
    WebElement Origin;

    @FindBy(css = ".action__submit")
    WebElement placeOrder;

    @FindBy(css = ".hero-primary")
    WebElement confirmationMessage;


    public void SelectCountry(String countryName) {

        waitForWebElementToBeClickable(Origin);

        Origin.clear();
        Origin.sendKeys(countryName);

        waitForElementToAppear(By.cssSelector(".ta-results"));

        List<WebElement> options = driver.findElements(By.cssSelector(".ta-item"));

        WebElement country = options.stream()
                .filter(c -> c.getText().equalsIgnoreCase(countryName))
                .findFirst()
                .orElse(null);

        if (country != null) {

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block:'center'});", country);

            waitForWebElementToBeClickable(country);

            try {
                country.click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();", country);
            }
        }

        waitForElementToDisappear(By.cssSelector(".ta-results"));
    }

    // =========================
    // PLACE ORDER
    // =========================
    public void placeOrder(){

        waitForLoaderToDisappear();

        waitForWebElementToBeClickable(placeOrder);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", placeOrder);

        try {
            placeOrder.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", placeOrder);
        }
    }


    public String SubmitOrder(){

        waitForElementToAppear(By.cssSelector(".hero-primary"));

        waitForWebElementToBeClickable(confirmationMessage);

        return confirmationMessage.getText().trim();
    }
}