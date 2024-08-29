package metodos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.Drivers;

public class Metodos extends Drivers {

	/**
	 * Clicar em um elemento passando o By
	 * 
	 * @param elemento
	 */
	public void clicar(By elemento) {
		driver.findElement(elemento).click();
	}

	/**
	 * Escrever em um elemento
	 * 
	 * @param elemento
	 * @param texto
	 */
	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);
	}

	/**
	 * Informar a url que deseja validar
	 * 
	 * @param urlEsperada
	 */
	public void validarUrl(String urlEsperada) {
		assertEquals(urlEsperada, driver.getCurrentUrl());
	}

	/**
	 * Informar o texto esperado para ser validado com o texto capturado
	 * 
	 * @param elemento
	 * @param textoEsperado
	 */
	public void validarTexto(By elemento, String textoEsperado) {
		assertEquals(textoEsperado, driver.findElement(elemento).getText());
	}

	/**
	 * informar o elemento que será aguardado até segundos, dado que exceda o tempo,
	 * irá ocorrer time out.
	 * 
	 * @param elemento
	 */
	public void aguardarElemento(By elemento) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public void tirarPrint() {

	}

	public void trocarDeAba() {

	}

	public void validarAlert() {

	}

	public void scrooll() {

	}

	public void zoom() {

	}

	public void moverEClicar() {

	}

	public void duploClique() {

	}

	public void mouseOver() {

	}

	public void tab() {

	}

	public void limparCampo() {

	}

	public void digitarPausadamente() {

	}

	public void clicaESergura() {

	}

	public void submite() {

	}
}
