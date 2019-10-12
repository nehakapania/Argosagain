package stepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import page_object.BasketPage;
import page_object.TrolleyPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class TrolleyStep {
    private TrolleyPage trolleyPage = new TrolleyPage();
    private BasketPage basketPage = new BasketPage();

    @When("^User add basket product to go to trolley$")
    public void user_add_basket_product_to_go_to_trolley() {
        trolleyPage.goToTrolley();
        List<String> actualTrolleyProducts = trolleyPage.productsAddedInTrolley();
        System.out.println(actualTrolleyProducts);
    }

    @When("^User increase quantity \"([^\"]*)\"of selected product$")
    public void user_increase_quantity_of_selected_product(int customerSelectedQuantity) {
        trolleyPage.increaseProductQuantity(customerSelectedQuantity);

    }


    @Then("^User should be able to see products increased of selected product$")
    public void user_should_be_able_to_see_products_increased_of_selected_product() {

        // List<String> actualTrolleyProducts=trolleyPage.productsAddedInTrolley();
        //  System.out.println(actualTrolleyProducts);
        //  assertThat(actualTrolleyProducts, Matchers.hasItem(basketPage.randomSelectedProduct));

    }

    // in these steps user can remove product from trolley
    @When("^User removed the product from basket$")
    public void user_removed_the_product_from_basket()
    {
        trolleyPage.removeProductFromTrolley();
    }

    @Then("^User should be able to see that product is removed from basket$")
    public void user_should_be_able_to_see_that_product_is_removed_from_basket() {
        String trolleyStatus=trolleyPage.trolleyIsEmpty();
        System.out.println(trolleyStatus);
        assertThat(trolleyStatus,Matchers.equalToIgnoringCase(trolleyPage.trolleyMessage));
    }


    // This method will help you to undo remove the same product and been added again to basket
    @When("^User select undo removed product on Trolley page$")
    public void user_select_undo_removed_product_on_Trolley_page()  {
        trolleyPage.undoProductToTrolley();

    }

    @Then("^User should be able to  see that  same deleted product added again to trolley$")
    public void user_should_be_able_to_see_that_same_deleted_product_added_again_to_trolley()
    {
      String actualTrolleyName=trolleyPage.trolleyHeaderName();
      assertThat(actualTrolleyName,Matchers.equalToIgnoringCase(trolleyPage.trolley));
    }


}
