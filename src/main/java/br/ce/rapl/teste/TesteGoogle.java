package br.ce.rapl.teste;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TesteGoogle {

	private WebDriver driver;

	@Before
	public void inicializa(){
		driver.manage().window().setSize(new Dimension(1200, 765));
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}
	
	@Test
	public void testeFireFox() {
//		System.setProperty("webdriver.gecko.driver", "/SeleniumDriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");		
		Assert.assertEquals("Google", driver.getTitle());
	}

	@Test
	public void testeChrome() {
//		System.setProperty("webdriver.chrome.driver", "/SeleniumDriver/chromedriver.exe");
		driver = new ChromeDriver();
//		driver.manage().window().setPosition(new Point(100, 100));
//		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
	}
	
	@Test
	public void testeInternetExplorer() {
//		System.setProperty("webdriver.internetexplorer.driver", "/SeleniumDriver/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
//		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
	}
}
