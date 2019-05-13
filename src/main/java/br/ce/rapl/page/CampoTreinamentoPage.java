package br.ce.rapl.page;
import org.openqa.selenium.By;

import br.ce.rapl.core.BasePage;

public class CampoTreinamentoPage extends BasePage {

//	private DSL dsl;			// forma explícita de declaração
	
//	public CampoTreinamentoPage (WebDriver driver) {
//		this.dsl = new DSL(driver);
//	}
//	public CampoTreinamentoPage () {
//		this.dsl = new DSL();
//	}
	
	// obs.: a declaração da instância do sql está na classe de que herda de forma implícita.
	
	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);
	}
	
	public void setSobrenome(String sobrenome) {
		dsl.escrever("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino(){
		dsl.clicarRadio("elementosForm:sexo:0");
	}
	
	public void setSexoFeminino(){
		dsl.clicarRadio("elementosForm:sexo:1");
	}
	
	public void setComidaCarne(){
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaPizza(){
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaVegetariano(){
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}
	
	public void setEsporte(String... valores) {
		for(String valor: valores)
			dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	
	public void cadastrar(){
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='resultado']/span"));
//		return dsl.obterTexto("resultado");
	}
	
	public String obterNomeCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descNome']/span"));
//		return dsl.obterTexto("descNome");
	}
	
	public String obterSobrenomeCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descSobrenome']/span"));
//		return dsl.obterTexto("descSobrenome");
	}
	
	public String obterSexoCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descSexo']/span"));
//		return dsl.obterTexto("descSexo");
	}
	
	public String obterComidaCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descComida']/span"));
//		return dsl.obterTexto("descComida");
	}
	
	public String obterEscolaridadeCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descEscolaridade']/span"));
//		return dsl.obterTexto("descEscolaridade");
	}
	
	public String obterEsportesCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descEsportes']/span"));
//		return dsl.obterTexto("descEsportes");
	}
	
	public String obterTextoAlertaEAceita() {
		return dsl.alertaObterTextoEAceita();
	}
}
