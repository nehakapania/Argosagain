import cucumber.api.CucumberOptions;
        import cucumber.api.junit.Cucumber;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", dryRun = false,tags = "@Breadcrum")
//,plugin={"json:target/cucumber.json","pretty",
 //"html:target/cucumber-html-report"})
public class Runner {


}
