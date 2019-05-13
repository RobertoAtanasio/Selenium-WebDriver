package br.ce.rapl.teste;
import static br.ce.rapl.core.DriverFactory.getDriver;
import static br.ce.rapl.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.rapl.core.DSL;

public class TestePrine {
	
//	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
//		driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		killDriver();
//		driver.quit();
	}

	@Test
	public void deveInteragirComRadioPrime(){
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt698:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt698:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt698:console:1"));
		
	}
	
	@Test
	public void deveInteragirComSelectPrime(){
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt698:console", "Xbox One");
		Assert.assertEquals("Xbox One", dsl.obterTexto("j_idt698:console_label"));
	}
}
