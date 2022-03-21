package PageFactory_InternalPersona.SignUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailLoginPage {
    // Initialize driver variable
    protected static WebDriver driver;

    // Find elements following Page Factory design pattern
    @FindBy(id = "code")
    WebElement QATeamAcc;

    @FindBy(id = "submit_code")
    WebElement NextBtn;

    // Create constructor with PageFactory
    public EmailLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create open QA.Team email URL
    public void openQATeam(String username) {
        QATeamAcc.sendKeys(username);
        NextBtn.click();
    }
}
