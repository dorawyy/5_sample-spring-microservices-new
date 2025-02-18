package pl.piomin.services.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import pl.piomin.services.employee.model.Employee;
import pl.piomin.services.employee.repository.EmployeeRepository;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@OpenAPIDefinition(info =
	@Info(title = "Employee API", version = "1.0", description = "Documentation Employee API v1.0")
)
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("pl.piomin.services.employee.controller"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Employee API").description("Documentation Employee API v1.0").build());
	}
	
	@Bean
	EmployeeRepository repository() {
		EmployeeRepository repository = new EmployeeRepository(); // call
		repository.add(new Employee(1L, 1L, "John Smith", 34, "Analyst")); // call // call 
		repository.add(new Employee(1L, 1L, "Darren Hamilton", 37, "Manager")); // call // call
		repository.add(new Employee(1L, 1L, "Tom Scott", 26, "Developer")); // call // call
		repository.add(new Employee(1L, 2L, "Anna London", 39, "Analyst"));	// call // call	
		repository.add(new Employee(1L, 2L, "Patrick Dempsey", 27, "Developer")); // call // call
		repository.add(new Employee(2L, 3L, "Kevin Price", 38, "Developer")); // call // call
		repository.add(new Employee(2L, 3L, "Ian Scott", 34, "Developer")); // call // call
		repository.add(new Employee(2L, 3L, "Andrew Campton", 30, "Manager")); // call // call
		repository.add(new Employee(2L, 4L, "Steve Franklin", 25, "Developer")); // call // call
		repository.add(new Employee(2L, 4L, "Elisabeth Smith", 30, "Developer")); // call // call
		return repository;
	}
	
}
