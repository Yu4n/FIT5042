package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Messom
 * @author Guan
 */
@Named(value = "propertyController")
@RequestScoped
public class PropertyController {

    private int propertyId; //this propertyId is the index, don't confuse with the Property Id

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }
    private fit5042.tutex.repository.entities.Property property;

    public PropertyController() {
        // Assign property identifier via GET param 
        //this propertyID is the index, don't confuse with the Property Id
        propertyId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("propertyID"));
        // Assign property based on the id provided 
        property = getProperty();
    }

    public fit5042.tutex.repository.entities.Property getProperty() {
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
