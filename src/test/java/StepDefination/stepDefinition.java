package StepDefination;

import PageObjects.landingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDefinition {

    WebDriver driver;
    landingPage lp;

    @Given("I land on the login page")
    public void I_land_on_the_login_page() {
        driver = new ChromeDriver();
        lp = new landingPage(driver);
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    }

    @When("I login with username {string} and password {string}")
    public void login(String username, String password) {
        lp.loginApplication(username, password);
    }

    @When("I add the products {string}")
    public void addProducts(String productName) {
        // add to cart logic
    }

    @Then("the user checks out {string} and submits the order")
    public void checkout(String productName) {
        // checkout logic
    }
}
