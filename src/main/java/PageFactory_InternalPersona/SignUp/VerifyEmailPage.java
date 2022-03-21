package PageFactory_InternalPersona.SignUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyEmailPage {
    // Initialize driver variable
    protected static WebDriver driver;

    // Find elements following Page Factory design pattern
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[2]/div[2]/div/form/div[1]/p[1]")
    WebElement VerifyEmailText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]/div/form/div[2]/input")
    WebElement TextBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]/div/form/button")
    WebElement ConfirmBtn;

    // Create constructor with PageFactory
    public VerifyEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create method to get text verify email content text
    public String getTextVerifyEmailText() {
        return VerifyEmailText.getText();
    }

    // Create method to enter verify code into text box
    public void EnterVerifyCode(String digitCode) throws InterruptedException {
        TextBox.sendKeys(digitCode);
    }
    public void clikCfmBtn(){
        ConfirmBtn.click();
    }
}
