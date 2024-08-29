package pages;

import org.openqa.selenium.By;

import elementos.Elementos;
import metodos.Metodos;

public class ContaPage {

	Metodos metodo = new Metodos();
	Elementos el = new Elementos();

	private By msgErrorIniciarAbertura = By.xpath("//*[@id='error-message']");
	
	/**
	 * Informar o cpf que deseja iniciar o cadastrado
	 * 
	 * @param cpf
	 */
	public void iniciarAberturaDeConta(String cpf) {
		metodo.escrever(el.cpf, cpf);
		metodo.clicar(el.btnContinuar);
	}
	
	public void iniciarAberturaDeConta(String cpf,String msgError) {
		metodo.escrever(el.cpf, cpf);
		metodo.clicar(el.btnContinuar);
		metodo.validarTexto(msgErrorIniciarAbertura, msgError);
	}

	public void preencherDadosPessoais(String nome, String sobrenome, String email, String dtaNascimento, String rg,
			String telefone, String endereco, String cep, String numero, String complemento, String estado,
			String cidade) {
		metodo.aguardarElemento(el.nome);
		metodo.escrever(el.nome, nome);
		metodo.escrever(el.sobrenome, sobrenome);
		metodo.escrever(el.email, email);
		metodo.clicar(el.dtaNascimento);
		metodo.escrever(el.dtaNascimento, dtaNascimento);
		metodo.escrever(el.rg, rg);
		metodo.clicar(el.telefone);
		metodo.escrever(el.telefone, telefone);
		metodo.escrever(el.endereco, endereco);
		metodo.clicar(el.cep);
		metodo.escrever(el.cep, cep);
		metodo.escrever(el.numero, numero);
		metodo.escrever(el.complemento, complemento);
		metodo.escrever(el.estado, estado);
		metodo.escrever(el.cidade, cidade);
		metodo.clicar(el.btnContinuar);
	}

	public void preencherDadosProfissionais(String turmaInicial, String turmaAtual, String salario, String job,
			String emailProfissional) {
		metodo.aguardarElemento(el.turmaInicial);
		metodo.escrever(el.turmaInicial, turmaInicial);
		metodo.escrever(el.turmaAtual, turmaAtual);
		metodo.escrever(el.job, job);
		metodo.escrever(el.salario, salario);
		metodo.escrever(el.emailProfissional, emailProfissional);
		metodo.clicar(el.btnEnviar);
	}

	public void preencherSenha(String senha, String confirmarSenha) {
		metodo.aguardarElemento(el.senha);
		metodo.escrever(el.senha, senha);
		metodo.escrever(el.confirmarSenha, confirmarSenha);
		metodo.clicar(el.btnCadastrar);
	}

	public void fecharDadosPessoais() {
		metodo.aguardarElemento((el.btnFecharX));
		metodo.clicar(el.btnFecharX);
	}

	public void voltarDadosPessoais() {
		metodo.aguardarElemento((el.btnVoltar));
		metodo.clicar(el.btnVoltar);
	}

	public void cancelarEnvioDeSenha() {
		metodo.aguardarElemento((el.btnCancelar));
		metodo.clicar(el.btnCancelar);
	}

}
