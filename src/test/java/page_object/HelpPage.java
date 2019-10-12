package page_object;

import driver.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends DriverManager {
    public static String helpHeaderName;
    public String searchedTitleHeader;

    // With this method we can click on help icon of homePage
    @FindBy(linkText = "Help")
    private WebElement helpIcon;

    public void getHelp() {
        helpIcon.click();
    }

    // With this method we can assertion the help page appears
    @FindBy(css = ".h1.title")
    private WebElement helpHeader;

    public String getHelpHeader() {
        helpHeaderName=helpHeader.getText();
        return helpHeaderName;
    }

    // this method will enter a question asked by user to search help box\
    @FindBy(css = ".ac-search-bar__input--icon.form-control")
    private WebElement askAQuestionSearchBox;
    public void askAQuestion(String customerAskedQuestion)
    {
        askAQuestionSearchBox.sendKeys(customerAskedQuestion+Keys.ENTER);
    }
    // this method helps in assertion that the result page shows results for asked questions
    @FindBy(css=".page__title--search")
    private WebElement searchedQuestion;
    public String searchedTitle()
    {
        searchedTitleHeader=searchedQuestion.getText();
        return searchedTitleHeader;
    }
}
