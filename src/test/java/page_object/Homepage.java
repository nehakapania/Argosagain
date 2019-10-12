package page_object;

import driver.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends DriverManager {
    public static String searchedItem; //creating a string variable to store the item which we r searching

    //Given locator by using PageFactory
    @FindBy(css = "#searchTerm")
    private WebElement searchBox;

    public void doSearch(String item) {
        searchedItem = item;
        searchBox.sendKeys(item + Keys.ENTER);
    }

    //Method to get currentUrl for assertion
    public String currentUrl() {
        return driver.getCurrentUrl();   //this method will return current url in string
    }

}
