package stepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page_object.LoginPage;

public class LoginStep {

    LoginPage loginPage=new LoginPage();

    @When("^User enters their valid \"([^\"]*)\" email address$")
    public void user_enters_their_valid_email_address(String email) {
        loginPage.emaillogin(email);
    }

    @When("^User enters valid \"([^\"]*)\" password$")
    public void user_enters_valid_password(String password) {
     loginPage.passwordlogin(password);
    }


    @When("^User click on SignIn button$")
    public void user_click_on_SignIn_button() {
        loginPage.SignInSecurely();
    }

    @Then("^User should be able to login to their account successfully$")
    public void user_should_be_able_to_login_to_their_account_successfully() {

    }



    // these steps are for invalid login
    @When("^User enters their invalid \"([^\"]*)\" email address$")
    public void user_enters_their_invalid_email_address(String email)  {
        //loginPage.emaillogin(email);

    }

    @When("^User enters invalid \"([^\"]*)\" password$")
    public void user_enters_invalid_password(String password)  {
      //  loginPage.passwordlogin(password);

    }

    @Then("^User should not be able to login$")
    public void user_should_not_be_able_to_login()  {

    }

    @Then("^User should get a valid message successfully$")
    public void user_should_get_a_valid_message_successfully() {

    }



}
