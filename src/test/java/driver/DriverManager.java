package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;     // initialized WebDriver

    //Initialized page factory for using locators as
    public DriverManager() {
        PageFactory.initElements(driver, this);
    }

    //Made a switch statement to initialized the choice of browser
    public void browserChoice(String browser) {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();    // using webdriver manager to initialize chromedriver instead of installing driver
                driver = new ChromeDriver();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
    }

    public void url(String url) {
        driver.get(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void privacyfooter() {
        driver.findElement(By.cssSelector(".privacy-prompt-footer")).click();
    }

    public void driverShut()
    {
        driver.quit();
    }

    public void waitUntilWebElementIsDisappeared(WebElement element) //WebdriverWait
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeSelected(element));
    }


    public void sleep(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public int selectProductByRandomGenerator(int size)
    {
        Random random=new Random();
       return random.nextInt(size-1);
    }
}
