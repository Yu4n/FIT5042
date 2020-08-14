package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.inject.Named;

import fit5042.tutex.constants.CommonInstance;
import fit5042.tutex.entities.Property;
import fit5042.tutex.mbeans.PropertyManagedBean;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author Messom
 * @author Guan
 */
@Named("propertyController")
@RequestScoped
public class PropertyController {

    private int propertyId; //this propertyId is the index, don't confuse with the Property Id

    static @ManagedProperty("#{propertyApplication}")
    PropertyApplication propertyApplication;
    
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }
    private Property property;
    

    public PropertyController() {
        // Assign property identifier via GET param 
        //this propertyID is the index, don't confuse with the Property Id
    	try {
    		propertyId = Integer.valueOf(FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRequestParameterMap()
                    .get("propertyID"));
    	} catch (Exception ex) {
    		propertyId = 1;
    	}
    	
        
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
    	propertyApplication = (PropertyApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, "propertyApplication");
        
    	
        // Assign property based on the id provided 
        property = getProperty();
    }

    public Property getProperty() {
        if (property == null) {
            // Get application context bean PropertyApplication 
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            PropertyApplication app
                    = (PropertyApplication) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "propertyApplication");
        	
            // -1 to propertyId since we +1 in JSF (to always have positive property id!) 
            return app.getProperties().get(--propertyId); //this propertyId is the index, don't confuse with the Property Id

        }
        return property;
    }
}