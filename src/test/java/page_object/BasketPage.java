package page_object;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends DriverManager {
    public static String randomSelectedProduct;
    public static String productToBasket;

    //In this method randomgenerator method will pick any product from result page and click on it
    //@FindBy(css = ".ac-product-card__name")
   //  @FindBy(css = ".ac-product-name.ac-product-card__name")
    @FindBy(css=".ProductCardstyles__Title-l8f8q8-11.kLyOND")
    private List<WebElement> randomSelection;

    public String selectAProductByRandomGeneratorMethod() {
        int listSize = randomSelection.size();
        int randomProduct = selectProductByRandomGenerator(listSize);
        randomSelectedProduct = randomSelection.get(randomProduct).getText();
        System.out.println(randomSelectedProduct);
        privacyfooter();
        sleep(7000);
        randomSelection.get(randomProduct).click();

        return randomSelectedProduct;
    }

    //In this method randomly selected product will add to the trolley
    //@FindBy(linkText = "Add to Trolley")
    @FindBy(css = ".add-to-trolley-main .Buttonstyles__Button-q93iwm-2")
    private WebElement addtrolley;

    public void addToTrolley() {
        sleep(4000);
        addtrolley.click();
    }


    //This method will assert that the same product is added to the basket

    @FindBy(css = ".TrolleyItemstyles__ItemName-xtnnb7-6.ctbjwt")
    private WebElement addToBasket;

    public String productAddedToBasket() {
        productToBasket = addToBasket.getText();
        return productToBasket;
    }


}



