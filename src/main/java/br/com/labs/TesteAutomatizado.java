package br.com.labs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","/home/felipeas/Documentos/geckodriver-v0.28.0-linux64/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com.br");
		
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("Caelum");
		
		campoDeTexto.submit();
		
	}

}
