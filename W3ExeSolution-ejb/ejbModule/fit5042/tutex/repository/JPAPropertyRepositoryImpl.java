package fit5042.tutex.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import fit5042.tutex.repository.constants.CommonInstance;
import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;

@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {
	private ArrayList<Property> propertyList;
	
	public JPAPropertyRepositoryImpl() {
    	propertyList = new ArrayList<Property>();
    	this.initialisePropertyList();
    }
	
	public void initialisePropertyList() {
    	propertyList.clear();
    	
    	propertyList.add(CommonInstance.PROPERTY_FIRST);
    	propertyList.add(CommonInstance.PROPERTY_SECOND);
    	propertyList.add(CommonInstance.PROPERTY_THIRD);
    	propertyList.add(CommonInstance.PROPERTY_FOURTH);
    }

	public ArrayList<Property> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(ArrayList<Property> propertyList) {
		this.propertyList = propertyList;
	}
	
	public void removeProperty(int propertyId) {
    	for (Property p : propertyList) {
    		if (p.getPropertyId() == propertyId) {
    			propertyList.remove(p);
    			break;
    		}
    	}
    	
    }
    
    public void addProperty(Property property) {
    	propertyList.add(property);
    }
    
    public void editProperty(Property property) {
    	for (Property p : propertyList) {
    		int id = property.getPropertyId();
    		if (p.getPropertyId() == id) {
    			propertyList.set(id, property);
    			break;
    		}
    	}
    }

	public int getPropertyId() {
		return propertyList.get(propertyList.size() - 1).getPropertyId();
	}
	
	public Property searchPropertyById(int propertyId) {
		for (Property p : propertyList) {
    		if (p.getPropertyId() == propertyId) {
    			return p;
    		}
    	}
		return null;
	}
	
	public List<ContactPerson> getAllContactPeople() {
		// map property list to contact person set
		Set<ContactPerson> contactPersonSet = propertyList.stream().map(property -> property.getContactPerson()).collect(Collectors.toSet());
		// then set convert to list (it can be one line code but here i separate it to two line because of the readability)
		List<ContactPerson> contactPersonList = new ArrayList<>(contactPersonSet);
		return contactPersonList;
	}
	
	public Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson) {
		// filter the property which contain a contact person object that has same id with argument
		Set<Property> propertySet = propertyList.stream().filter(property -> property.getContactPerson().getConactPersonId() == contactPerson.getConactPersonId()).collect(Collectors.toSet());
		return propertySet;
	}
	
	public List<Property> searchPropertyByBudget(double budget) {
		// filter the property which price are lower or equal to budget
		return propertyList.stream().filter(property -> property.getPrice() <= budget).collect(Collectors.toList());
    }

}
