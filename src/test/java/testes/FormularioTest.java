package testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metodos.Metodos;
import pages.FormularioPage;
import pages.HomePage;
import runner.Executa;

public class FormularioTest {

	Metodos metodo = new Metodos();
	FormularioPage desafioP = new FormularioPage();
	HomePage homeP = new HomePage();

	@BeforeEach
	public void antesDoTeste() {
		Executa.iniciarTeste();
		homeP.acessarFormulario();
		metodo.aceitarAlert();
		
	}

	@Test
	public void validarUrlTest() {
		metodo.validarUrl("https://desafio.ui.e2etreinamentos.com.br/");
	}

	@Test
	public void selecionarEstadoTest() {
		desafioP.selecionarEstado("Minas Gerais");
	}

	@Test
	public void passarMouse() {
		desafioP.passarMouse();
	}

	@Test
	public void preencherFormularioTest() {
		desafioP.enviarFormulario("C:\\Users\\vitor\\Downloads");
	}

}
