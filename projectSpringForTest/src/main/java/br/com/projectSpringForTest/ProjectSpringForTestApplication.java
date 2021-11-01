package br.com.projectSpringForTest;

import br.com.projectSpringForTest.entity.Ptrr01;
import br.com.projectSpringForTest.model.EmployeeDTO;
import br.com.projectSpringForTest.model.EmployeesDTO;
import br.com.projectSpringForTest.repository.impl.Ptrr01Repository;
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

	private final Ptrr01Repository repo;

	public ProjectSpringForTestApplication(Ptrr01Repository repo) {
		this.repo = repo;
	}

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
		System.out.println(repo.getPolizaUm().get(0).getPoliza());
//		RestTemplate restTemplate = new RestTemplate();
//		HttpHeaders header = new HttpHeaders();
//		header.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//		HttpEntity<?> entity = new HttpEntity<>(header);
//		HttpEntity<EmployeesDTO> response = restTemplate.exchange("http://dummy.restapiexample.com/api/v1/employees", HttpMethod.GET, entity, EmployeesDTO.class);
//		System.out.println(response.getBody().getStatus());
//		List<EmployeeDTO> lista = response.getBody().getData();
//		for(EmployeeDTO item : lista){
//			System.out.println(item.getEmployeeName());
//		}
		System.out.println("------ FIM PROCESSO ------");
	}

}
