package br.com.labs;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuarioSistemaTest {
	
	private FirefoxDriver driver;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
	}

	@Test
	public void deveAdicionarUmUsuario() {

		System.setProperty("webdriver.gecko.driver",
				"/home/felipeas/Documentos/geckodriver-v0.28.0-linux64/geckodriver");

		driver.get("http://localhost:8080/usuarios/new");

		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));

		nome.sendKeys("Felipe Alexandre");
		email.sendKeys("felipe@felipe.com");

		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();

		boolean achouNome = driver.getPageSource().contains("Felipe Alexandre");
		boolean achouEmail = driver.getPageSource().contains("felipe@felipe.com");

		assertTrue(achouNome);

//		driver.close();
	}

	@Test
	public void naoDeveAdicionarUmUsuarioSemNome() {

		driver.get("http://localhost:8080/usuarios/new");

		WebElement email = driver.findElement(By.name("usuario.email"));

		email.sendKeys("ronaldo2009@terra.com.br");
		email.submit();

		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));

		driver.close();

	}
	
	@After
	public void finaliza() {
		driver.close();
	}
}
