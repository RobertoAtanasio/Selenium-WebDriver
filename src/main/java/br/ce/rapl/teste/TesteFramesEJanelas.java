package br.ce.rapl.teste;
import static br.ce.rapl.core.DriverFactory.getDriver;
import static br.ce.rapl.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.rapl.core.DSL;

public class TesteFramesEJanelas {

//	private WebDriver driver;
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
	public void deveInteragirComFrames() {
		dsl.entrarFrame("frame1");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);

		dsl.sairFrame();
		dsl.escrever("elementosForm:nome", msg);
		
//		driver.switchTo().frame("frame1");		// para o selenium mudar o foco para o frame
//		driver.findElement(By.id("frameButton")).click();
//		Alert alert = driver.switchTo().alert();
//		String msg = alert.getText();
//		Assert.assertEquals("Frame OK!", msg);
//		alert.accept();
//
//		driver.switchTo().defaultContent();	// para o selnium voltar o foco para a página principal
//		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
	}
	
	@Test
	public void deveInteragirComFrameEscondido(){
		WebElement frame = getDriver().findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
	}

	@Test
	public void deveInteragirComJanelas(){
		dsl.clicarBotao("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		getDriver().close();
		dsl.trocarJanela("");
		dsl.escrever(By.tagName("textarea"), "e agora?");
		
//		driver.findElement(By.id("buttonPopUpEasy")).click();
//		driver.switchTo().window("Popup");	// Popoup é o identificador da janela (ver no script da chamada do botão
//		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");	// está se usando o By.tagName("textarea") porque é
//																			// o único da página
//		driver.close();		// o driver .quir fecha TODAS as janelas que o firefoz está gerenciando
//		driver.switchTo().window("");
//		driver.findElement(By.tagName("textarea")).sendKeys("e agora?");	// está se usando o By.tagName("textarea") porque é
//																			// o único da página
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo(){
		dsl.clicarBotao("buttonPopUpHard");
		System.out.println(getDriver().getWindowHandle());
		System.out.println(getDriver().getWindowHandles());
		dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[1]);
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[0]);
		dsl.escrever(By.tagName("textarea"), "e agora?");
		
//		driver.findElement(By.id("buttonPopUpHard")).click();
//		System.out.println(driver.getWindowHandle());	// janela corrente, no caso a principal, pois o foco ainda está nela
//		System.out.println(driver.getWindowHandles());	// coleção de todas as janelas que o window está gerenciando
//		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);	// mudar o foco para a popup
//																			// como o .window exige uma string é feito um cast
//		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");	// está se usando o By.tagName("textarea") porque é
//																			// o único da página
//		driver.close();	// se não executar, o popup ficará aberto
//		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
//		driver.findElement(By.tagName("textarea")).sendKeys("E agora?");	// está se usando o By.tagName("textarea") porque é
//																			// o único da página
	}
}
