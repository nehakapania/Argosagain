package stepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import page_object.BasketPage;
import page_object.WishlistPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class WishlistStep {

    private WishlistPage wishlistPage = new WishlistPage();
    private BasketPage basketPage = new BasketPage();

    @When("^User select on wishlist icon on result page$")
    public void user_select_on_wishlist_icon_on_result_page() {
        wishlistPage.addProductToWishliost();

    }

    @Then("^User should see product been added to the wishlist$")
    public void user_should_see_product_been_added_to_the_wishlist() {
        wishlistPage.clickWishIcon();
        List<String> actualCollectedWishlist = wishlistPage.productsInWishlist();
        assertThat(actualCollectedWishlist, Matchers.containsInAnyOrder(basketPage.randomSelectedProduct));
    }

}
