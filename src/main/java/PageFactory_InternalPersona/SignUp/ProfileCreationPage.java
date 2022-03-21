package PageFactory_InternalPersona.SignUp;

import BasePage.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileCreationPage {
    // Initialize driver variable
    protected static WebDriver driver;
    protected static CommonMethods commonMethods = new CommonMethods();

    // Find elements following Page Factory design pattern
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[1]/nav/div[1]/ul/li/a/span")
    WebElement ProfileCreation;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[1]/nav/div[2]/div/i")
    WebElement LogoutBtn;

    // Create constructor with PageFactory
    public ProfileCreationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create method to get text ProfileInformationTitle
    public String getTextProfileCreation() {
        return ProfileCreation.getText();
    }
    public void Logout(){
        commonMethods.Logout(LogoutBtn);
    }

}
