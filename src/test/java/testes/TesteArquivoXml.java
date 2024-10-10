package testes;

import org.junit.jupiter.api.Test;

import utils.GerenciadorDeArquivos;

public class TesteArquivoXml {

	GerenciadorDeArquivos gerenciador = new GerenciadorDeArquivos();

	@Test
	public void lerArquivoXml() {
		System.out.println(gerenciador.lerArquivoXml("arquivotxt"));

	}

}
