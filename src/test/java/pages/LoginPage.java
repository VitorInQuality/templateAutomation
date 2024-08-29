package pages;

import org.openqa.selenium.By;

import elementos.Elementos;
import metodos.Metodos;

public class LoginPage {
	
	Metodos metodo = new Metodos();
	Elementos el = new Elementos();
	
	private By nomePaginaLogado = By.xpath("");
	
	/**
	 * Realizar o login da conta informando os dados de acesso
	 * @param username
	 * @param senha
	 */
	public void preencherDadosLogin(String username, String senha) {
		metodo.escrever(el.usuario, username);
		metodo.escrever(el.senha, senha);
		metodo.clicar(el.btnContinuar);
		metodo.validarUrl("");
		metodo.validarTexto(nomePaginaLogado,"Anderson");
	}

}
