package Steps;

import BasePage.BaseClass;
import BasePage.CommonMethods;
import PageFactory_InternalPersona.Login.LoginPage;
import PageFactory_InternalPersona.Login.ProjectExplorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends BaseClass {
    LoginPage loginPage;
    ProjectExplorePage projectExplorePage;
    CommonMethods commonMethods = new CommonMethods();


    @Given("^I open Login page$")
    public void OpenLoginPage() {
        setDriver();
        loginPage = new LoginPage(driver);
    }

    @Then("^I want to verify RememberMe checkbox isn't selected in default$")
    public void VerifyRememberMeCheckBoxIsNotSelectedInDefault() throws InterruptedException {
        commonMethods.compareFalse(loginPage.RememberMe_isChecked());
        tearDown();
    }

    @When("^I login with email blank and valid password is (.*)$")
    public void Login_EmailBlank(String pass) {
        loginPage.EnterPassWord(pass);
        loginPage.ClickLoginBtn();
    }

    @Then("^System displays the (.*) message under email field$")
    public void VerifyAlertEmailDisplays(String elert) throws InterruptedException {
        commonMethods.compareText(elert, loginPage.getTextAlert().trim());
        tearDown();
    }

    @When("^I login with password blank and valid email is (.*)$")
    public void Login_PassWordBlank(String email) {
        loginPage.EnterEmail(email);
        loginPage.ClickLoginBtn();
    }

    @Then("^System displays the (.*) message under password field$")
    public void VerifyAlertPassWordDisplays(String elert) throws InterruptedException {
        commonMethods.compareText(elert, loginPage.getTextAlertPass().trim());
        tearDown();
    }

    @When("^I login with wrong format of email is (.*) and valid password is (.*)$")
    public void Login_EmailWrongFormat(String WrongEmailF, String pass) {
        loginPage.loginToIResource(WrongEmailF, pass);
    }

    @Then("^System displays the (.*) message in the email field$")
    public void VerifyAlertEmailWrongDisplays(String elert) throws InterruptedException {
        commonMethods.compareText(elert, loginPage.getTextInvalidEmailAlert().trim());
        tearDown();
    }

    @When("^I login with invalid password is (.*) and valid email is (.*)$")
    public void Login_InvalidPassWord(String email, String invalidPass) throws InterruptedException {
        loginPage.loginToIResource(email, invalidPass);
        commonMethods.ThreadSleep(2000);
    }

    @Then("^System displays the (.*) message in the right top of page$")
    public void VerifyAlertDisplays_TopRight(String alert) throws InterruptedException {
        commonMethods.compareText(alert, loginPage.getTextInvalidPassAlert().trim());
        tearDown();
    }

    @When("^I login with valid data are (.*) and (.*)$")
    public void Login_ValidData(String email, String pass) throws InterruptedException {
        loginPage.loginToIResource(email, pass);
        commonMethods.ThreadSleep(2000);
    }

    @Then("^System navigate to Explore Project page with (.*) displayed$")
    public void VerifyUserNameDisplayInNextPage(String username) throws InterruptedException {
        projectExplorePage = new ProjectExplorePage(driver);
        commonMethods.compareTrue(projectExplorePage.VerifyUsernameContain(username));
        projectExplorePage.Logout();
        tearDown();
    }
}


