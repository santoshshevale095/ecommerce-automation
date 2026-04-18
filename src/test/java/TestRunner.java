
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = "src/test/java",
            glue = "",
            plugin = {"pretty"},
            monochrome = true
    )
    public class TestRunner extends AbstractTestNGCucumberTests {
    }



