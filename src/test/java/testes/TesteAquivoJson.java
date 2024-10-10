package testes;

import org.junit.jupiter.api.Test;

import utils.GerenciadorDeArquivos;

public class TesteAquivoJson {

	GerenciadorDeArquivos gerenciador = new GerenciadorDeArquivos();

	@Test
	public void mostrarArquivoJson() {

		System.out.println(gerenciador.lerArquivoJson("arquivojson.json"));

	}

}
