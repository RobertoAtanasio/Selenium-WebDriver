package br.ce.rapl.teste;
import static br.ce.rapl.core.DriverFactory.getDriver;
import static br.ce.rapl.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.rapl.core.DSL;

public class TesteAjax {
	
//	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
//		driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));
//		driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		killDriver();
//		driver.quit();
	}

	@Test
	public void testAjax(){
		dsl.escrever("j_idt697:name", "Teste");
		dsl.clicarBotao("j_idt697:j_idt700");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
//		wait.until(ExpectedConditions.textToBe(By.id("j_idt697:display"), "Teste"));	// campo a ser preenchido
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt712_start")));	// gif da espera
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt697:display"));
	}
}
