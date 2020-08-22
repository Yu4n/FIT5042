package fit5042.tutex.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;

@Remote
public interface PropertyRepository {
	
	public void initialisePropertyList();

	public ArrayList<Property> getPropertyList();

	public void setPropertyList(ArrayList<Property> propertyList);
	
	public void removeProperty(int propertyId);
    
    public void addProperty(Property property);
    
    public void editProperty(Property property);

	public int getPropertyId();
	
	public Property searchPropertyById(int propertyId);
	
	public List<ContactPerson> getAllContactPeople();
	
	public Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson);
	public List<Property> searchPropertyByBudget(double budget);
	

}
