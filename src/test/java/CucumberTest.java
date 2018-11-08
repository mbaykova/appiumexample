
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Baykova-MS on 16.01.2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/test.feature"},
        glue = {"ru.aplana.demo"}, plugin = {"pretty"}
)
public class CucumberTest {

}
