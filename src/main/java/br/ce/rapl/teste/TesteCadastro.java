package br.ce.rapl.teste;
import static br.ce.rapl.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.rapl.core.BaseTest;
import br.ce.rapl.page.CampoTreinamentoPage;

public class TesteCadastro extends BaseTest {

//	private WebDriver driver;
//	private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
//		this.driver = new FirefoxDriver();
//		this.driver.manage().window().setSize(new Dimension(1200, 765));
//		driver = DriverFactory.getDriver();
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		this.page = new CampoTreinamentoPage();
		
//		this.driver = new FirefoxDriver();
//		this.driver.manage().window().setSize(new Dimension(1200, 765));
//		this.driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		this.dsl = new DSL(this.driver);
//		this.page = new CampoTreinamentoPage(this.driver);
	}
	
//	@After
//	public void finaliza(){
//		killDriver();
////		driver.quit();
//	}
	
	@Test
	public void deveRealizarCadastroComSucesso(){
		
		page.setNome("Wagner");
		page.setSobrenome("Costa");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.cadastrar();
		
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Wagner", page.obterNomeCadastro());
		Assert.assertEquals("Costa", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Pizza", page.obterComidaCadastro());
		Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Natacao", page.obterEsportesCadastro());
		
//		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
//		Assert.assertTrue(page.obterNomeCadastro().endsWith("Wagner"));
//		Assert.assertEquals("Sobrenome: Costa", page.obterSobrenomeCadastro());
//		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
//		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
//		Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
//		Assert.assertEquals("Esportes: Natacao", page.obterEsportesCadastro());
		
//		this.dsl.escrever("elementosForm:nome", "Wagner");
//		this.dsl.escrever("elementosForm:sobrenome", "Costa");
//		this.dsl.clicarBotao("elementosForm:sexo:0");
//		this.dsl.clicarBotao("elementosForm:comidaFavorita:2");
//		
////		driver.findElement(By.id("elementosForm:nome")).sendKeys("Wagner");
////		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Costa");
////		driver.findElement(By.id("elementosForm:sexo:0")).click();
////		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
//		
////		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
////		Select combo = new Select(element);
////		combo.selectByVisibleText("Mestrado");
//		
//		this.dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
//		this.dsl.selecionarCombo("elementosForm:esportes", "Natacao");
////		new Select(driver.findElement(By.id("elementosForm:escolaridade")))
////			.selectByVisibleText("Mestrado");
//		
////		new Select(driver.findElement(By.id("elementosForm:esportes")))
////			.selectByVisibleText("Natacao");
//		
//		this.dsl.clicarBotao("elementosForm:cadastrar");
////		driver.findElement(By.id("elementosForm:cadastrar")).click();
//
//		Assert.assertTrue(this.dsl.obterTexto("resultado").startsWith("Cadastrado!"));
//		Assert.assertTrue(this.dsl.obterTexto("descNome").endsWith("Wagner"));
//		Assert.assertEquals("Sobrenome: Costa", this.dsl.obterTexto("descSobrenome"));
//		Assert.assertEquals("Sexo: Masculino", this.dsl.obterTexto("descSexo"));
//		Assert.assertEquals("Comida: Pizza", this.dsl.obterTexto("descComida"));
//		Assert.assertEquals("Escolaridade: mestrado", this.dsl.obterTexto("descEscolaridade"));
//		Assert.assertEquals("Esportes: Natacao", this.dsl.obterTexto("descEsportes"));
//		
////		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
////		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Wagner"));
////		Assert.assertEquals("Sobrenome: Costa", driver.findElement(By.id("descSobrenome")).getText());
////		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
////		Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
////		Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText());
////		Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());
	}
	
	
	
//========== Todos os testes abaixo foram transferidos para a classe TesteRegrasCadastro. Portanto, não é
//			 mais necessário ser feito aqui.
	
//	
//	@Test
//	public void deveValidarNomeObrigatorio() {
//		page.cadastrar();
//		Assert.assertEquals("Nome eh obrigatorio", page.obterTextoAlertaEAceita());
//		
////		dsl.clicarBotao("elementosForm:cadastrar");
////		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
//////		driver.findElement(By.id("elementosForm:cadastrar")).click();
//////		Alert alert = driver.switchTo().alert();
//////		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
//	}
//	
//	@Test
//	public void deveValidarSobrenomeObrigatorio() {
//		page.setNome("Nome qualquer");
//		page.cadastrar();
//		Assert.assertEquals("Sobrenome eh obrigatorio", page.obterTextoAlertaEAceita());
////		// obs.: para se chegar ao erro do sorenome, deve-se preencher o nome primeiramente, e assim para os demais métodos abaixo
////		dsl.escrever("elementosForm:nome", "Nome qualquer");
////		dsl.clicarBotao("elementosForm:cadastrar");
////		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
//////		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
//////		driver.findElement(By.id("elementosForm:cadastrar")).click();
//////		Alert alert = driver.switchTo().alert();
//////		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
//	}
//	
//	@Test
//	public void deveValidarSexoObrigatorio() {
//		page.setNome("Nome qualquer");
//		page.setSobrenome("Sobrenome qualquer");
//		page.cadastrar();
//		Assert.assertEquals("Sexo eh obrigatorio", page.obterTextoAlertaEAceita());
////		dsl.escrever("elementosForm:nome", "Nome qualquer");
////		dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
////		dsl.clicarBotao("elementosForm:cadastrar");
////		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
//////		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
//////		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
//////		driver.findElement(By.id("elementosForm:cadastrar")).click();
//////		Alert alert = driver.switchTo().alert();
//////		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
//	}
//	
//	@Test
//	public void deveValidarComidaVegetariana(){	
//		page.setNome("Nome qualquer");
//		page.setSobrenome("Sobrenome qualquer");
//		page.setSexoFeminino();
//		page.setComidaCarne();
//		page.setComidaVegetariano();
//		page.cadastrar();
//		Assert.assertEquals("Tem certeza que voce eh vegetariano?", page.obterTextoAlertaEAceita());
////		dsl.escrever("elementosForm:nome", "Nome qualquer");
////		dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
////		dsl.clicarRadio("elementosForm:sexo:1");
////		dsl.clicarRadio("elementosForm:comidaFavorita:0");
////		dsl.clicarRadio("elementosForm:comidaFavorita:3");
////		dsl.clicarBotao("elementosForm:cadastrar");
////		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
//////		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
//////		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
//////		driver.findElement(By.id("elementosForm:sexo:1")).click();
//////		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
//////		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
//////		driver.findElement(By.id("elementosForm:cadastrar")).click();
//////		Alert alert = driver.switchTo().alert();
//////		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
//	}
//	
//	@Test
//	public void deveValidarEsportistaIndeciso(){
//		page.setNome("Nome qualquer");
//		page.setSobrenome("Sobrenome qualquer");
//		page.setSexoFeminino();
//		page.setComidaCarne();
//		page.setEsporte("Karate", "O que eh esporte?");
//		page.cadastrar();
//		Assert.assertEquals("Voce faz esporte ou nao?", page.obterTextoAlertaEAceita());
////		dsl.escrever("elementosForm:nome", "Nome qualquer");
////		dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
////		dsl.clicarRadio("elementosForm:sexo:1");
////		dsl.clicarRadio("elementosForm:comidaFavorita:0");
////		dsl.selecionarCombo("elementosForm:esportes", "Karate");
////		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
////		dsl.clicarBotao("elementosForm:cadastrar");
////		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
//////		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
//////		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
//////		driver.findElement(By.id("elementosForm:sexo:1")).click();
//////		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
//////		Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
//////		combo.selectByVisibleText("Karate");
//////		combo.selectByVisibleText("O que eh esporte?");
//////		driver.findElement(By.id("elementosForm:cadastrar")).click();
//////		Alert alert = driver.switchTo().alert();
//////		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
//	}
	
}
