package PageObjects;

import PageObjects.Abstractcomponent.abstractComponent;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage extends abstractComponent {

    WebDriver driver;

    public landingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


       //Page factory

    @FindBy (id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userPassword")
    WebElement pwd;
    @FindBy(id = "login")
    WebElement Submit;
    @FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
    WebElement errorMessage;


    //div[@aria-label='Incorrect email or password.']



    public void loginApplication(String email, String pass){
        userEmail.sendKeys(email);
        pwd.sendKeys(pass);
        waitForLoaderToDisappear();
        waitForWebElementToBeClickable(Submit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Submit);

    }


    public String getError(){

        waitforWebelementtoAppear(errorMessage);
       return errorMessage.getText();

    }

public void link(){

    driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    driver.manage().window().maximize();
}
}
