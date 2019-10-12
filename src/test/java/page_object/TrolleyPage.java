package page_object;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TrolleyPage  extends DriverManager {

    public static String trolleyMessage;
    public static String trolley;
    //In this method the trolley product will finally reach to trolley by selecting go to trolley button
    @FindBy(linkText = "Go to Trolley")
    private WebElement goTrolley;

    public void goToTrolley() {
        goTrolley.click();
    }

    // This method will collect all the products from trolley page and get text of all products and store in a string Array

    // @FindBy(css = ".ProductCard__wrapper__1VrMF .ProductCard__titleLink__1PgaZ")
    @FindBy(css = ".ProductCard__titleLink__1ld2o")
    private List<WebElement> trolleyProducts;

    public List<String> productsAddedInTrolley() {
        List<String> trolleyProductName = new ArrayList<>();
        for (WebElement trolleyProduct : trolleyProducts) {
            String productInTrolley = trolleyProduct.getText();
            trolleyProductName.add(productInTrolley);
        }
        return trolleyProductName;
    }


    //This method will increase the quantity of products in trolley
    @FindBy(css = ".ProductCard__quantitySelect__2y1R3")
    //@FindBy(css=".ProductCard__quantityAndRemoveContainer__2ouCo .ProductCard__quantitySelect__1QV4n")
    private WebElement increaseQuatity;

    public void increaseProductQuantity(int customerSelectedQuantity) {
        increaseQuatity.click();
        Select select = new Select(increaseQuatity);
        sleep(3000);
        select.selectByIndex(customerSelectedQuantity);
    }


    @FindBy(css = ".ac-product-name")
    private List<WebElement> basketproducts;

    public List<String> addToBasketProduct() {
        List<String> collectedName = new ArrayList<>();
        for (WebElement basketProduct : basketproducts) {
            String basketAddedProduct = basketProduct.getText();
            System.out.println(basketAddedProduct);
            collectedName.add(basketAddedProduct);
        }
        return collectedName;
    }

    //This method will help to remove product from basket
    @FindBy(css = ".ProductCard__removeButton__2O6Cw")
    private WebElement removeButton;

    public void removeProductFromTrolley() {
        removeButton.click();
    }

    //With this method we can assert that trolley is empty after removing product from trolley
    @FindBy(css = ".EmptyBasketPanel__title__2L-Wf")
    private WebElement emptyTrolley;

    public String trolleyIsEmpty() {
        trolleyMessage = emptyTrolley.getText();
        return trolleyMessage;
    }

    // With this method we can bring the product back to the trolley
    @FindBy(css = ".ProductCard__undoButton__2jMy1")
    private WebElement undoButton;

    public void undoProductToTrolley() {
        undoButton.click();
    }

@FindBy(css=".Title__title__34rH4")
    private WebElement trolleyHeader;
    public String trolleyHeaderName()
    {
       trolley= trolleyHeader.getText();
       return trolley;
    }


}