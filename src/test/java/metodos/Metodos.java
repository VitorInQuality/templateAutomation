package metodos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.Drivers;

public class Metodos extends Drivers {

	/**
	 * Realiza um clique em um elemento da página.
	 *
	 * @param elemento o localizador do elemento (By) que será clicado.
	 * 
	 *                 Este método localiza o elemento especificado e executa uma
	 *                 ação de clique sobre ele.
	 */
	public void clicar(By elemento) {
		driver.findElement(elemento).click();
	}

	/**
	 * Insere o texto especificado em um campo de entrada na página.
	 *
	 * @param elemento o localizador do campo de entrada (By) onde o texto será
	 *                 inserido.
	 * @param texto    o texto a ser inserido no campo de entrada.
	 * 
	 *                 Este método localiza o campo de entrada especificado e envia
	 *                 o texto fornecido para ele.
	 */
	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);
	}

	/**
	 * Valida se a URL atual do navegador corresponde à URL esperada.
	 *
	 * @param urlEsperada a URL esperada que deve corresponder à URL atual do
	 *                    navegador.
	 * 
	 *                    Este método obtém a URL atual do navegador e a compara com
	 *                    a URL esperada. Se as URLs não coincidirem, uma asserção
	 *                    falhará.
	 */
	public void validarUrl(String urlEsperada) {
		assertEquals(urlEsperada, driver.getCurrentUrl());
	}

	/**
	 * Valida se o texto de um elemento na página corresponde ao texto esperado.
	 *
	 * @param elemento      o localizador do elemento (By) cujo texto será validado.
	 * @param textoEsperado o texto esperado que deve corresponder ao texto do
	 *                      elemento.
	 * 
	 *                      Este método obtém o texto do elemento especificado e o
	 *                      compara com o texto esperado. Se os textos não
	 *                      coincidirem, uma asserção falhará.
	 */
	public void validarTexto(By elemento, String textoEsperado) {
		assertEquals(textoEsperado, driver.findElement(elemento).getText());
	}

	/**
	 * Aguarda até que o elemento especificado esteja visível na página.
	 *
	 * @param elemento o localizador do elemento (By) que deve se tornar visível.
	 * 
	 *                 Este método cria uma instância de `WebDriverWait` com um
	 *                 tempo máximo de espera de 10 segundos e aguarda até que o
	 *                 elemento especificado esteja visível na página. Se o elemento
	 *                 não se tornar visível dentro do tempo especificado, uma
	 *                 exceção será lançada.
	 */
	public void aguardarElemento(By elemento) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elemento));
	}

	/**
	 * Aguarda até que o elemento especificado esteja visível na página por um
	 * período determinado.
	 *
	 * @param elemento o localizador do elemento (By) que deve se tornar visível na
	 *                 página.
	 * @param segundos o tempo máximo em segundos para aguardar até que o elemento
	 *                 se torne visível.
	 * 
	 *                 Este método cria uma instância de `WebDriverWait` com o tempo
	 *                 máximo de espera fornecido. Em seguida, aguarda até que o
	 *                 elemento especificado esteja visível na página. Se o elemento
	 *                 não se tornar visível dentro do tempo especificado, uma
	 *                 exceção será lançada.
	 */
	public void aguardarElemento(By elemento, int segundos) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elemento));
	}

	/**
	 * Captura uma captura de tela (screenshot) e a salva em um diretório específico
	 * com um nome de arquivo baseado no timestamp.
	 *
	 * @param nomeDaPasta     o nome da pasta onde o screenshot será salvo.
	 * @param nomeDaEvidencia o nome base do arquivo para o screenshot, ao qual será
	 *                        adicionado um timestamp.
	 *
	 *                        Este método gera um nome de arquivo único para a
	 *                        captura de tela com base no timestamp atual e a salva
	 *                        no diretório especificado. Se ocorrer uma falha na
	 *                        cópia do arquivo, a exceção será registrada.
	 */
	public void tirarPrint(String nomeDaPasta, String nomeDaEvidencia) {

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File("./evidencia/" + nomeDaPasta + "/" + nomeDaEvidencia + timestamp + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Troca para a última aba aberta no navegador, se houver mais de uma aba.
	 * 
	 * Este método armazena o identificador da aba principal e, em seguida, itera
	 * por todas as abas abertas para encontrar a última aba que não é a aba
	 * principal e muda o foco para essa aba.
	 */
	public void trocarDeAba() {
		String abaPrincipal = driver.getWindowHandle();
		Set<String> todasAbas = driver.getWindowHandles();
		for (String ultimaAbaAberta : todasAbas) {
			if (!ultimaAbaAberta.equals(abaPrincipal)) {
				driver.switchTo().window(ultimaAbaAberta);

			}

		}
	}

	/**
	 * Valida o texto do alerta pop-up atual exibido no navegador.
	 *
	 * @param textoEsperado o texto que se espera encontrar no alerta pop-up.
	 * 
	 *                      Este método obtém o alerta pop-up ativo e compara seu
	 *                      texto com o texto esperado. Se os textos não
	 *                      coincidirem, uma asserção falhará.
	 */
	public void validarAlert(String textoEsperado) {
		Alert alert = driver.switchTo().alert();
		assertEquals(textoEsperado, alert.getText());

	}

	/**
	 * Aceita e fecha o alerta pop-up atual exibido no navegador.
	 * 
	 * Este método switcha para o alerta pop-up ativo e confirma sua aceitação.
	 */
	public void aceitarAlert() {
		pausa(6000);
		driver.switchTo().alert().accept();

	}

	/**
	 * Rolagem da página para baixo ou para cima em um número especificado de
	 * pixels.
	 *
	 * @param pixel o número de pixels para rolar na vertical. Valores positivos
	 *              rolam para baixo e negativos rolam para cima.
	 */
	public void scrooll(String pixel) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");

	}

	/**
	 * Ajusta o nível de zoom da página atual.
	 *
	 * @param zoom o valor de zoom a ser aplicado, especificado em porcentagem (por
	 *             exemplo, "150" para 150%).
	 */
	public void zoom(String zoom) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='" + zoom + "%'");

	}

	/**
	 * Move o cursor do mouse para um elemento da página e realiza um clique no
	 * mesmo.
	 *
	 * @param elemento o localizador do elemento (By) para o qual o cursor do mouse
	 *                 será movido e clicado.
	 */
	public void moverEClicar(By elemento) {

		WebElement el = driver.findElement(elemento);
		Actions actions = new Actions(driver);
		actions.moveToElement(el).click().perform();

	}

	/**
	 * Realiza a ação de duplo clique em um elemento da página.
	 *
	 * @param elemento o localizador do elemento (By) sobre o qual a ação de duplo
	 *                 clique será realizada.
	 */
	public void duploClique(By elemento) {
		WebElement el = driver.findElement(elemento);
		Actions actions = new Actions(driver);
		actions.doubleClick(el).perform();

	}

	/**
	 * Realiza a ação de mover o cursor do mouse sobre um elemento da página.
	 *
	 * @param elemento o localizador do elemento (By) sobre o qual o cursor do mouse
	 *                 será movido.
	 */
	public void mouseOver(By elemento) {
		WebElement el = driver.findElement(elemento);
		Actions actions = new Actions(driver);
		actions.moveToElement(el).perform();

	}

	public void tab() {

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).perform();
		;

	}

	public void enter() {

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();

	}

	public void end() {

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();

	}

	public void pageDown() {

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

	}

	public void enter(By elemento) {
		driver.findElement(elemento).sendKeys(Keys.ENTER);

	}

	/**
	 * Limpa o conteúdo de um campo de entrada (input) encontrado no elemento
	 * especificado.
	 *
	 * @param elemento o localizador do campo (By) que será limpo. O elemento deve
	 *                 ser um campo de entrada (input) ou similar.
	 */
	public void limparCampo(By elemento) {
		driver.findElement(elemento).clear();

	}

	public void digitarPausadamente(By elemento, String texto) {

		for (char c : texto.toCharArray()) {
			driver.findElement(elemento).sendKeys(String.valueOf(c));

			pausa(1000);
		}

	}

	/**
	 * Realiza a ação de clicar e segurar em um elemento da página.
	 *
	 * @param elemento o localizador do elemento (By) em que a ação de clicar e
	 *                 segurar será executada.
	 */
	public void clicaESergura(By elemento) {
		WebElement el = driver.findElement(elemento);
		Actions actions = new Actions(driver);
		actions.clickAndHold(el).perform();

	}

	/**
	 * Submete um formulário encontrado no elemento especificado.
	 *
	 * @param elemento o localizador do elemento (By) que será submetido. O elemento
	 *                 deve ser parte de um formulário.
	 */
	public void submit(By elemento) {
		driver.findElement(elemento).submit();

	}

	/**
	 * Executa uma ação de clique em um elemento da página e, em seguida, envia a
	 * tecla de espaço para o mesmo elemento.
	 *
	 * @param elemento o localizador do elemento (By) no qual a ação de clique e o
	 *                 envio da tecla de espaço serão realizados.
	 */
	public void clicarEDarEspaco(By elemento) {
		clicar(elemento);
		driver.findElement(elemento).sendKeys(Keys.SPACE);

	}

	public void fecharPopUp(By elemento) {
		int contador = 1;
		WebElement element = driver.findElement(elemento);
		do {

			clicar(elemento);
			contador--;

		} while (element.isDisplayed() && contador > 0);

	}

	public void validarTitle(String titleEsperado) {
		assertEquals(titleEsperado, driver.getTitle());
	}

	public void voltarPagina() {
		driver.navigate().back();
	}

	public void avancarPagina() {
		driver.navigate().forward();
	}

	public void atualizarPagina() {
		driver.navigate().refresh();
	}

	void uploadDeArquivo(By elemento, String path) {
		driver.findElement(elemento).sendKeys(path);

	}

	public void pausa(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
