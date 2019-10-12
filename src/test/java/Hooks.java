import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverManager;

public class Hooks {
    //creating object od driverManager class
    DriverManager driverManager = new DriverManager();

    //this before class will run before any test
    @Before
    public void setUp() {
        driverManager.browserChoice("Chrome");
        driverManager.url("https://www.argos.co.uk/"); //passing URL
        driverManager.maximizeWindow();
        driverManager.implicitWait();
        driverManager.deleteCookies();
    }

//    @After
//    public void tearDown()
//    {
//        driverManager.driverShut();
//    }
}
