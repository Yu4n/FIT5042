/*
 * To change this license header, choose License Headers in Project Properties.
 */
package fit5042.tutex.mbeans;

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
 */
@ManagedBean(name = "propertyManagedBean")
@SessionScoped

public class PropertyManagedBean implements Serializable {

    @EJB
    PropertyRepository propertyRepository;

    /**
     * Creates a new instance of PropertyManagedBean
     */
    public PropertyManagedBean() {
    }

    public List<Property> getAllProperties() {
        try {
            List<Property> properties = propertyRepository.getAllProperties();
            return properties;
        } catch (Exception ex) {
            Logger.getLogger(PropertyManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addProperty(Property property) {
        try {
            propertyRepository.addProperty(property);
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

    public Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson) {
        try {
            return propertyRepository.searchPropertyByContactPerson(contactPerson);
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

    public void addProperty(fit5042.tutex.controllers.Property localProperty) {
        //convert this newProperty which is the local property to entity property
        Property property = convertPropertyToEntity(localProperty);

        try {
            propertyRepository.addProperty(property);
        } catch (Exception ex) {
            Logger.getLogger(PropertyManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Property convertPropertyToEntity(fit5042.tutex.controllers.Property localProperty) {
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
        int conactPersonId = localProperty.getConactPersonId();
        String name = localProperty.getName();
        String phoneNumber = localProperty.getPhoneNumber();
        ContactPerson contactPerson = new fit5042.tutex.repository.entities.ContactPerson(conactPersonId, name, phoneNumber);
        if (contactPerson.getConactPersonId() == 0) {
            contactPerson = null;
        }
        property.setContactPerson(contactPerson);
        return property;
    }

}
