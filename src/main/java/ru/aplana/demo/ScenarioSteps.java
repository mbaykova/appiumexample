package ru.aplana.demo;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import static ru.aplana.demo.BaseSteps.getDriver;

/**
 * Created by Maria on 05.11.2018.
 */
public class ScenarioSteps {

	@Step
	public void stepGoToMainPage(String url){
		getDriver().get(url);
	}

	@Step
	public void stepOpenRZD(String url){
		getDriver().get(url);
	}

	@Step
	public void stepFillField(String field, String value){
		switch (field){
			case "Найти":
				getDriver().findElement(By.xpath("(//input[@name='text'])[1]")).sendKeys(value);
				break;
			case "Логин":
				getDriver().findElement(By.xpath(".//*[contains(@resource-id,'login')]")).sendKeys(value);
				break;
			case "Пароль":
				getDriver().findElement(By.xpath(".//*[contains(@resource-id,'password')]")).sendKeys(value);
				getDriver().hideKeyboard();
				break;
		}
	}

	@Step
	public void stepClickSearch(){
		getDriver().findElement(By.xpath("(//button[text()='Найти'])[1]")).click();
	}

	@Step
	public void stepClickGo(){
		getDriver().findElement(By.xpath(".//*[@text='Продолжить']")).click();
	}

	@Step
	public void stepSelectLanguage(){
		getDriver().findElement(By.xpath(".//*[@text='Русский']")).click();
	}

	@Step
	public void stepClickAccept(){
		getDriver().findElement(By.xpath(".//*[@text='Принимаю']")).click();
	}

	@Step
	public void stepClickCancel(){
		getDriver().findElement(By.xpath(".//*[@text='Пропустить']")).click();
	}

	@Step
	public void stepClickEnter(){
		getDriver().findElement(By.xpath(".//*[@text='Войти']")).click();
	}

	@Step
	public void stepCheckFillField(String field, String value){
		switch (field){
			case "Результат поиска":
				Assert.assertTrue(getDriver().findElement(By.xpath(".//a[contains(@class,'link_')]")).getText()
					.contains(value));
				break;
			case "Заголовок":
				Assert.assertEquals(value,
					getDriver().findElement(By.xpath(".//*[@class='android.widget.TextView']")).getText());
				break;
		}
	}
}
