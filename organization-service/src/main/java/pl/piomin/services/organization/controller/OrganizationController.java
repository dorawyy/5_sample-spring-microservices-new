package pl.piomin.services.organization.controller;

import java.util.List;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.services.organization.client.DepartmentClient;
import pl.piomin.services.organization.client.EmployeeClient;
import pl.piomin.services.organization.model.Department;
import pl.piomin.services.organization.model.Organization;
import pl.piomin.services.organization.repository.OrganizationRepository;

@RestController
public class OrganizationController {

	// private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);
	private static Logger logger = LogManager.getLogger(OrganizationController.class);
	
	@Autowired
	OrganizationRepository repository;
	@Autowired
	DepartmentClient departmentClient;
	@Autowired
	EmployeeClient employeeClient;
	
	@PostMapping
	public Organization add(@RequestBody Organization organization) {
		// LOGGER.info("Organization add: {}", organization);
		logger.info("Organization add: {}", organization);
		return repository.add(organization); // call 
	}
	
	@GetMapping
	public List<Organization> findAll() {
		// LOGGER.info("Organization find");
		logger.info("Organization find");
		return repository.findAll(); // call 
	}
	
	@GetMapping("/{id}")
	public Organization findById(@PathVariable("id") String id) {
		// LOGGER.info("Organization find: id={}", id);
		logger.info("Organization find: id={}", id);
		return repository.findById(id); // call 
	}

	@GetMapping("/{id}/with-departments") // select this
	public Organization findByIdWithDepartments(@PathVariable("id") String id) {
		// LOGGER.info("Organization find: id={}", id);
		logger.info("Organization find: id={}", id);
		List<Department> departments = departmentClient.findByOrganization(id);
		Organization organization = repository.findById(id); // call 
		organization.setDepartments(departments);
		// organization.setDepartments(departmentClient.findByOrganization(organization.getId())); // call // call, missing, client // call 
		return organization;
	}
	
	@GetMapping("/{id}/with-departments-and-employees")
	public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") String id) {
		// LOGGER.info("Organization find: id={}", id);
		logger.info("Organization find: id={}", id);
		Organization organization = repository.findById(id); // call 
		organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId())); // call // call, missing, client // call 
		return organization;
	}
	
	@GetMapping("/{id}/with-employees")
	public Organization findByIdWithEmployees(@PathVariable("id") String id) {
		// LOGGER.info("Organization find: id={}", id);
		logger.info("Organization find: id={}", id);
		Organization organization = repository.findById(id); // call 
		organization.setEmployees(employeeClient.findByOrganization(organization.getId())); // call // call, missing, client // call 
		return organization;
	}
	
}
