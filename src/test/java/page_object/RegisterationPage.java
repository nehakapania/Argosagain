package page_object;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends DriverManager {

    @FindBy(linkText="Account")
    private WebElement accountIcon;
    public void clickOnAccountIcon()
    {
        accountIcon.click();
    }
}
