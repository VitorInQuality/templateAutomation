package pages;

import org.openqa.selenium.By;

import metodos.Metodos;

public class HomePage {

	Metodos metodo = new Metodos();
	private By btnLogin = By.xpath("//button[@class='login-button']");
	private By btnAbrirConta = By.xpath("//button[@class='open-account-button']");

	public void acessarMenu(String menu) {
		if (menu.equalsIgnoreCase("Login")) {
			metodo.clicar(btnLogin);
		} else if (menu.equalsIgnoreCase("Abrir conta")) {
			metodo.clicar(btnAbrirConta);
		} else {
			System.out.println("Informar o menju Login ou Abrir conta");
		}
	}

}
