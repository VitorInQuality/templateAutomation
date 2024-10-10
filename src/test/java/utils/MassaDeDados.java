package utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class MassaDeDados {

	Faker faker = new Faker(new Locale("pt-br"));
	Random random = new Random();

	public String gerarNome() {
		return faker.name().fullName();
	}

	public String gerarSobrenome() {
		return faker.name().lastName();
	}

	public String gerarEmail() {
		return faker.internet().emailAddress();
	}

	public String gerarEndereco() {
		return faker.address().fullAddress();
	}

	public String gerarDataNascimento() {
		Date dataNascimento = faker.date().birthday(18, 65);
		// Converter para LocalDate
		LocalDate localDate = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		// Formatar a data para "ddMMyyyy"
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

		return localDate.format(formatter);
	}

	public String gerarNumeroTelefone() {
		return faker.phoneNumber().phoneNumber();
	}

	public String gerarCidade() {
		return faker.address().cityName();
	}

	public String gerarRg() {

		return faker.number().digits(10);
	}

	String[] estadosBrasileiros = { "SP", "MG", "RO", "BA", "RS" };

	public String gerarEstado() {

		int index = random.nextInt(estadosBrasileiros.length);

		return estadosBrasileiros[index];
	}

}
