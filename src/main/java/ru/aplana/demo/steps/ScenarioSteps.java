package ru.aplana.demo.steps;

import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static ru.aplana.demo.steps.BaseSteps.getDriver;

/**
 * Created by Maria on 05.11.2018.
 */
public class ScenarioSteps {

	@When("выполнен переход на страницу \"(.*)\"")
	public void stepGoToMainPage(String url){
		getDriver().get(url);
	}

	@When("открыто приложение РЖД")
	public void stepOpenRZD(String url){
		getDriver().get(url);
	}

	@When("поле \"(.*)\" заполняется значением \"(.*)\"")
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

	@When("выполнено нажатие на кнопку Найти")
	public void stepClickSearch(){
		getDriver().findElement(By.xpath("(//button[text()='Найти'])[1]")).click();
	}

	@When("выполнено нажатие на кнопку Продолжить")
	public void stepClickGo(){
		getDriver().findElement(By.xpath(".//*[@text='Продолжить']")).click();
	}

	@When("выполнено нажатие на кнопку Принимаю")
	public void stepClickAccept(){
		getDriver().findElement(By.xpath(".//*[@text='Принимаю']")).click();
	}

	@When("выполнено нажатие на кнопку Пропустить")
	public void stepClickCancel(){
		getDriver().findElement(By.xpath(".//*[@text='Пропустить']")).click();
	}

	@When("выполнено нажатие на кнопку Войти")
	public void stepClickEnter(){
		getDriver().findElement(By.xpath(".//*[@text='Войти']")).click();
	}

	@When("значение поля \"(.*)\" равно \"(.*)\"")
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
