package br.ce.rapl.suite;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.rapl.core.DriverFactory;
import br.ce.rapl.teste.TesteCadastro;
import br.ce.rapl.teste.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteRegrasCadastro.class
//	TesteCampoTreinamento.class
})
public class SuiteTeste {

	@AfterClass
	public static void finalizaTudo(){		// obs.: esse método deve ser static 
		DriverFactory.killDriver();
	}
	
}
