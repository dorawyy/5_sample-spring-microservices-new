package pl.piomin.services.employee.controller;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import pl.piomin.services.employee.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.services.employee.model.Employee;
import pl.piomin.services.employee.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	// private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	private static final Logger LOGGER = new Logger();
	
	@Autowired
	EmployeeRepository repository;
	
	@PostMapping("/")
	public Employee add(@RequestBody Employee employee) {
		LOGGER.info("Employee add: " + employee);
		return repository.add(employee); // call 
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") String id) {
		LOGGER.info("Employee find: id=" + id);
		return repository.findById(id); // call 
	}
	
	@GetMapping("/")
	public List<Employee> findAll() {
		LOGGER.info("Employee find");
		return repository.findAll(); // call 
	}
	
	@GetMapping("/department/{departmentId}")
	public List<Employee> findByDepartment(@PathVariable("departmentId") String departmentId) {
		LOGGER.info("Employee find: departmentId= " + departmentId);
		return repository.findByDepartment(departmentId); // call 
	}
	
	@GetMapping("/organization/{organizationId}")
	public List<Employee> findByOrganization(@PathVariable("organizationId") String organizationId) {
		LOGGER.info("Employee find: organizationId= " + organizationId);
		return repository.findByOrganization(organizationId); // call
	}
	
}
