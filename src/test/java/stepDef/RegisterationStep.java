package stepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import page_object.Homepage;
import page_object.RegisterationPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterationStep {
    private RegisterationPage registerationPage = new RegisterationPage();
    private Homepage homepage = new Homepage();

    @When("^User click on account icon on homepage$")
    public void user_click_on_account_icon_on_homepage() {
        registerationPage.clickOnAccountIcon();
    }

    @Then("^User should be able to see Registration page successfully$")
    public void user_should_be_able_to_see_Registration_page_successfully() {
        String actualRegisterationUrl = homepage.currentUrl();
        assertThat(actualRegisterationUrl, Matchers.containsString("login"));
    }
}
