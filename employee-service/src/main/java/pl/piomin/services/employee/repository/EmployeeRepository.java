package pl.piomin.services.employee.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import pl.piomin.services.employee.model.Employee;

public class EmployeeRepository {

	private List<Employee> employees = new ArrayList<>();
	
	public Employee add(Employee employee) {
		employee.setId(Integer.toString(employees.size()+1)); // call 
		employees.add(employee);
		return employee;
	}
	
	public Employee findById(String id) {
		Optional<Employee> employee = employees.stream().filter(a -> a.getId().equals(id)).findFirst(); // call (getId)
		if (employee.isPresent())
			return employee.get();
		else
			return null;
	}
	
	public List<Employee> findAll() {
		return employees;
	}
	
	public List<Employee> findByDepartment(String departmentId) {
		return employees.stream().filter(a -> a.getDepartmentId().equals(departmentId)).collect(Collectors.toList()); // call (getDepartmentId)
	}
	
	public List<Employee> findByOrganization(String organizationId) {
		return employees.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList()); // call (getOrganizationId)
	}
	
}
