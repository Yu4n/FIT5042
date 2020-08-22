package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.inject.Named;

import fit5042.tutex.repository.entities.Property;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author Messom
 * @author Guan
 */
@Named(value = "propertyController")
@RequestScoped
public class PropertyController {

    
    static @ManagedProperty(value = "#{propertyApplication}")
    PropertyApplication propertyApplication;
    
    private int propertyId; //this propertyId is the index, don't confuse with the Property Id

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }
    private Property property;

    public PropertyController() throws Exception {
        //this propertyID is the index, don't confuse with the Property Id
        propertyId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("propertyID"));

        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        propertyApplication = (PropertyApplication) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "propertyApplication");
        
        property = getProperty();

    }

    public Property getProperty() throws Exception {
        if (property == null) 
            return propertyApplication.getProperties().get(--propertyId); //this propertyId is the index, don't confuse with the Property Id
        
        return property;
    }
}
