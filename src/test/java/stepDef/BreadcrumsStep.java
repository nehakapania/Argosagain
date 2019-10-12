package stepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import page_object.BreadcrumsPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class BreadcrumsStep {
    private BreadcrumsPage breadcrumsPage=new BreadcrumsPage();
    @When("^User Click on any \"([^\"]*)\" breadcrum$")
    public void user_Click_on_any_breadcrum(String customerSelection)  {
       breadcrumsPage.clickOnAnyBreadcrums(customerSelection);
    }

    @When("^User Click on any \"([^\"]*)\" department$")
    public void user_Click_on_any_department(String customerChoiceSelection)  {
      breadcrumsPage.moveToShopList(customerChoiceSelection);

    }

    @When("^User click on any \"([^\"]*)\" product$")
    public void user_click_on_any_product(String customerSelectedList)  {
     breadcrumsPage.clickOnProduct(customerSelectedList);
    }

    @Then("^User should see respective products successfully$")
    public void user_should_see_respective_products_successfully()  {
     String actualHeaderOfProduct=breadcrumsPage.headerOfProduct();
     assertThat(actualHeaderOfProduct, Matchers.equalToIgnoringCase(breadcrumsPage.productHeaderName));
    }

}
