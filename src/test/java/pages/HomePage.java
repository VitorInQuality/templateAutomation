package pages;

import org.openqa.selenium.By;

import metodos.Metodos;

public class HomePage {

	Metodos metodo = new Metodos();

	By btnHomeBroker = By.xpath("//ul//li[1]//a");
	By btnformulario = By.xpath("//ul//li[2]//a");

	public void acessarHomeBroker() {
		metodo.clicar(btnHomeBroker);

	}

	public void acessarFormulario() {
		metodo.clicar(btnformulario);

	}

}
