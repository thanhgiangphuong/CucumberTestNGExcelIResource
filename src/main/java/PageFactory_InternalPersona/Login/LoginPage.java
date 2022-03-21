package PageFactory_InternalPersona.Login;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject {

    protected static WebDriver driver;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/div/div[1]/form/div[5]/button")
    WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/div/div[1]/form/div[2]/p")
    WebElement alertEmail;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/div/div[1]/form/div[3]/p")
    WebElement alertPass;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/div/div[2]/a")
    WebElement SignUpHere;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/div/h2")
    WebElement LogInTitle;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/div/div[1]/form/div[2]/p")
    WebElement InvalidEmailAlert;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]")
    WebElement InvalidPassAlert;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div/div[1]/form/div[4]/label/span")
    WebElement RememberMe;


    // Create constructor with PageFactory
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Create method handle Login page
    public String getTextAlert() {
        return alertEmail.getText();
    }

    public String getTextAlertPass() {
        return alertPass.getText();
    }
    public void loginToIResource(String strUserName, String strPassword) {
        emailInput.sendKeys(strUserName);
        passwordInput.sendKeys(strPassword);
        loginBtn.click();
    }
    public void EnterEmail(String username){
        emailInput.sendKeys(username);
    }
    public void EnterPassWord(String password){
        passwordInput.sendKeys(password);
    }
    public void ClickLoginBtn(){
        loginBtn.click();
    }
    public void clickSignUpHere() {
        SignUpHere.click();
    }
    public String getTextLogInTitle() {
        return LogInTitle.getText();
    }
    public String getTextInvalidEmailAlert() {
        return InvalidEmailAlert.getText();
    }
    public String getTextInvalidPassAlert() {
        return InvalidPassAlert.getText();
    }
    public boolean RememberMe_isChecked() {
        return RememberMe.isSelected();
    }
}
