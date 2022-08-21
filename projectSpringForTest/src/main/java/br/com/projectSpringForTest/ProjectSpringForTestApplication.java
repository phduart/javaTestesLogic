package br.com.projectSpringForTest;

import br.com.projectSpringForTest.entity.Ptrr01;
import br.com.projectSpringForTest.model.EmployeeDTO;
import br.com.projectSpringForTest.model.EmployeesDTO;
import br.com.projectSpringForTest.repository.impl.Ptrr01Repository;
import org.decampo.xirr.Transaction;
import org.decampo.xirr.Xirr;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class ProjectSpringForTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringForTestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("------ INICIO PROCESSO ------");
		double rate = new Xirr(
				new Transaction(96526.86, "2022-05-03"),
				new Transaction(-98.139, "2022-05-03"),
				new Transaction(-10912.5, "2022-06-03"),
				new Transaction( -10805.3, "2022-07-03"),
				new Transaction( -10724.5, "2022-08-03"),
				new Transaction( -10643.7, "2022-09-03"),
				new Transaction( -10562.9, "2022-10-03"),
				new Transaction( -10482.1, "2022-11-03"),
				new Transaction( -10401.4, "2022-12-03"),
				new Transaction( -10320.6, "2023-01-03"),
				new Transaction( -10239.8, "2023-02-03"),
				new Transaction( -10104, "2023-03-03")
		).xirr();
		System.out.println(rate);
		double d = (double) (Math.round(rate*10000.0)/10000.0);
		System.out.println(d);
		System.out.println("------ FIM PROCESSO ------");
	}

}
