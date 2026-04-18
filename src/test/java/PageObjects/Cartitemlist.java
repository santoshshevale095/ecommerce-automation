package PageObjects;

import PageObjects.Abstractcomponent.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class Cartitemlist extends abstractComponent {
    WebDriver driver;


    @FindBy(xpath = "//div/h3[1]")
    List<WebElement> items;

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement check;


    public Cartitemlist(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public boolean VerifyProductCart(String productName) {

        WebElement item = items.stream().filter(t -> t.getText().equals(productName)).findFirst().orElse(null);
        if (item != null) {
            System.out.println(item.getText());
            return true;
        }

        return false;
    }

    public ChekOut checkout() {
        check.click();
        return new ChekOut(driver);
    }




}








