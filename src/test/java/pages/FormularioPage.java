package pages;

import org.openqa.selenium.By;

import metodos.Metodos;
import utils.MassaDeDados;

public class FormularioPage {
	MassaDeDados massa = new MassaDeDados();
	Metodos metodo = new Metodos();
	HomePage homeP = new HomePage();

	By btnSelect = By.xpath("//select");
	By nome = By.xpath("//form[@id='formulario']//label[1]//input");
	By email = By.xpath("//form[@id='formulario']//label[2]//input");
	By telefone = By.xpath("//form[@id='formulario']//label[3]//input");
	By endereco = By.xpath("//form[@id='formulario']//label[4]//input");
	By cidade = By.xpath("//form[@id='formulario']//label[5]//input");
	By uploadArquivo = By.xpath("//form[@id='formulario']//label[6]//input");
	By btnEnviar = By.xpath("//button[text()='Enviar']");
	By passarMouse = By.xpath("//span[@class='hover-alert']");

	public void selecionarEstado(String estado) {
		homeP.acessarFormulario();
		metodo.escrever(By.xpath("//select"), estado);

	}

	public void enviarFormulario(String filePatch) {
		homeP.acessarFormulario();
		metodo.escrever(this.nome, massa.gerarNome());
		metodo.escrever(this.email, massa.gerarEmail());
		metodo.escrever(this.telefone, massa.gerarNumeroTelefone());
		metodo.escrever(this.endereco, massa.gerarEndereco());
		metodo.escrever(this.cidade, massa.gerarCidade());
		metodo.escrever(this.uploadArquivo, filePatch);
		metodo.clicar(btnEnviar);
		metodo.validarTexto(btnEnviar, filePatch);

	}

	public void passarMouse() {
		homeP.acessarFormulario();
		metodo.mouseOver(passarMouse);
	}

}
