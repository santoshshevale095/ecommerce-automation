package PageObjects;

import PageObjects.Abstractcomponent.abstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productCatalog extends abstractComponent {

    WebDriver driver;

    public productCatalog(WebDriver driver){
        super(driver);
      this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".col-lg-4")
    List<WebElement> product;
    By productsBy = By.cssSelector(".col-lg-4");
    By CartItem = By.cssSelector(".card-body button:last-of-type");
    By Toast = By.id("toast-container");



    @FindBy(css =".ngx-spinner-overlay")
    WebElement spinner;

public List<WebElement> productlist(){

    waitForElementToAppear(productsBy);
    return product;
}


public WebElement getProdName(String productName){

    WebElement prod =  product.stream().filter(s-> s.findElement(By.cssSelector("b")).getText().
                      equals(productName)).findFirst().orElse(null);
                assert prod != null;
return prod;
}


public void addtoCart(String productName){

    WebElement prod = getProdName(productName);
    prod.findElement(CartItem).click();
    waitForElementToAppear(Toast);
    waitForLoaderToDisappear();

}


}
