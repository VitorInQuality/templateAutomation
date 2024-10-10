package runner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import drivers.Drivers;

public class Executa extends Drivers {

	public static void iniciarTeste() {
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://desafio.ui.e2etreinamentos.com.br/");
	}

	public static void finalizarTeste() {
		driver.quit();
	}

}
