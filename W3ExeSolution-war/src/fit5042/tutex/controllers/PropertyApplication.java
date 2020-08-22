package fit5042.tutex.controllers;

import java.util.ArrayList;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import fit5042.tutex.mbeans.PropertyManagedBean;
import javax.inject.Named;
import fit5042.tutex.repository.entities.Property;
import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 * The class is a demonstration of how the application scope works. You can
 * change this scope.
 *
 * @author Guan
 */
@Named(value = "propertyApplication")
@ApplicationScoped

public class PropertyApplication {

    //dependency injection of managed bean here so that we can use its methods
    @ManagedProperty(value = "#{propertyManagedBean}")
    PropertyManagedBean propertyManagedBean;

    private static final ArrayList<Property> properties = new ArrayList<>();

    private boolean showForm = true;

    public boolean isShowForm() {
        return showForm;
    }

    // Add some property data from db to app 
    public PropertyApplication() throws Exception {
        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        propertyManagedBean = (PropertyManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "propertyManagedBean");
        
        if (properties != null && properties.size() > 0)
        {
        } else {
            //get properties from db 
            updatePropertyList();
        }
    }
    
    public ArrayList<Property> getProperties() {
        return properties;
    }

    private void setProperties(ArrayList<Property> newProperties) {
        //this.properties = newProperties;
    }

    //when loading, the property list needs to be populated if properties not present 
    public void updatePropertyList() {
        if (properties != null && properties.size() > 0)
        {
            
        }
        else
        {
            properties.clear();

            for (Property property : propertyManagedBean.getAllProperties()) {
                properties.add(property);
            }

            setProperties(properties);
        }
    }

    public void searchPropertyById(int propertyId) {
        properties.clear();

        properties.add(propertyManagedBean.searchPropertyById(propertyId));
    }

    public void searchPropertyByBudget(double budget) {
        properties.clear();

        for (Property property : propertyManagedBean.searchPropertyByBudget(budget)) {
            properties.add(property);
        }

        setProperties(properties);
    }

    public void searchPropertyByContactPersonId(int contactPersonId) {
        properties.clear();
        Set<Property> propertiesByContactPerson = propertyManagedBean.searchPropertyByContactPersonId(contactPersonId);
        for (Property property : propertiesByContactPerson) {
            properties.add(property);
        }

    }
    
    public void searchAll()
    {
        properties.clear();

        for (Property property : propertyManagedBean.getAllProperties()) {
            properties.add(property);
        }

        setProperties(properties);
    }
    
}
