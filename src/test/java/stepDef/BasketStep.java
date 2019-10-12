package stepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import page_object.BasketPage;
import page_object.TrolleyPage;



import static org.hamcrest.MatcherAssert.assertThat;

public class BasketStep {

    private BasketPage basketPage=new BasketPage();
    private TrolleyPage trolleyPage=new TrolleyPage();


    @When("^User select any product from resultPage$")
    public void user_select_any_product_from_resultPage()  {
       String actualProductSelected= basketPage.selectAProductByRandomGeneratorMethod();
      System.out.println(actualProductSelected);
    }

    @When("^User add product to the basket$")
    public void user_add_product_to_the_basket()  {
        basketPage.addToTrolley();
    }

    @Then("^User should see product been added to the basket$")
    public void user_should_see_product_been_added_to_the_basket()
    {
        String actualProductInBasket=basketPage.productAddedToBasket();
        System.out.println(actualProductInBasket);
        assertThat(actualProductInBasket,Matchers.equalToIgnoringCase(basketPage.productToBasket));
        System.out.println("Expected equals Actual");
    }

}
