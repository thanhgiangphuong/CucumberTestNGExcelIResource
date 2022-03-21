package PageFactory_InternalPersona.SignUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
    // Initialize driver variable
    protected static WebDriver driver;

    // Find elements following Page Factory design pattern
    @FindBy(xpath = "/html/body/main/div/div/div/div[1]/a/div[3]")
    WebElement newMail;

    @FindBy(xpath = "/html/body/main/div/div/div/div[1]/div/div/div/pre")
    WebElement VerifyCode;

    // Create constructor with PageFactory
    public EmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create methods to handle Email Page
    public void openMail() {
        newMail.click();
    }
    public boolean newMailExist() {
        return newMail.isDisplayed();
    }
    public String getTextVerifyCode() {
        String code = VerifyCode.getText();
        int index = code.lastIndexOf("t:");
        String lastString = code.substring(index + 2).trim();
        String result = lastString.substring(0, lastString.length() - 40);
    //    System.out.println(result);
        return result;
    }
}
