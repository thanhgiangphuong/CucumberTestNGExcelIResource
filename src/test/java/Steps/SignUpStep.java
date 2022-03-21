package Steps;

import BasePage.BaseClass;
import BasePage.CommonMethods;
import BasePage.ExcelHelpers;
import PageFactory_InternalPersona.Login.LoginPage;
import PageFactory_InternalPersona.SignUp.SignUpPage;
import PageFactory_InternalPersona.SignUp.VerifyEmailPage;
import io.cucumber.java.en.*;

public class SignUpStep extends BaseClass {
    LoginPage loginPage;
    SignUpPage signUpPage;
    CommonMethods commonMethods;
    VerifyEmailPage verifyEmailPage;
    ExcelHelpers excel = new ExcelHelpers();

    @Given("^I want to open Login page$")
    public void openLoginPage() {
        setDriver();
        loginPage = new LoginPage(driver);
    }

    @When("^I click on Sign Up Here hyperlink$")
    public void ClickOnSignUpHere() {
        loginPage.clickSignUpHere();
        signUpPage = new SignUpPage(driver);
    }

    @Then("^The system navigate to SignUp page$")
    public void VerifySignUpPageDisplays() throws InterruptedException {
        commonMethods.compareText("Sign Up", signUpPage.getTextSignUpTitle().trim());
        tearDown();
    }

    @Then("^The Internal Personal RadioBtn is selected in default$")
    public void VerifyInternalPersonalRadioBtn_isSelectedInDefault() throws InterruptedException {
        commonMethods.compareTrue(signUpPage.RadioBtnChecked());
        tearDown();
    }

    @And("^I enter (.*), (.*), (.*), (.*)$")
    public void EnterData_WithoutFirstName(String lastName, String email, String pass, String cfmPass) {
        signUpPage.EnterLastName(lastName);
        signUpPage.EnterEmail(email);
        signUpPage.EnterPassWord(pass);
        signUpPage.EnterCfmPassWord(cfmPass);
    }

    @And("^I click SignUp button$")
    public void clickSignUp() {
        signUpPage.ClickSignUpBtn();
    }

    @Then("^The (.*) displays under FirstName field$")
    public void VerifyAlertFirstNameDisplays(String alert) throws InterruptedException {
        commonMethods.compareText(alert, signUpPage.getTextFirstNameAlert().trim());
        tearDown();
    }

    @And("^I enter valid data into (.*), (.*), (.*)$")
    public void EnterData_PassWordDontMatch(String firstname, String lastname, String email) {
        signUpPage.EnterFirstName(firstname);
        signUpPage.EnterLastName(lastname);
        signUpPage.EnterEmail(email);
    }

    @But("^I enter (.*) don't match with (.*)$")
    public void PasswordDontMatch(String pass, String cfmpass) {
        signUpPage.EnterPassWord(pass);
        signUpPage.EnterCfmPassWord(cfmpass);
    }

    @Then("^The (.*) displays under Confirm Password field$")
    public void VerifyAlertPasswordDontMatchDisplays(String alert) throws InterruptedException {
        commonMethods.compareText(alert, signUpPage.getTextCfmPassAlert().trim());
        tearDown();
    }

    @When("^I sign up with valid data$")
    public void EnterValidData() throws Exception {
        excel.setExcelFile("C:\\Users\\zangzang\\Desktop\\SignUpData.xlsx", "SignUpData");
        signUpPage.SignUpInput_InternalPersona(
                excel.getCellData(3, 0),
                excel.getCellData(3, 1),
                excel.getCellData(3, 2),
                excel.getCellData(3, 4),
                excel.getCellData(3, 5));
    }
    @And("^I wait 10 seconds$")
    public void WaitForPageLoad() throws InterruptedException {
        commonMethods.ThreadSleep(10000);
    }

    @Then("^System navigate to VerifyEmail page with new (.*)$")
    public void VerifyNavigateToVerifyEmailPage(String URL) throws InterruptedException {
        verifyEmailPage = new VerifyEmailPage(driver);
        commonMethods.compareText(URL, commonMethods.getURL(driver));
        tearDown();
    }
}
