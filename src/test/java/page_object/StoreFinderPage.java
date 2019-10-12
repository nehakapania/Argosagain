package page_object;

        import driver.DriverManager;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

        import java.util.ArrayList;
        import java.util.List;

public class StoreFinderPage extends DriverManager {
    public static String storeName;

    @FindBy(linkText = "Stores")
    private WebElement storeFinder;

    public void findAStore() {
        storeFinder.click();
    }

    @FindBy(css="#searchbox")
    private WebElement storeSearchFinderBox;
    public  void findStoreInSearch(String customerSelectedStore)
    {
        storeName=customerSelectedStore;
        storeSearchFinderBox.sendKeys(customerSelectedStore);
    }

    @FindBy(css = ".sc-search-bar-btn.btn.btn-block")
    private WebElement magnifierGlass;
    public void clickOnMagnifier()
    {
        magnifierGlass.click();
    }
    @FindBy(css=".sc-store-name")
    private List<WebElement> storeNames;
    public List<String> collectStoreName()
    {
        List<String>collectedStoreNames=new ArrayList<>();
        for(WebElement storeName:storeNames)
        {
            String storeNameInString=storeName.getText();
            collectedStoreNames.add(storeNameInString);
        }
         return collectedStoreNames;


    }
}
