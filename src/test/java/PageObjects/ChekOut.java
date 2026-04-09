package PageObjects;

import PageObjects.Abstractcomponent.abstractComponent;
import org.openqa.selenium.By;
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

    @FindBy(css = ".ta-item")
    List<WebElement> countryList;

    @FindBy(css = ".hero-primary")
    WebElement submit;

    @FindBy(css = ".action__submit")
    WebElement placeOrder;

    @FindBy(css = ".hero-primary")
    WebElement confirmationMessage;



    public void SelectCountry(String countryName){

        Origin.sendKeys(countryName);

        countryList.stream().filter(c-> c.getText().equalsIgnoreCase(countryName)).findFirst()
                .ifPresent(WebElement::click);

    }

    public String SubmitOrder(){

        submit.click();
        waitForElementToAppear(By.cssSelector(".hero-primary"));
        return confirmationMessage.getText();

    }

public void placeOrder(){

    placeOrder.click();
}


}
