package stepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import page_object.Homepage;
import page_object.StoreFinderPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class StoreFinderStep {
    private StoreFinderPage storeFinderPage=new StoreFinderPage();
    private Homepage homepage=new Homepage();

    @When("^User click on Store icon on homepage$")
    public void user_click_on_Store_icon_on_homepage()  {
         storeFinderPage.findAStore();
    }

    @Then("^User should able to see a sore finder result page with search box successfully$")
    public void user_should_able_to_see_a_sore_finder_result_page_with_search_box_successfully() {
        String actualStoreFinderUrl=homepage.currentUrl();
        assertThat(actualStoreFinderUrl, Matchers.containsString("stores"));
    }
    @When("^User search for a store with \"([^\"]*)\"$")
    public void user_search_for_a_store_with_or_city_name(String customerSelectedStore)  {
        storeFinderPage.findStoreInSearch(customerSelectedStore);

    }

    @When("^User click on search magnifier glass$")
    public void user_click_on_search_magnifier_glass()  {
        storeFinderPage.clickOnMagnifier();
    }

    @Then("^User should able to see all nearer located stores successfully$")
    public void user_should_able_to_see_all_nearer_located_stores_successfully() {
         List<String> actualStoreNameList=storeFinderPage.collectStoreName();
         assertThat(actualStoreNameList,Matchers.hasItem(StoreFinderPage.storeName));
    }

}
