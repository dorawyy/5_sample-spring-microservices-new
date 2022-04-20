package pl.piomin.services.department.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import pl.piomin.services.department.model.Department;

public class DepartmentRepository {

	private List<Department> departments = new ArrayList<>();
	
	public Department add(Department department) {
		department.setId(Integer.toString(departments.size()+1)); // call
		departments.add(department);
		return department;
	}
	
	public Department findById(String id) {
		Optional<Department> department = departments.stream().filter(a -> a.getId().equals(id)).findFirst(); // call (getId)
		if (department.isPresent())
			return department.get();
		else
			return null;
	}
	
	public List<Department> findAll() {
		return departments;
	}
	
	public List<Department> findByOrganization(String organizationId) {
		return departments.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList()); // call (getOrganizationId)
	}
	
}
