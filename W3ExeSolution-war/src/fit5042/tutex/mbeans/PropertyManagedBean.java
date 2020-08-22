/*
 * To change this license header, choose License Headers in Project Properties.
 */
package fit5042.tutex.mbeans;

import fit5042.tutex.calculator.CompareProperty;
import fit5042.tutex.calculator.ComparePropertySessionBean;
import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.entities.Address;
import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author messomc
 * @author guan
 *
 */
@ManagedBean(name = "propertyManagedBean", eager = true)
@SessionScoped
public class PropertyManagedBean implements Serializable {
    
	@EJB
	private CompareProperty compareProperty;
	
	@EJB
	private PropertyRepository propertyRepository;
	
    private int bestPerRoom;
    private int selectedId;

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    public int getBestPerRoom() {
        return bestPerRoom;
    }

    public void setBestPerRoom(int bestPerRoom) {
        this.bestPerRoom = bestPerRoom;
    }
    
    /**
     * Creates a new instance of PropertyManagedBean
     */
    public PropertyManagedBean() {
        selectedId = 0;
        compareProperty = new ComparePropertySessionBean();
    }

    public List<Property> getAllProperties() {
        try {
            List<Property> properties = propertyRepository.getPropertyList();
            return properties;
        } catch (Exception ex) {
            Logger.getLogger(PropertyManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addProperty(Property property) {
    	Property p = convertPropertyToEntity(property);

        try {
        	propertyRepository.addProperty(p);
        } catch (Exception ex) {
            Logger.getLogger(PropertyManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Search a property by Id
     */
    public Property searchPropertyById(int id) {
        try {
            return propertyRepository.searchPropertyById(id);
        } catch (Exception ex) {
            Logger.getLogger(PropertyManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Set<Property> searchPropertyByContactPersonId(int contactPersonId) {
        try {
            //retrieve contact person by id
            for (ContactPerson contactPerson : propertyRepository.getAllContactPeople()) {
                if (contactPerson.getConactPersonId() == contactPersonId) {
                    return propertyRepository.searchPropertyByContactPerson(contactPerson);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<ContactPerson> getAllContactPeople() throws Exception {
        try {
            return propertyRepository.getAllContactPeople();
        } catch (Exception ex) {
            Logger.getLogger(PropertyManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void removeProperty(int propertyId) {
        try {
        	propertyRepository.removeProperty(propertyId);
        } catch (Exception ex) {
            Logger.getLogger(PropertyManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editProperty(Property property) {
        try {
            String s = property.getAddress().getStreetNumber();
            Address address = property.getAddress();
            address.setStreetNumber(s);
            property.setAddress(address);

            propertyRepository.editProperty(property);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Property has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(PropertyManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Property> searchPropertyByBudget(double budget) {
        try {
            return propertyRepository.searchPropertyByBudget(budget);
        } catch (Exception ex) {
            Logger.getLogger(PropertyManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }


    private Property convertPropertyToEntity(Property localProperty) {
        try {
            Property property = new Property(); //entity
            String streetNumber = localProperty.getStreetNumber();
            String streetAddress = localProperty.getStreetAddress();
            String suburb = localProperty.getSuburb();
            String postcode = localProperty.getPostcode();
            String state = localProperty.getState();
            Address address = new Address(streetNumber, streetAddress, suburb, postcode, state);
            property.setAddress(address);
            property.setNumberOfBedrooms(localProperty.getNumberOfBedrooms());
            property.setPrice(localProperty.getPrice());
            property.setSize(localProperty.getSize());
            property.setPropertyId(localProperty.getPropertyId());
            property.setTags(localProperty.getTags());
            property.setContactPerson(localProperty.getContactPerson());
            return property;
        } catch (Exception ex) {

        }
        return null;
    }

     public void addPropertyID() {
        compareProperty.addProperty(searchPropertyById(selectedId));
        selectedId = 0;
    }
    
    public void removePropertyID() {
        compareProperty.removeProperty(searchPropertyById(selectedId));
        selectedId = 0;
    }    
    
    public String bestPerRoom()
    {
        bestPerRoom = compareProperty.getBestPerRoom();
        return "index";
    }
    
    public int getFinalPropertyId() {
    	return propertyRepository.getPropertyId();
    }
    
}
