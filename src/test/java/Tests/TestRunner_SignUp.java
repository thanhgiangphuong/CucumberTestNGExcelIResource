package Tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/signup.feature",tags = "@TC-S03",
        glue = {"Steps"},
        monochrome = true
)
public class TestRunner_SignUp extends AbstractTestNGCucumberTests
{
}