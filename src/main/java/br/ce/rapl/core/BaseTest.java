package br.ce.rapl.core;

import static br.ce.rapl.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(arquivo, new File("screenshot.jpg"));
//		FileUtils.copyFile(arquivo, new File(testName.getMethodName() + ".jpg"));
//		System.out.println("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg");
		// obs.: deve-se usar File.separator no lugar da /, pois cada sistema operacional tem uma forma
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + 
				File.separator + testName.getMethodName() + ".jpg"));

		if(Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}
	}
	
}
