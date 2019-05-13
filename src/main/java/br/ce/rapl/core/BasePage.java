package br.ce.rapl.core;

public class BasePage {

	protected DSL dsl;
	
	public BasePage() {
		dsl = new DSL();	// forma implícita de declaração, pois as classe filhas terão acesso a essa instância
	}
	
}
