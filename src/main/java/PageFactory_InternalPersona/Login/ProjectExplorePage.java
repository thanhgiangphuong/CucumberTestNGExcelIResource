package PageFactory_InternalPersona.Login;

import BasePage.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectExplorePage {
    // Initialize driver variable
    protected static WebDriver driver;
    protected static CommonMethods commonMethods = new CommonMethods();

    // Find elements following Page Factory design pattern
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[1]/nav/div[2]/div/span")
    WebElement UserName;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[1]/nav/div[2]/div/i")
    WebElement LogoutBtn;

    // Create constructor with PageFactory
    public ProjectExplorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create methods to handle project explore page
    public String getTextUserName() {
        return UserName.getText();
    }
    public boolean VerifyUsernameContain(String userName){
        getTextUserName().toLowerCase().contains(userName);
        return true;
    }
    public void Logout(){
        commonMethods.Logout(LogoutBtn);
    }
}
