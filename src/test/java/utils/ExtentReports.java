package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports {

	private static com.aventstack.extentreports.ExtentReports extent;
	private static ExtentTest test; // gerenciar testes
	private static ExtentSparkReporter sparkReporter; // gerar relatórios no formato HTML

	public static void setupReport() {
		// inicializa o ExtentSparkReporter com o caminho para o arquivo HTMl
		sparkReporter = new ExtentSparkReporter("./relatorios/relatorio.html");

		// Configurar o titulo do relatório
		sparkReporter.config().setDocumentTitle("Relatório de Teste");

		// Configurar o nome do relatórios
		sparkReporter.config().setReportName("Relatório de Execução de Testes");

		// defina o tema do relatório para DARK ou STANDARD
		sparkReporter.config().setTheme(Theme.DARK);

		// Inicializar a instância do ExtentReports
		extent = new com.aventstack.extentreports.ExtentReports();

		// Anexa a configuração SparkReporter ao EntetReport
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Sistema Operacional", "Windows");
		extent.setSystemInfo("Ambiente de Testes", "Selenium com JUnit");

	}

	// Método iniciar um teste
	public static void startTest(String nomeDoTeste) {
		test = extent.createTest(nomeDoTeste);

	}

	// Método para finalizar e salvar relatório
	public static void tearDownReport() {
		// salva o relório e encerra a execução
		extent.flush();
	}

	// Método para registrar falhas no relatório
	public static void logFail(String mensagem) {
		test.fail(mensagem);

	}

	//Método para registrar informações 
	public static void logInf(String mensagem) {
		test.info(mensagem);

	}
}
