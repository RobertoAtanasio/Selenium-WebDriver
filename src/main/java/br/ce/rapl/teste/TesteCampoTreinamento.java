package br.ce.rapl.teste;
import static br.ce.rapl.core.DriverFactory.getDriver;
import static br.ce.rapl.core.DriverFactory.killDriver;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.rapl.core.DSL;

public class TesteCampoTreinamento {

//	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa(){
//		this.driver = new FirefoxDriver();
//		this.driver.manage().window().setSize(new Dimension(1200, 765));
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		this.dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		killDriver();
//		driver.quit();
	}
	
	@Test
	public void testeTextField(){
		this.dsl.escrever("elementosForm:nome", "Teste de escrita");
		Assert.assertEquals("Teste de escrita", this.dsl.obterValorCampo("elementosForm:nome"));
//		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
//		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}
	
	@Test
	public void testTextFieldDuplo(){
		dsl.escrever("elementosForm:nome", "Wagner");
		Assert.assertEquals("Wagner", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escrever("elementosForm:nome", "Aquino");
		Assert.assertEquals("Aquino", dsl.obterValorCampo("elementosForm:nome"));
	}

	@Test
	public void deveIntegarirComTextArea(){
		this.dsl.escrever("elementosForm:sugestoes", "teste\n\naasldjdlks\nUltima linha");
		Assert.assertEquals("teste\n\naasldjdlks\nUltima linha", this.dsl.obterValorCampo("elementosForm:sugestoes"));
//		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\n\naasldjdlks\nUltima linha");
//		Assert.assertEquals("teste\n\naasldjdlks\nUltima linha", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}
	
	@Test
	public void deveIntegarirComRadioButton(){
		this.dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(this.dsl.isRadioMarcado("elementosForm:sexo:0"));
//		driver.findElement(By.id("elementosForm:sexo:0")).click();
//		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
	}
	
	@Test
	public void deveIntegarirComCheckbox(){
		getDriver().findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(getDriver().findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	}
	
	@Test
	public void deveIntegarirComCombo(){
//		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
//		Select combo = new Select(element);
////		combo.selectByIndex(2);				// terceiro elemento
////		combo.selectByValue("superior");
//		combo.selectByVisibleText("2o grau completo");
//		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		
		this.dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertEquals("2o grau completo", this.dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	
	@Test
	public void deveVerificarValoresCombo(){
		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
//		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
//		Select combo = new Select(element);
//		List<WebElement> options = combo.getOptions();
//		Assert.assertEquals(8, options.size());		// checando o tamanho do combo
//		
//		boolean encontrou = false;		// verificar se encontrou um determindado elemento
//		for(WebElement option: options) {
//			if(option.getText().equals("Mestrado")){
//				encontrou = true;
//				break;
//			}
//		}
//		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo(){
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

//		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
//		Select combo = new Select(element);
//		combo.selectByVisibleText("Natacao");
//		combo.selectByVisibleText("Corrida");
//		combo.selectByVisibleText("O que eh esporte?");
		
		List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(3, opcoesMarcadas.size());
//		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
//		Assert.assertEquals(3, allSelectedOptions.size());
		
		dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
		opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(2, opcoesMarcadas.size());
		Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
//		combo.deselectByVisibleText("Corrida");
//		allSelectedOptions = combo.getAllSelectedOptions();
//		Assert.assertEquals(2, allSelectedOptions.size());
		
		Assert.assertFalse(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Corrida"));
//		List<WebElement> listaOptions = combo.getAllSelectedOptions();
//		boolean encontrou = false;		// verificar se encontrou um determindado elemento
//		for(WebElement option: listaOptions) {
//			if(option.getText().equals("Corrida")){
//				encontrou = true;
//				break;
//			}
//		}
//		Assert.assertTrue(!encontrou);
	}
	
	@Test
	public void deveinteragirComBotoes(){
		this.dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", this.dsl.obterValueElemento("buttonSimple"));
//		WebElement botao = driver.findElement(By.id("buttonSimple"));
//		botao.click();
//		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
//	@Ignore			// informa ao JUnit para não executar esse teste
	public void deveinteragirComLinks(){
		this.dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", this.dsl.obterTexto("resultado"));
//		driver.findElement(By.linkText("Voltar")).click();
//		Assert.fail();		// serve para provocar uma falha proposital no teste
//		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}
	
	@Test
	public void deveBuscarTextosNaPagina(){		
//		System.out.println(driver.findElement(By.tagName("body")).getText());
		
//		Assert.assertTrue(driver.findElement(By.tagName("body"))
//				.getText().contains("Campo de Treinamento"));
		
//		Assert.assertEquals("Campo de Treinamento", 
//				driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		
//		Assert.assertEquals("Campo de Treinamento", 
//				driver.findElement(By.tagName("span")).getText());	// O By.tagName retorna o primeiro elemento que encontrar
//																	// logo, não é a melhor forma de acesso
//		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
//				driver.findElement(By.className("facilAchar")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
	}
	
	@Test
	public void testJavascript(){
		
//		this.dsl.executarJS("alert('Testando js via selenium')");
		this.dsl.executarJS("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
		this.dsl.executarJS("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		
		WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
		this.dsl.executarJS("arguments[0].style.border = arguments[1]", element, "solid 4px red");
		
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
////		js.executeScript("alert('Testando js via selenium')");
//		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
//		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
//		
//		WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
//		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}
	
	@Test
	public void deveClicarBotaoTabela(){
//		dsl.clicarBotaoTabela("Escolaridade", "Mestrado", "Radio");
//		dsl.clicarBotaoTabela("Nome", "Usuario B", "Checkbox");
		dsl.clicarBotaoTabela("Nome", "Maria", "Botao");
	}
}
