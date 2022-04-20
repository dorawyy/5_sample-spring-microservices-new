package pl.piomin.services.organization.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pl.piomin.services.organization.model.Organization;

public class OrganizationRepository {

	private List<Organization> organizations = new ArrayList<>();
	
	public Organization add(Organization organization) {
		organization.setId(Integer.toString(organizations.size()+1)); // call 
		organizations.add(organization);
		return organization;
	}
	
	public Organization findById(String id) {
		Optional<Organization> organization = organizations.stream().filter(a -> a.getId().equals(id)).findFirst(); // call (getId)
		if (organization.isPresent())
			return organization.get();
		else
			return null;
	}
	
	public List<Organization> findAll() {
		return organizations;
	}
	
}
