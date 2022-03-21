package PageFactory_InternalPersona.SignUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    // Initialize driver variable
    protected static WebDriver driver;

    // Find elements following Page Factory design pattern
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]/form/div/div[1]/div[1]")
    WebElement InternalPersona;

    @FindBy(name = "firstname")
    WebElement FirstName;

    @FindBy(name = "lastname")
    WebElement LastName;

    @FindBy(name = "email")
    WebElement Email;

    @FindBy(name = "password")
    WebElement PassWord;

    @FindBy(name = "confirmPassword")
    WebElement ConfirmPassWord;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[2]/div[2]/form/div/div[6]/button")
    WebElement SignUpBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]/h2")
    WebElement SignUpTitle;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]/form/div/div[2]/div[1]/p")
    WebElement FirstNameAlert;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]/form/div/div[5]/p")
    WebElement CfmPassAlert;

    // Create constructor with PageFactory
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create method to get text title "Sign Up" in SignUp page
    public String getTextSignUpTitle() {
        return SignUpTitle.getText();
    }

    // Create method to get text the alert display in Firstname field
    public String getTextFirstNameAlert() {
        return FirstNameAlert.getText();
    }

    // Create method to get text the alert display in Confirm Password field
    public String getTextCfmPassAlert() {
        return CfmPassAlert.getText();
    }

    // Create method to check if radio button is checked in default
    public boolean RadioBtnChecked() {
        InternalPersona.isSelected();
        return true;
    }

    // Create method to sign up internal persona account
    public void SignUpInput_InternalPersona(String firstName1, String lastName1, String email1,
                                            String passWord1, String cfmPass1) {
        FirstName.sendKeys(firstName1);
        LastName.sendKeys(lastName1);
        Email.sendKeys(email1);
        PassWord.sendKeys(passWord1);
        ConfirmPassWord.sendKeys(cfmPass1);
        SignUpBtn.click();
    }
    public void EnterFirstName(String firstname){
        FirstName.sendKeys(firstname);
    }
    public void EnterLastName(String lastname){
        LastName.sendKeys(lastname);
    }
    public void EnterEmail(String email){
        Email.sendKeys(email);
    }
    public void EnterPassWord(String passW){
        PassWord.sendKeys(passW);
    }
    public void EnterCfmPassWord(String cfmPassW){
        ConfirmPassWord.sendKeys(cfmPassW);
    }

    public void ClickSignUpBtn(){
        SignUpBtn.click();
    }
}
