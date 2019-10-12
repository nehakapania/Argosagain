package stepDef;

import com.google.common.collect.Ordering;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import page_object.Homepage;
import page_object.ResultPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FilterStep {
    // Creating objects of classes to access its methods
    private Homepage homepage = new Homepage();
    private ResultPage resultPage = new ResultPage();


    @When("^User select a filter by \"([^\"]*)\" on result page products$")
    public void user_select_a_filter_by_on_result_page_products(String customerSelectedPrice) {
        resultPage.selectPriceFilter(customerSelectedPrice);
    }

    @Then("^User should see all product with min price \"([^\"]*)\" and max price \"([^\"]*)\"$")
    public void user_should_see_all_product_with_min_price_and_max_price(double min, double max) {
        List<Double> actualPriceList = resultPage.selectedProducts();
        assertThat(actualPriceList, Matchers.everyItem(Matchers.greaterThanOrEqualTo(min)));
        assertThat(actualPriceList, Matchers.everyItem(Matchers.lessThanOrEqualTo(max)));
    }


    // these step defination will help in selecting category Filter from result page

    @When("^User select a filter category \"([^\"]*)\" on result page products$")
    public void user_select_a_filter_category_on_result_page_products(String customerSelectedCategory) {
        String actualCategory = resultPage.selectACategoryOfProduct(customerSelectedCategory);
        System.out.println(actualCategory);
    }

    @Then("^User should see all products according to the \"([^\"]*)\" selected category$")
    public void user_should_see_all_products_according_to_the_selected_category(String arg1) {
        assertThat(resultPage.searchrdCategories, Matchers.equalToIgnoringCase(arg1));
        System.out.println("Your actual product is equal to actual");
    }

// these step definations will help to select product according to the rating of the products

    @When("^User select a rating \"([^\"]*)\" on result page product$")
    public void user_select_a_rating_on_result_page_product(String customerSelectedRating) {
        resultPage.selectARating(customerSelectedRating);
    }

    @Then("^User should see all products according \"([^\"]*)\" to the selected rating$")
    public void user_should_see_all_products_according_to_the_selected_rating(double rating) {
        List<Double> actualRating = resultPage.getRatingOfProducts();
        // System.out.println(actualRating);
        assertThat(actualRating, Matchers.everyItem(Matchers.greaterThanOrEqualTo(rating)));
    }

    @When("^User select sort By \"([^\"]*)\" on resultPage$")
    public void user_select_sort_By_on_resultPage(String customerSelectedSorting) {
        resultPage.selectSorting(customerSelectedSorting);
    }

    @Then("^User should see all products according to the selected preference$")
    public void user_should_see_all_products_according_to_the_selected_preference() {
        List<Double> actualSortingProducts = resultPage.selectedProducts();
        boolean sortedAscendingList = Ordering.natural().isOrdered(actualSortingProducts);
        //boolean sortedDescendingList = Ordering.natural().reverse().isOrdered(actualSortingProducts);
        assertThat("Price is  sorted. ", sortedAscendingList, is(equalTo(true)));

    }
}
