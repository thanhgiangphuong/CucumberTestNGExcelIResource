package Tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"Steps"},
        monochrome = true
)
public class TestRunner_Login extends AbstractTestNGCucumberTests {
}
