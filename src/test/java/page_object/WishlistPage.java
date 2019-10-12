package page_object;

        import driver.DriverManager;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

        import java.util.ArrayList;
        import java.util.List;

public class WishlistPage extends DriverManager {

    //This method will click the product to add to the wishlist
    @FindBy(linkText = "Add to Your Wishlist")
    private WebElement wishlist;

    public void addProductToWishliost() {
        wishlist.click();
    }

    //This method will click on wishlist to reach wishlist page
    @FindBy(linkText = "Wishlist")
    private WebElement wishlisticon;
    public void clickWishIcon()
    {
        wishlisticon.click();
    }

    //This method will collect all the products present in wishlist
    @FindBy(css = ".ac-product-card__name")
    private List<WebElement> wishlistProductsName;
    public List<String> productsInWishlist()
    {
        List<String> collectedWishlist=new ArrayList<>();
        for(WebElement wishListProductName: wishlistProductsName)
        {
           String productName= wishListProductName.getText();
           collectedWishlist.add(productName);
        }
        return collectedWishlist;
    }

}

