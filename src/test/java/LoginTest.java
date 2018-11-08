import cucumber.api.CucumberOptions;
import ru.aplana.demo.CucumberTest;

/**
 * Created by mbaykova on 08.11.2018
 */

@CucumberOptions(features = {"classpath:features"},
        glue = {"ru.aplana.demo"}, plugin = {"pretty"}
        )
public class LoginTest extends CucumberTest {

}
