package page_object;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverManager {

    @FindBy(css="#email-address")
    private WebElement emailAdd;
    public void emaillogin(String email)
    {
        emailAdd.sendKeys(email);
    }


    @FindBy(css="#current-password")
    private WebElement passwords;
    public void passwordlogin(String password)
    {
        passwords.sendKeys(password);
    }

    @FindBy(css=".button")
    private WebElement signIn;
    public void SignInSecurely()
    {
        sleep(4000);
        signIn.click();
    }
}
