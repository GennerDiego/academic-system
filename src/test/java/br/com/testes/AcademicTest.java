package br.com.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AcademicTest {

	static WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		driver = new FirefoxDriver();
		driver.navigate().to("http://localhost:8080/jsflab/");
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void openPageSystemSuccess() {
		WebElement outputNome = driver.findElement(By.id("primeForm:outputNome"));
		WebElement outputSenha = driver.findElement(By.id("primeForm:outputSenha"));
		WebElement panelLogin = driver.findElement(By.xpath("//span[text()='Login']"));
		assertEquals(outputNome.getText(), "Nome Usuario:*");
		assertEquals(outputSenha.getText(), "Senha:*");
		assertEquals(panelLogin.getText(), "Login");
	}

	@Test
	public void loginErrorMessages() {
		WebElement button = driver.findElement(By.id("primeForm:botaoConfirmar"));
		button.click();
		WebElement error = driver.findElement(By.className("ui-messages-error-summary"));
		assertNotNull(error);
	}

	@Test
	public void loginSuccess() throws InterruptedException {
		WebElement inputLogin = driver.findElement(By.id("primeForm:nomeUsuario"));
		WebElement inputSenha = driver.findElement(By.id("primeForm:senha"));
		WebElement button = driver.findElement(By.id("primeForm:botaoConfirmar"));
		inputLogin.sendKeys("gennerdiego");
		inputSenha.sendKeys("genner123");
		button.click();
		Thread.sleep(1000);
		WebElement panelBemVindo = driver.findElement(By.xpath("//span[text()='Seja Bem Vindo!!! gennerdiego']"));
		assertEquals(panelBemVindo.getText(), "Seja Bem Vindo!!! gennerdiego");
	}

	@Test
	public void changeStudentData() throws InterruptedException {
		WebElement inputLogin = driver.findElement(By.id("primeForm:nomeUsuario"));
		WebElement inputSenha = driver.findElement(By.id("primeForm:senha"));
		WebElement button = driver.findElement(By.id("primeForm:botaoConfirmar"));
		inputLogin.sendKeys("gennerdiego");
		inputSenha.sendKeys("genner123");
		button.click();
		Thread.sleep(1000);
		WebElement atualizar = driver.findElement(By.id("primeForm:btnAtualizar"));
		atualizar.click();
		Thread.sleep(1000);
		WebElement panel = driver.findElement(By.id("primeForm:btnUpdate"));
		assertEquals(panel.getText(), "Atualizar");
	}

}
