package PageObjects.Abstractcomponent;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class abstractComponent  {
WebDriver driver;



    public abstractComponent(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement additem;

    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement cartOrder;


    public GoToHeaderPage  GoToHeaderPage() {

        waitforWebelementtoAppear(cartOrder);
        cartOrder.click();

        return new GoToHeaderPage(driver);
    }

    public GoToHeaderPage goToOrdersPage() {

        waitforWebelementtoAppear(cartOrder);
        cartOrder.click();

        return new GoToHeaderPage(driver);
    }


    public void waitForElementToAppear(By findby) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));

    }


    public void waitforWebelementtoAppear(WebElement findby) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findby));

    }





    public void waitForElementTodisapear(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele));

    }
        public void ToCart(){
        additem.click();

        }



}

