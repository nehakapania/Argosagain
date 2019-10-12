package stepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import page_object.HelpPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class HelpStep {
    private HelpPage helpPage=new HelpPage();

    @When("^User click on help icon on homepage$")
    public void user_click_on_help_icon_on_homepage()  {
        helpPage.getHelp();
    }

    @Then("^User should able to see a help result page successfully$")
    public void user_should_able_to_see_a_help_result_page_successfully()
    {
        String actualHelpHeader=helpPage.getHelpHeader();
        assertThat(actualHelpHeader, Matchers.equalToIgnoringCase(helpPage.helpHeaderName));
    }

    @When("^User ask a  question in help search box\"([^\"]*)\"$")
    public void user_ask_a_question_in_help_search_box(String customerAskedQuestion) {
        helpPage.askAQuestion(customerAskedQuestion);
    }


    @Then("^User should be navigated to a help result page successfully$")
    public void user_should_be_navigated_to_a_help_result_page_successfully() {
        String actualSearchedQuestion=helpPage.searchedTitle();
        assertThat(actualSearchedQuestion,Matchers.containsString(helpPage.searchedTitleHeader));
    }

}
