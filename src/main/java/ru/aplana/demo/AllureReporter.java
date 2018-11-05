package ru.aplana.demo;

import gherkin.formatter.model.Result;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import static ru.aplana.demo.steps.BaseSteps.getDriver;

/**
 * Created by Maria on 05.11.2018.
 */
public class AllureReporter extends io.qameta.allure.cucumberjvm.AllureCucumberJvm {


	@Override
	public void result(Result result) {
		if (!result.getStatus().equals("passed") && !result.getStatus().equals("skipped")) {
			takeScreenshot();
		}
		super.result(result);
	}

	@Attachment(type = "image/png", value = "Скриншот в момент ошибки")
	public static byte[] takeScreenshot() {
		return getDriver().getScreenshotAs(OutputType.BYTES);
	}


}
