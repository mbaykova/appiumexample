package ru.aplana.demo;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import static ru.aplana.demo.CucumberTest.driver;

/**
 * Created by Maria on 05.11.2018.
 */
public class ScenarioSteps {

	@When("выполнен переход на страницу \"(.*)\"")
	public void stepGoToMainPage(String url){
		driver.get(url);
	}

	@When("открыто приложение РЖД")
	public void stepOpenRZD(String url){
		driver.get(url);
	}

	@When("поле \"(.*)\" заполняется значением \"(.*)\"")
	public void stepFillField(String field, String value){
		switch (field){
			case "Найти":
				driver.findElement(By.xpath("(//input[@name='text'])[1]")).sendKeys(value);
				break;
			case "Логин":
				driver.findElement(By.xpath(".//*[contains(@resource-id,'login')]")).sendKeys(value);
				break;
			case "Пароль":
				driver.findElement(By.xpath(".//*[contains(@resource-id,'password')]")).sendKeys(value);
				driver.hideKeyboard();
				break;
		}
	}

	@When("выполнено нажатие на кнопку Найти")
	public void stepClickSearch(){
		driver.findElement(By.xpath("(//button[text()='Найти'])[1]")).click();
	}

	@When("выполнено нажатие на кнопку Продолжить")
	public void stepClickGo(){
		driver.findElement(By.xpath(".//*[@text='Продолжить']")).click();
	}

	@When("выполнено нажатие на кнопку Принимаю")
	public void stepClickAccept(){
		driver.findElement(By.xpath(".//*[@text='Принимаю']")).click();
	}

	@When("выполнено нажатие на кнопку Пропустить")
	public void stepClickCancel(){
		driver.findElement(By.xpath(".//*[@text='Пропустить']")).click();
	}

	@When("выполнено нажатие на кнопку Войти")
	public void stepClickEnter(){
		driver.findElement(By.xpath(".//*[@text='Войти']")).click();
	}

	@When("значение поля \"(.*)\" равно \"(.*)\"")
	public void stepCheckFillField(String field, String value){
		switch (field){
			case "Результат поиска":
				Assert.assertTrue(driver.findElement(By.xpath(".//a[contains(@class,'link_')]")).getText()
					.contains(value));
				break;
			case "Заголовок":
				Assert.assertEquals(value,
					driver.findElement(By.xpath(".//*[@class='android.widget.TextView']")).getText());
				break;
		}
	}
}
