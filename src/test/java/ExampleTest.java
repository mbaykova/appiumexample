import org.junit.Test;
import ru.aplana.demo.steps.BaseSteps;
import ru.aplana.demo.steps.ScenarioSteps;

/**
 * Created by mbaykova on 07.11.2018
 */
public class ExampleTest extends BaseSteps {

    ScenarioSteps scenarioSteps = new ScenarioSteps();

    @Test
    public void testMethod() {
        scenarioSteps.stepSelectLanguage();
        scenarioSteps.stepClickGo();
        scenarioSteps.stepClickAccept();
        scenarioSteps.stepClickCancel();
        scenarioSteps.stepFillField("Логин", "autotester");
        scenarioSteps.stepFillField("Пароль", "autotester");
        scenarioSteps.stepClickEnter();
        scenarioSteps.stepClickGo();
        scenarioSteps.stepCheckFillField("Заголовок", "РЖД Пассажирам");

    }
}
