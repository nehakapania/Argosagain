package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import page_object.Homepage;
import page_object.ResultPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchStep
{
    // Creating objects of classes to access its methods
    private Homepage homepage=new Homepage();
    private ResultPage resultPage=new ResultPage();

    @Given("^User is on Homepage$")
    public void user_is_on_Homepage() {
        String actualUrl=homepage.currentUrl();   // calling currentUrl method and stored it in actualUrl for assertion
        assertThat("Your Reason:"+"Customer is on different page",actualUrl, Matchers.endsWith("co.uk/"));
    }

    @When("^User search for a \"([^\"]*)\" on search box$")
    public void user_search_for_a_on_search_box(String item)
    {
        homepage.doSearch(item);
    }

    @Then("^User should get the respective product$")
    public void user_should_get_the_respective_product()
    {
        String actualHeader=resultPage.searchedItemHeader();
        assertThat(actualHeader,Matchers.equalToIgnoringCase(homepage.searchedItem));

    }

    @Then("^User should get the respective \"([^\"]*)\"$")
    public void user_should_get_the_respective(String item) {
        String actualHeader=resultPage.searchedItemHeader();
        assertThat(actualHeader,Matchers.equalToIgnoringCase(item));

    }

}
