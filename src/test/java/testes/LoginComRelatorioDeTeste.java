package testes;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import metodos.Metodos;
import runner.Executa;
import utils.ExtentReports;

public class LoginComRelatorioDeTeste {

	Metodos metodo = new Metodos();

	@BeforeAll
	public static void setupReport() {
		ExtentReports.setupReport();
	}

	@BeforeEach
	public void antesDoTeste() {
		Executa.iniciarTeste();
	}

	@AfterEach
	public void depoisDoTeste() {
		Executa.finalizarTeste();
	}

	@AfterAll
	public static void tearDown() {
		ExtentReports.tearDownReport();
	}

	@Test
	public void testLogin() {
		try {
			ExtentReports.startTest("Testes de login com sucesso");
			metodo.escrever(By.id("user-name"), "standard_user");
			metodo.escrever(By.id("password"), "secret_sauce");
			metodo.clicar(By.id("login-button"));
			ExtentReports.logInf("Cliquei no botão de login");
		} catch (Exception e) {
			ExtentReports.logFail("Falha no login" + e.getMessage());
			throw e;
		}

	}

	@Test
	public void testCompra() {
		try {
			ExtentReports.startTest("Testes de Compra com sucesso");
			metodo.escrever(By.id("user-name"), "standard_user");
			metodo.escrever(By.id("password"), "secret_sauce");
			metodo.clicar(By.id("login-button"));
			ExtentReports.logInf("Cliquei no botão de login");
		} catch (Exception e) {
			ExtentReports.logFail("Falha no login" + e.getMessage());
			throw e;
		}

	}

	@Test
	public void testCadastro() {
		try {
			ExtentReports.startTest("Testes de Cadastro com sucesso");
			metodo.escrever(By.id("user-name"), "standard_user");
			metodo.escrever(By.id("password"), "secret_sauce");
			metodo.clicar(By.id("login-button"));
			ExtentReports.logInf("Cliquei no botão de login");
		} catch (Exception e) {
			ExtentReports.logFail("Falha no login" + e.getMessage());
			throw e;
		}

	}

}
