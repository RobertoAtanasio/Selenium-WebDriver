package br.ce.rapl.core;

public class Propriedades {

	// obs.: no ambiente de teste você pode deixar para fechar o browser só no final para ganhar tempo. Mas no
	//		 ambiente de produção, essa prática não é recomendada.
	
	public static boolean FECHAR_BROWSER = false;
	
	public static Browsers browser = Browsers.FIREFOX;
	
	public enum Browsers {		
		CHROME,
		FIREFOX;
	}
	
	
//	public enum Browsers {				
//		CHROME("Chrome"),
//		FIREFOX("Firefox");
//
//		private String descricao;
//
//		Browsers(String descricao) {
//			this.descricao = descricao;
//		}
//
//		public String getDescricao() {
//			return descricao;
//		}
//	}
	
}
