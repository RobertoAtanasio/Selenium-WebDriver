package br.ce.rapl.teste;
import static br.ce.rapl.core.DriverFactory.getDriver;
import static br.ce.rapl.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.rapl.core.DSL;

public class TesteAlert {

	private DSL dsl;
	
	@Before
	public void inicializa(){
//		driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		killDriver();
//		driver.quit();
	}
	
	@Test
	public void deveInteragirComAlertSimples(){	
		dsl.clicarBotao("alert");
		String texto = dsl.alertaObterTextoEAceita(); 
		Assert.assertEquals("Alert Simples", texto);
		dsl.escrever("elementosForm:nome", texto);
		
//		driver.findElement(By.id("alert")).click();
//		Alert alert = driver.switchTo().alert();	// para o selenium mudar o foco para alert e o driver receber 
//													// uma instância do alert
//		String texto = alert.getText();
//		Assert.assertEquals("Alert Simples", texto);
//		alert.accept();	// dá o click no alert para fechar o mesmo. Obs.: após fechar o alert, não se pode mais fazer referências
//						// ao mesmo.
//		
//		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);	// carregar texto no campo nome
//		Assert.assertEquals("Alert Simples", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComAlertConfirm(){
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
		
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
		
//		driver.findElement(By.id("confirm")).click();
//		Alert alerta = driver.switchTo().alert();
//		Assert.assertEquals("Confirm Simples", alerta.getText());
//		alerta.accept();
//		Assert.assertEquals("Confirmado", alerta.getText());
//		alerta.accept();
//		
//		driver.findElement(By.id("confirm")).click();
//		alerta = driver.switchTo().alert();
//		Assert.assertEquals("Confirm Simples", alerta.getText());
//		alerta.dismiss();
//		Assert.assertEquals("Negado", alerta.getText());
//		alerta.dismiss();	// nesse caso, como é um alert simples, pode ser .dismiss ou . accept
	}
	
	@Test
	public void deveInteragirComAlertPrompt(){
		dsl.clicarBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
		Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
		
//		driver.findElement(By.id("prompt")).click();
//		Alert alerta = driver.switchTo().alert();
//		Assert.assertEquals("Digite um numero", alerta.getText());
//		alerta.sendKeys("12");		// escrever no prompt
//		alerta.accept();
//		Assert.assertEquals("Era 12?", alerta.getText());
//		alerta.accept();
//		Assert.assertEquals(":D", alerta.getText());
//		alerta.accept();
	}
}
