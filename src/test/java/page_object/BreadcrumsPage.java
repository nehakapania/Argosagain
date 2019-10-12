package page_object;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BreadcrumsPage extends DriverManager {
    public static String productHeaderName;
    @FindBy(css = "._2BHWw")
    private List<WebElement> breadcrums;

    public void clickOnAnyBreadcrums(String customerSelection) {
        for (WebElement breadCrum : breadcrums) {
            if (breadCrum.getText().equalsIgnoreCase(customerSelection)) {
                breadCrum.click();
            }
        }
    }

    @FindBy(css = "._2Dr6a ._2eUXm ")
    private List<WebElement> shopItems;

    public void moveToShopList(String customerChoiceSelection) {
        for (WebElement shopItem : shopItems)
        {
            if(shopItem.getText().equalsIgnoreCase(customerChoiceSelection))
            {
                Actions action=new Actions(driver);
                action.moveToElement(shopItem).build().perform();
                break;
            }
        }
    }
   @FindBy(css="._39ydj")
    private List<WebElement> extendedListOfItems;
    public void clickOnProduct(String customerSelectedList)
    {
        for(WebElement extendedListOfItem:extendedListOfItems)
        {
            if(extendedListOfItem.getText().equalsIgnoreCase(customerSelectedList))
            {
                extendedListOfItem.click();
                break;
            }
        }
    }
    @FindBy(css=".search-title__term")
    private WebElement productHeader;
    public String headerOfProduct()
    {
       productHeaderName= productHeader.getText();
       return productHeaderName;
    }
}
