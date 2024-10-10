package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.Pdf;

public class GerenciadorDeArquivos {

	public String lerArquivoTxt(String arquivo) {

		// StringBuilder é usado para armazenar o conteúdo do arquivo lido.
		StringBuilder conteudo = new StringBuilder();

		// Concatena o caminho base com o nome do arquivo fornecido para criar o caminho
		// completo.
		try (BufferedReader reader = new BufferedReader(new FileReader("./src/test/resources/arquivos/" + arquivo))) {

			String linha;

			// Lê o arquivo linha por linha até que todas as linhas sejam processadas.
			while ((linha = reader.readLine()) != null) {
				// Adiciona a linha lida ao StringBuilder, seguida por uma nova linha.
				conteudo.append(linha).append("\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Retorna o conteúdo completo do arquivo como uma única string.
		return conteudo.toString();
	}

	public String lerArquivoJson(String arquivo) {

		StringBuilder conteudo = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader("./src/test/resources/arquivos/" + arquivo))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				conteudo.append(linha).append("\n");
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return conteudo.toString();
	}

	public String lerArquivoXml(String arquivo) {

		StringBuilder conteudo = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader("./src/test/resources/arquivos/" + arquivo))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				conteudo.append(linha).append("\n");
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return conteudo.toString();
	}

	/**
	 * 
	 * @return
	 * @author Vitor Rodrigues
	 */
	public String lerArquivoPDF(String arquivoPDF) {
		StringBuilder conteudo = new StringBuilder();

		try (PDDocument document = PDDocument.load(new File("./src/test/resources/arquivos/" + arquivoPDF))) {

			PDFTextStripper stripper = new PDFTextStripper();

			conteudo.append(stripper.getText(document));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conteudo.toString();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
