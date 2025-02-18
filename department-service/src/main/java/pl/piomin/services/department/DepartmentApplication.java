package pl.piomin.services.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import pl.piomin.services.department.model.Department;
import pl.piomin.services.department.repository.DepartmentRepository;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
@OpenAPIDefinition(info =
	@Info(title = "Department API", version = "1.0", description = "Documentation Department API v1.0")
)
public class DepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}

	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("pl.piomin.services.department.controller"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Department API").description("Documentation Department API v1.0").build());
	}
	
	@Bean
	DepartmentRepository repository() {
		DepartmentRepository repository = new DepartmentRepository(); // call 
		repository.add(new Department(1L, "Development")); // call // call
		repository.add(new Department(1L, "Operations")); // call // call
		repository.add(new Department(2L, "Development")); // call // call
		repository.add(new Department(2L, "Operations")); // call // call
		return repository;
	}
	
}
