package testes;

import org.junit.jupiter.api.Test;

import utils.GerenciadorDeArquivos;

public class testeArquivoTxt {
	
	GerenciadorDeArquivos gerenciador = new GerenciadorDeArquivos();
	
	
	
	@Test
	public void mostrarArquivotxt() {
		System.out.println(gerenciador.lerArquivoTxt("arquivotxt").contains("Vitor"));
	}

}
