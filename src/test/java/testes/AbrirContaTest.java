package testes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.ContaPage;
import pages.HomePage;
import runner.Executa;

public class AbrirContaTest {

	HomePage home = new HomePage();
	ContaPage conta = new ContaPage();

	@BeforeEach
	public void antesDoTeste() {
		Executa.iniciarTeste();
	}

	@AfterEach
	public void depoisDoTeste() {
		Executa.finalizarTeste();
	}

	@Test
	public void abrirConta() {
		home.acessarMenu("Abrir conta");
		conta.iniciarAberturaDeConta("123.123.123-22");
		conta.preencherDadosPessoais("Anderson", "Barbosa", "anderson@gmail.com", "01012000", "15151515",
				"(11) 99156-0558", "rua teste", "06545-50", "2975", "complemento", "SP", "São Paulo");
		conta.preencherDadosProfissionais("112023", "112024", "QA", "12000", "anderson@e2etreinamentos.com.br");
		conta.preencherSenha("123456", "123456");
	}

	public void abrirContaAberta() {
		home.acessarMenu("Abrir conta");
		conta.iniciarAberturaDeConta("123.123.123-55", "O CPF fornecido já está registrado como cliente.");
	}

}
