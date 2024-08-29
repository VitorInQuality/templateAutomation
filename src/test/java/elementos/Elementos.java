package elementos;

import org.openqa.selenium.By;

public class Elementos {

	// Elementos iniciarAbertura de conta

	public By cpf = By.xpath("//input[@id='cpf-input']");

	public By dadosPessoais = By.xpath("//h2[text()='Dados Pessoais']");
	public By campoCpf = By.xpath("//input[@id='cpf-input']");
	public By btnContinuar = By.xpath("//button[text()='Continuar']");
	public By btnAbrirConta = By.xpath("//button[text()='Abrir conta']");
	public By msgError = By.xpath("//p[@id='error-message']");
	public By btnFechar = By.xpath("//button[@class='close-cta-button']");
	public By btnAcessarLogin = By.xpath("//button[text()='Login']");
	public By btnCancelarLogin = By.xpath("//button[text()='Cancelar']");

	// Elementos Dados pessoais
	public By nome = By.xpath("//*[@name='firstName']");
	public By sobrenome = By.xpath("//*[@name='lastName']");
	public By cep = By.xpath("//*[@name='cep']");
	public By numero = By.xpath("//*[@name='number']");
	public By complemento = By.xpath("//*[@name='complement']");
	public By estado = By.xpath("//*[@name='state']");
	public By cidade = By.xpath("//*[@name='city']");
	public By btnAvancar = By.xpath("//button[text()='Avançar']");
	public By email = By.xpath("//*[@name='email']");
	public By dtaNascimento = By.xpath("//*[@name='dataBirthday']");
	public By rg = By.xpath("//*[@name='rg']");
	public By telefone = By.xpath("//*[@name='phoneNumber']");
	public By endereco = By.xpath("//*[@name='address']");

	// Elementos dados profissionais
	public By turmaInicial = By.xpath("//*[@name='actualGroup']");
	public By turmaAtual = By.xpath("//*[@name='firstGroup']");
	public By salario = By.xpath("//*[@placeholder='Salário']");
	public By job = By.xpath("//*[@name='job']");
	public By emailProfissional = By.xpath("//*[@name='professionalEmail']");
	public By btnEnviar = By.xpath("//*[@id='btnEnviar']");
	public By btnVoltar = By.xpath("//*[@id='btnVoltar']");
	public By btnFecharX = By.xpath("//button[@class='close-button']']");

	// Elementos cadastrarSenha
	public By usuario = By.xpath("//input[@name='username']");
	public By senha = By.xpath("//input[@name='password']");
	public By confirmarSenha = By.xpath("//*[@name='confirmPassword']");
	public By btnCadastrar = By.xpath("//*[text()='Cadastrar']");
	public By btnCancelar = By.xpath("//*[text()='Cancelar']");
}
