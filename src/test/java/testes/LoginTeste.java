package testes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.HomePage;
import pages.LoginPage;
import runner.Executa;

public class LoginTeste {
	
	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	
	@BeforeEach
	public void antesDoTeste() {
		Executa.iniciarTeste();
		home.acessarMenu("Login");
	}
	
	@AfterEach
	public void depoisDoTeste() {
		Executa.finalizarTeste();
	}
	
	@Test
	public void loginEmBranco() {
		login.preencherDadosLogin("", "");
		
	}
	
	@Test
	public void loginComSucesso() {
		login.preencherDadosLogin("anderson@e2etreinamentos.com.br", "123456");
	}

}
